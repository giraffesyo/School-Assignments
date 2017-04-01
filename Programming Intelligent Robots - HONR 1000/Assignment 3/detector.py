#!/usr/bin/env python

import roslib
roslib.load_manifest('assignment3')
import rospy
import cv2
import math
from sensor_msgs.msg import Image, LaserScan
from assignment3.msg import BallLocation
from cv_bridge import CvBridge, CvBridgeError

class Detector:

	def __init__(self):
		# The image publisher is for debugging and figuring out
		# good color values to use for ball detection
		self.impub = rospy.Publisher('/ball_detector/image', Image, queue_size=1)
		self.locpub = rospy.Publisher('/ball_detector/ball_location', BallLocation, queue_size=1)

		self.bridge = CvBridge()
		self.bearing = -1
		self.distance = -1

		rospy.Subscriber('/camera/rgb/image_raw', Image, self.handle_image)
		rospy.Subscriber('/scan', LaserScan, self.handle_scan)

	def handle_image(self, msg):
		try:
			image = self.bridge.imgmsg_to_cv2(msg, "bgr8")
		except CvBridgeError, e:
			print e
	
		# Find the average column of the bright yellow pixels
		# and store as self.bearing. Store -1 if there are no
		# bright yellow pixels in the image.
		# Feel free to change the values in the image variable
		# in order to see what is going on
		
		image = cv2.cvtColor( image, cv2.COLOR_BGR2HSV) # I converted to HSV so we can try to find the object
    	
		#create yellow bar in middle of screen for visual purposes
		image[240:250,:,0] = 35
		image[240:250,:,1] = 150
		image[240:250,:,2] = 150
		
		self.bearing = 0
		Sum = 0;
		Count = 0;
		# we're checking only bottom half of screen, step by 5
		for x in range(240, 480,5): 
			for y in range(0, 640, 5):
				# chose these by converting using cv2.cvtColor, yellow is HSV (35, 150-250,150-250)
				if ( (image[x,y,0] < 40) and (image[x,y,0] >20) and (image[x,y,1] > 150) and (image[x,y,2] > 150)): 
					#print ( " Found hue: " + str(image[x,y,0]) + "at " 		)		
					Sum += y
					Count+= 1
	
		if Count < 5:
			self.bearing = -1 #no x value because no yellow found
		else:
			self.bearing = Sum / Count # bearing is the avg of all x values where yellow was found

		#vertical line tracking ball on feed
		

		image = cv2.cvtColor( image, cv2.COLOR_HSV2BGR) # convert back to BGR from HSV
		image[:, self.bearing-10:self.bearing+10,1] = 2 

		# Here we publish the modified image; it can be
		# examined by running image_view
		self.impub.publish(self.bridge.cv2_to_imgmsg(image, "bgr8")) # publishing the new image with my bars moving around on it

	def handle_scan(self, msg):
		# If the bearing is valid, store the corresponding range
		# in self.distance. Decide what to do if range is NaN.
		self.distance = msg.ranges[-self.bearing]
		if ( math.isnan(self.distance) ):
			self.distance = -1.0
			#self.bearing = -1.0

	def start(self):
		rate = rospy.Rate(10)
		while not rospy.is_shutdown():
			location = BallLocation()
			location.bearing = self.bearing
			location.distance = self.distance
			self.locpub.publish(location)
			print( "Bearing: " + str(self.bearing) + " Distance: " + str(self.distance))
			rate.sleep()
rospy.init_node('ball_detector')
detector = Detector()
detector.start()
