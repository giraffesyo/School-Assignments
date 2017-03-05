#!/usr/bin/env python

import rospy
from geometry_msgs.msg import Twist
from kobuki_msgs.msg import BumperEvent

hertz = 10

class Robot:
   

  def __init__(self):
        
    # Define an instance variable (self.pub, say) to hold the rospy.Publisher.
    # It should publish Twist messages on the '/mobile_base/commands/velocity' topic.
    self.pub = rospy.Publisher('/mobile_base/commands/velocity', Twist, queue_size=hertz)
    #rospy.init_node('roomExiter')
    # Subscribe to the BumperEvent messages that the robot driver publishes
    # on the '/mobile_base/events/bumper' topic.
    # It should identify the method to be called when a message arrives: self.bumped
    rospy.Subscriber('/mobile_base/events/bumper', BumperEvent, self.bumped)
    
    # Set up a variable to hold the robot's state (self.state, perhaps?)
    self.state = "forwards" 
    # and a variable to keep track of the time of the last state change
    self.lastChange = 0

  def bumped(self, msg):
    # If the BumperEvent message says that we just hit something,
    # and we are currently in the "go forward" state, change
    # to the "go backward" state. Make a note of the time.
    #print("BumperEvent.state = " + str(msg.state))
    #print("BumperEvent.bumper = " + str(msg.bumper))
    if msg.state == 1:
      #if self.state == "forwards":
      print("We've bumped into something changing from forwards to backwards state. (Currently" + self.state + ")")
      self.state = "backwards"
      self.lastChange = rospy.Time.now()

  def run(self):
    rate = rospy.Rate(hertz)
    twist = Twist()
    while not rospy.is_shutdown():
      #print("We're in state: " + self.state) #spams state
      if self.state == "forwards":  #"go forward"
      # Set twist.linear.x to a positive value <= 0.2
	twist.linear.x = 0.2
	twist.angular.z = 0
      # Publish twist
	self.pub.publish(twist)
      elif self.state == "backwards": #"go backward":
      # Set twist.linear.x to a negative value >= -0.2
	twist.linear.x = -0.2
	twist.angular.z = 0
      # Publish twist
	self.pub.publish(twist)
      # If enough time has elapsed, change to the "turn" state
	if (rospy.Time.now() - self.lastChange) > rospy.Duration.from_sec(2):
          print("More than 2 seconds has elapsed, turning now (Currently" + self.state + ")")
	  self.state = "turn"
	  self.lastChange = rospy.Time.now()
      elif self.state == "turn": #"turn"
      # Set twist.angular.z to a nonzero value
	twist.linear.x = 0
	twist.angular.z = 1
      # Publish twist
	self.pub.publish(twist)
      # If enough time has elapsed, change to the "go forward" state
	if rospy.Time.now() - self.lastChange > rospy.Duration.from_sec(1):
          print("More than a second has elapsed, going forwards(Currently" + self.state + ")")
	  self.state = "forwards"
      rate.sleep()

rospy.init_node('prison_break')
robot = Robot()
robot.run()
