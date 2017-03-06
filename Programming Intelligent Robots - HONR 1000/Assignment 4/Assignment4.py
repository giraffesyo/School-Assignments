#!/usr/bin/env python

import rospy
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

        self.bearingGoal = 320
        self.bearingP = .02
        self.bearingI = .02
        self.bearingD = .02

        self.bearingPID = PID(self.bearingGoal, self.bearingP, self.bearingI, self.bearingD)

        self.distanceGoal = 1.5
        self.distanceP = 1
        self.distanceI = 1
        self.distanceD = 1
        self.distancePID = PID(self.distanceGoal, self.distanceP, self.distanceI, self.distanceD)

        self.ballBearing = -1
        self.ballDistance = -1

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
                    if self.bearingGoal - self.ballBearing < 5:
                        if self.ballDistance > 1.5:
                            twist.angular.z = 0
                            twist.linear.x = 1
                            self.Twistpub.publish(twist)
                        else:
                            self.lastChange = rospy.Time.now()
                            self.state = "kick"
                    else:
                        twist.linear.x = 0
                        print "bearingPID.get results: " + str(self.bearingPID.get_output(self.ballBearing))
                        twist.angular.z = self.bearingPID.get_output(self.ballBearing)*.01
                        # Publish twist
                        self.Twistpub.publish(twist)
                    # when ready to implement kick we set timer here (self.lastchange)
            elif self.state == "kick":  # Drive forward at 1 m/s for 1.5 seconds
                twist.linear.x = 1
                twist.angular.z = 0
                self.Twistpub.publish(twist)
                # If enough time has elapsed, change to the "turn" state
                if (rospy.Time.now() - self.lastChange) > rospy.Duration.from_sec(1.5):
                    print("More than 1.5 seconds has elapsed, searching for ball")
                    self.state = "search"
                    self.lastChange = rospy.Time.now()
            elif self.state == "search":  # "turn"  # Check to see if we have a valid location
                print "self.ballDistance: " + str(self.ballDistance)
                print "self.ballBearing: " + str(self.ballBearing)
                if (self.ballDistance != -1) and (self.ballBearing != -1):
                    self.state = "approach"
                else:
                    # Turning at 1 radian per second
                    twist.linear.x = 0
                    twist.angular.z = .5
                    # Publish twist message
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
