#!/usr/bin/env python

import rospy
import math
import tf2_ros
from geometry_msgs.msg import Twist
from assignment3.msg import BallLocation
from tf.transformations import euler_from_quaternion
from nav_msgs.msg import Odometry
from kobuki_msgs.msg import BumperEvent

hertz = 10


class Robot:
	def __init__(self):

		self.Twistpub = rospy.Publisher('/mobile_base/commands/velocity', Twist, queue_size=hertz)

		# Subscribing to the Ball Location message put out by detector.py
		# this message will give us an object with bearing and distance
		# when we see a message, we pass it to self.gotLocation
		rospy.Subscriber('/ball_detector/ball_location', BallLocation, self.ballLocation) 

		# Subscribing to odom
		rospy.Subscriber('/odom', Odometry, self.handle_pose)

		rospy.Subscriber('/mobile_base/events/bumper', BumperEvent, self.bumped)

		# we will start in search mode, looking for the ball
		self.state = "search"
		# and a variable to keep track of the time of the last state change
		self.lastChange = 0
		self.maxLinearX = 1.0
		self.maxAngularZ = 1.0

		self.bearingGoal = 320
		self.bearingP = .004125 #1/320
		self.bearingI =  0 #.000001
		self.bearingD = 0 #.25

		self.bearingPID = PID(self.bearingGoal, self.bearingP, self.bearingI, self.bearingD)
		self.bearingTolerance = 10

		self.distanceGoal = 1.5
		self.distanceP = -0.2
		self.distanceI = 0
		self.distanceD = 0

		self.distancePID = PID(self.distanceGoal, self.distanceP, self.distanceI, self.distanceD)
		self.distanceTolerance = .25


		self.thetaGoal = 0
		self.thetaP = 2
		self.thetaI = 0
		self.thetaD = 0
		self.thetaPID = PID(self.thetaGoal, self.thetaP, self.thetaI, self.thetaD)

		self.intermediateGoal = 0
		self.intermediateP = -.005
		self.intermediateI = -.0001
		self.intermediateD = 0
		self.intermediatePID = PID(self.intermediateGoal, self.intermediateP, self.intermediateI, self.intermediateD)

		self.ballBearing = -1.0
		self.ballDistance = -1.0
		self.kickPositionX = -1.0
		self.kickPositionY = -1.0

		self.intermediateX = -1.0 # storing the x coordinate of the intermediate goal here
		self.intermediateY = -1.0 # storing the y coordinate of the intermediate goal here

		#goal (place you kick to score) information 
		self.listener = tf2_ros.Buffer()
		tf2_ros.TransformListener(self.listener)
		self.goal_x = self.goal_y = 0.0

		self.twist = Twist()

	def ballLocation(self, msg):
		# Store ball location into instance variables so we can access them in state machine loop
		self.ballBearing = msg.bearing
		self.ballDistance = msg.distance

	def bumped(self, msg):
		if msg.state == 1:
			self.state = "back up"
			self.lastChange = rospy.Time.now() # record time so we know when to stop backing up

	def run(self):
		rate = rospy.Rate(hertz)
		while not rospy.is_shutdown():
			#Ar marker
			try:
				trans = self.listener.lookup_transform('odom', 'ar_marker_0', rospy.Time())
				self.goal_x = trans.transform.translation.x
				self.goal_y = trans.transform.translation.y
				except tf2_ros.LookupException:
					pass
				except tf2_ros.ConnectivityException:
					pass
				except tf2_ros.ExtrapolationException:
					pass
			# print("We're in state: " + self.state) #spams state
			if self.state == "back up":
				self.reverse()			
			elif self.state == "approach":  # "go forward"
				self.approach()
			elif self.state == "search":
				self.search()
			elif self.state == "navigate to intermediate":
				self.navigateIntermediate()
			elif self.state == "navigate to kick":
				self.navigateKick()
			elif self.state == "line up":
				self.lineUp()
			elif self.state == "kick":  # Drive forward at 1 m/s for 1.5 seconds
				self.kick()

			print "We're in state: " + self.state
			self.limitSpeeds() # makes sure we don't go over our max speeds
			self.Twistpub.publish(self.twist) 
			rate.sleep()

	def search(self):
		# If we don't see the ball at all
		if self.ballBearing == -1 or self.ballDistance == -1:
			self.twist.linear.x = 0
			self.twist.angular.z = self.maxAngularZ
		else:
			self.state = "approach"

	def approach(self):
		# check if we should change back to search
		if (self.ballDistance == -1) or (self.ballBearing == -1):
			self.state = "search"
		else:
			#if we're not within .25 meters of the distance goal or not within 10 of the bearing goal,
			# we should adjust our position
			if abs(self.ballDistance - self.distanceGoal) > self.distanceTolerance or ((abs(self.ballBearing - self.bearingGoal)) > self.bearingTolerance):
				self.twist.angular.z = self.bearingPID.get_output(self.ballBearing)
				self.twist.linear.x = self.distancePID.get_output(self.ballDistance)
			else: #we're within .25 of the distance goal and 10 of the bearing goal. 
				# we need to calculate where we want to be to kick the ball
				self.kickPositionX = self.x + (2 * self.ballDistance * math.cos(self.theta))
				self.kickPositionY = self.y + (2 * self.ballDistance * math.sin(self.theta)) #(6(sqrt(2)))/2 this is double the distance from the intermediate goal
				
				goalBearing = self.theta + math.pi/4
				#goalDistance = self.y + (3*(math.sqrt(2)))/2
				
				self.intermediateX = self.x + ( self.ballDistance * math.sqrt(2) * math.cos(goalBearing)) 
				self.intermediateY = self.y + (self.ballDistance * math.sqrt(2) * math.sin(goalBearing)) #right side of triangle 
				self.state = "navigate to intermediate"
		print "Ball Distance is: ", self.ballDistance, " Bearing is", self.ballBearing

	def navigateIntermediate(self):
		#print "self.theta: ", self.theta, " self.x: ", self.x, " self.y: ", self.y, " intermediateX: ", self.intermediateX, " intermediateY: ", self.intermediateY  
		intermediateBearing, intermediateDistance = get_vector(self.x, self.y, self.intermediateX, self.intermediateY)
		print "intermediateBearing: ", intermediateBearing, " intermediateDistance: ", intermediateDistance
		print "Current position: (", self.x, ",", self.y, ") Goal position: (", self.intermediateX, ",", self.intermediateY, ")"
				
		if (intermediateBearing > math.pi):
			intermediateBearing = intermediateBearing - 2*(math.pi)
		elif (intermediateBearing < -math.pi):
			intermediateBearing = intermediateBearing + 2*(math.pi)	
		if ( abs(intermediateDistance) < .4): #we're within .2 meters of our goal, lets try to get in position to kick
			self.state = "navigate to kick"
		else:
			self.twist.linear.x = self.intermediatePID.get_output(intermediateDistance)
			self.twist.angular.z = self.thetaPID.get_output(self.theta - intermediateBearing)
		#we're going to change to navigateKick


	def navigateKick(self):
		kickBearing, kickDistance = get_vector(self.x, self.y, self.kickPositionX, self.kickPositionY)
		if (kickBearing > math.pi):
			kickBearing = kickBearing - 2*(math.pi)
		elif (kickBearing < -math.pi):
			kickBearing = kickBearing + 2*(math.pi)	
		print "Current position: (", self.x, ",", self.y, ") Goal position: (", self.kickPositionX, ",", self.kickPositionY, ")"
		 
		self.twist.angular.z = self.thetaPID.get_output(self.theta - kickBearing)
		self.twist.angular.x = self.intermediatePID.get_output(kickDistance)
		#we're going to change to lineUp
		if (abs(kickDistance) < .4):
			self.state = "line up"

	def lineUp(self):
		self.twist.linear.x = 0
		#self.twist.angular.z = self.bearingPID.get_output(self.ballBearing)
		if self.ballBearing == -1 or self.ballDistance == -1:
			self.twist.linear.x = 0
			self.twist.angular.z = self.maxAngularZ
		else:
			if (abs(self.ballBearing - self.bearingGoal) > self.bearingTolerance):			
				self.twist.angular.z = self.bearingPID.get_output(self.ballBearing)
				self.twist.linear.x = 0			
			else:				
				self.lastChange = rospy.Time.now() # record how long we're in kick state		
				self.state = "kick"

	def kick(self):
		self.twist.linear.x = self.maxLinearX
		self.twist.angular.z = 0
		# If enough time has elapsed, change to the "search" state
		if (rospy.Time.now() - self.lastChange) > rospy.Duration.from_sec(1.5):
			print "More than 1.5 seconds has elapsed, searching for ball"
			self.state = "search"
			self.lastChange = rospy.Time.now()

	def reverse(self):
		if( rospy.Time.now() - self.lastChange) > rospy.Duration.from_sec(2):
			self.state = "search"
		else:
			self.twist.linear.x = -0.2
			self.twist.angular.z = 0.0
		

	def handle_pose(self, msg):
		self.x = msg.pose.pose.position.x
		self.y = msg.pose.pose.position.y
		q = (msg.pose.pose.orientation.x, msg.pose.pose.orientation.y,
			 msg.pose.pose.orientation.z, msg.pose.pose.orientation.w)
		(_,_, self.theta) = euler_from_quaternion(q)

	def limitSpeeds(self):
		if self.twist.linear.x > self.maxLinearX:
			self.twist.linear.x = self.maxLinearX
		if self.twist.linear.x < -self.maxLinearX:
			self.twist.linear.x = -self.maxLinearX
		if self.twist.angular.z < -self.maxAngularZ:
			self.twist.angular.z = -self.maxAngularZ
		if self.twist.angular.z > self.maxAngularZ:
			self.twist.angular.z = self.maxAngularZ		

def get_vector(from_x, from_y, to_x, to_y):
	bearing = math.atan2(to_y - from_y, to_x - from_x) # in radians
	distance = math.sqrt((from_x - to_x)**2 + (from_y - to_y)**2)
	return (bearing, distance)

		
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
