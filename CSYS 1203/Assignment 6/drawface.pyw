# drawface.pyw
# Michael McQuade

# Assignment (for reference):
# Write and test a function to meet this specification:
# drawFace(center, size, win) center is a Point, size is an int, and win is a GraphWin.
# Draws a simple face of the given size in win.
# Your function can draw a simple smiley (or grim) face.
# Demonstrate the function by writing a program that draws several faces of varying size in a single window.


from graphics import *

def drawFace(center, size, win):

    #First let's draw a circle for our face

    face = Circle(center, size)
    face.setFill(color_rgb(255, 255, 0))
    face.draw(win)

    #Here we'll create all of our graphics objects for our face

    r = size / 2
    faceX = center.getX()
    faceY = center.getY()
    leftEye = Point(faceX - (r * .75), faceY - (r * .75))
    rightEye = leftEye.clone()
    rightEye.move((r * .75) * 2, 0)
    smileLeft = Line(Point(faceX - (r * .75), faceY + (r * .75)), Point(faceX - (r * .75), faceY + (r * .50)))
    smileBottom = Line(Point(faceX - (r * .75), faceY + (r * .75)), Point(faceX + (r * .75), faceY + (r * .75)))
    smileRight = Line(Point(faceX + (r * .75), faceY + (r * .75)), Point(faceX + (r * .75), faceY + (r * .50)))

    #Lastly, we'll draw these objects into our graphWin object

    leftEye.draw(win)
    rightEye.draw(win)
    smileLeft.draw(win)
    smileBottom.draw(win)
    smileRight.draw(win)


def main():
    window = GraphWin("Smiling Faces", 800, 600)

    # Now we'll just create several faces in our window.

    drawFace(Point(100, 100), 30, window)
    drawFace(Point(50, 50), 5, window)
    drawFace(Point(250, 100), 100, window)
    drawFace(Point(700, 500), 50, window)
    drawFace(Point(600, 450), 25, window)

    window.getMouse() #This is added to keep our window open.


main()