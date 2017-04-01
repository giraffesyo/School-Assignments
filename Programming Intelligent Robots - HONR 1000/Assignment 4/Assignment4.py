#!/usr/bin/env python

import rospy
import math
from geometry_msgs.msg import Twist
from assignment3.msg import BallLocation

hertz = 10


class Robot:
    def __init__(self):

        self.Twistpub = rospy.Publisher('/mobile_base/commands/velocity', Twist, queue_size=hertz)

        # Subscribing to the Ball Location message put out by detector.py
        # this message will give us an object with bearing and distance
        # when we see a message, we pass it to self.gotLocation
        rospy.Subscriber('/ball_detector/ball_location', BallLocation, self.ballLocation)

        # we will start in search mode, looking for the ball
        self.state = "search"
        # and a variable to keep track of the time of the last state change
        self.lastChange = 0
        self.maxLinearX = 1.0
        self.maxAngularZ = 1.0

        self.bearingGoal = 320
        self.bearingP = .003125 #1/320
        self.bearingI = .00001
        self.bearingD = .25

        self.bearingPID = PID(self.bearingGoal, self.bearingP, self.bearingI, self.bearingD)

        self.distanceGoal = 1.5
        self.distanceP = -0.4
        self.distanceI = 0
        self.distanceD = 0
        self.distancePID = PID(self.distanceGoal, self.distanceP, self.distanceI, self.distanceD)

        self.ballBearing = -1.0
        self.ballDistance = -1.0

    def ballLocation(self, msg):
        # Store ball location into instance variables so we can access them in state machine loop
        self.ballBearing = msg.bearing
        self.ballDistance = msg.distance

    def run(self):
        rate = rospy.Rate(hertz)
        twist = Twist()
        while not rospy.is_shutdown():
            # print("We're in state: " + self.state) #spams state
            if self.state == "approach":  # "go forward"
                # make sure we shouldn't be in search
                if (self.ballDistance == -1) or (self.ballBearing == -1):
                    self.state = "search"
                else:
                    # need a way to stop using PID
                    # and starting moving
                    # Set twist.angular.z to a positive PID value
                    if abs(self.ballDistance - 1.5) > .25 or ((abs(self.ballBearing - self.bearingGoal)) > 10):
                        twist.angular.z = self.bearingPID.get_output(self.ballBearing)
                        twist.linear.x = self.distancePID.get_output(self.ballDistance)
                    else:
                        self.lastChange = rospy.Time.now()
                        self.state = "kick"
                    # when ready to implement kick we set timer here (self.lastchange)
            elif self.state == "search":
                # If we don't see the ball at all
                if self.ballBearing == -1 or self.ballDistance == -1:
                    twist.linear.x = 0
                    twist.angular.z = self.maxAngularZ
                else:
                    self.state = "approach"
            elif self.state == "kick":  # Drive forward at 1 m/s for 1.5 seconds
                twist.linear.x = self.maxLinearZ
                twist.angular.z = 0
                # If enough time has elapsed, change to the "turn" state
                if (rospy.Time.now() - self.lastChange) > rospy.Duration.from_sec(1.5):
                    print "More than 1.5 seconds has elapsed, searching for ball"
                    self.state = "search"
                    self.lastChange = rospy.Time.now()
            print "We're in state: " + self.state, " Distance is: ", self.ballDistance, " Bearing is", self.ballBearing
            if twist.linear.x > self.maxLinearX:
                twist.linear.x = self.maxLinearX
            if twist.linear.x < -self.maxLinearX:
                twist.linear.x = -self.maxLinearX
            if twist.angular.z < -self.maxAngularZ:
                twist.angular.z = -self.maxAngularZ
            if twist.angular.z > self.maxAngularZ:
                twist.angular.z = self.maxAngularZ            
            self.Twistpub.publish(twist) 
            rate.sleep()


class PID:
    def __init__(self, goal, kp, ki, kd):
        self.goal = goal
        self.kp = kp
        self.ki = ki
        self.kd = kd
        self.previous_error = 0
        self.integral = 0

    def get_output(self, measurement):
        error = self.goal - measurement
        self.integral = self.integral + error
        derivative = error - self.previous_error
        output = self.kp * error + self.ki * self.integral + self.kd * derivative
        self.previous_error = error
        return output


rospy.init_node('prison_break')
robot = Robot()
robot.run()
