#Robot Teleoperation (35 points)

The robot you will be controlling is a flying quadrotor, the Parrot ARDrone. There is a fair amount of software infrastructure that goes into translating movement commands into differential rotor speeds that drive the robot around, but I (and others) have taken care of that for you. The robot is listening for instructions delivered over the network in a particular format; your task will be to send those instructions based on the controls your application user is sending. Since not all of you have a robot to test your code with, I have written a robot simulator that sits on the web. You can point a web browser at http://lear.cs.okstate.edu/robot_sim.html.

When you connect with your application and send the correct messages, the robot on the web will move appropriately. Note that there is only one simulator running; if several people are testing their programs at the same time, the simulated robot will be responding to all of their instructions at once. The results may be amusing.

Upon starting up, your program should establish a connection with the robot. This is done by opening a Socket for writing at IP address “lear.cs.okstate.edu” and port “9095”. Notice that this port is located at the same address as the web server; that’s because the robot simulator is running there and piping its output to the web page.

After the assignment is turned in, you will have the opportunity to use your controller to fly a real robot, which might have a different IP address. Make sure it’s easy to change.

The messages you will be sending to the robot are encoded in a format called JSON, which is a simple text format for sending objects over the internet. It is simple, but it is not terribly easy to work with in Java, because JSON strings include a lot of quotation marks. And as you well know, quotation marks begin and end a `String` in Java, which means that assembling strings with internal quotation marks is a little messy – you have to escape them with backslashes.

A generic JSON message looks like the following:

```JSON
{"name1":"stringvalue1", "name2":numericvalue, "object":{"instance":"value"}}
```
Thus, it is a series of name-value pairs, with curly brackets denoting object nesting levels and quotation marks surrounding every string (but not numbers).

Your program will send three different kinds of messages to the robot: a takeoff instruction, a land instruction and a move instruction.

The JSON for the takeoff instruction is:
```JSON
{"op":"publish","topic":"/ardrone/takeoff","msg":{}}
```

In order to construct this string in Java, you will have to write something like the following:

```Java
String takeoff_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
```

It’s messy, but it’s the way JSON is formatted and the way Java functions.

The message for landing is very similar:
```JSON
{"op":"publish","topic":"/ardrone/land","msg":{}}
```

The movement message is significantly more complicated, because you are sending actual information. It contains six numbers corresponding to the linear and angular velocities along the robot’s various axes.

This is what a message telling the robot to stop moving looks like:
```JSON
{"op":"publish",
"topic":"/cmd_vel",
"msg":{"linear":{"x":0,
"y":0,
"z":0},
"angular":{"x":0,
"y":0,
"z":0}}}
```

I’ve inserted formatting line breaks and spaces to make it easier to read; the actual message is all one line just like the takeoff and land messages.

The robot is able to move in four of these six dimensions. A positive linear x number tells the robot to move forward, negative means backward. Linear y is the left/right dimension, and linear z is the up/down (altitude) dimension. All of these values are in meters/second. A positive angular z velocity means rotate to the left, negative means to the right, in radians per second.

Although movement messages also contain fields for angular x (roll) and angular y (pitch), this particular robot cannot rotate freely around those axes, so those fields should always be 0.

After you have connected the Socket and sent the handshake message, you can send these JSON messages as often as you like. Make sure you flush your output buffer after you send each message.

Your program should provide the user with a set of controls – exactly how they are displayed and used is up to you. The controls should allow the user to takeoff and land, move forward and backward, up and down, right and left, and turn. When the user indicates that she wants the robot to move in a specific way, the program must construct the appropriate JSON message and send it over the wire.

Note that the program must also figure out how and when to send a message for the
robot to stop, otherwise it will keep going until it crashes. If the messages are being formatted and sent correctly, the behavior will show up in the robot simulator.

Note that you will get no feedback if they are not correct (except that the darn robot won’t move); think about how you can print out intermediate results for testing.

The robot is also a physical object that is subject to physical laws and physical damage; I suggest limiting your linear speeds to +/- 0.25 m/s and your angular speed to +/- 1 radian/s.

Note: The JSON specification is unnecessarily strict about what a number should look like. Decimals between -1 and 1 must have a leading zero digit. `.25` is wrong; it must be written `0.25`.

Note: The robot in the simulator is facing down when the webpage is first loaded, so a command to move forward should make the image travel down toward the bottom of the screen, and a command to move left will send it to the robot’s left, which is to the right, viewed from your perspective – at least until you start sending it commands to turn.

**Extra Credit:** Add adjustable speed controls to your user interface that make the robot speed up and slow down.
