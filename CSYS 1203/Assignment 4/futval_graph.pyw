# futval_graph2.pyw
# By Michael McQuade

from graphics import *


def main():
    # Create our window object and setup our coordinate system
    win = GraphWin("Investment Growth Chart", 640, 480)
    win.setBackground("white")
    win.setCoords(-1.75, -600, 11.5, 10400)

    # Create text input boxes for APR and Principal
    textlabel = Text(Point(5, 6000), 'Enter initial investment:')
    textlabel.draw(win)
    textbox = Entry(Point(5, 5000), 15)
    textbox.setText("0")
    textbox.draw(win)
    _prompt = Rectangle(Point(3, 4000), Point(7, 2000))
    _prompt.draw(win)
    ButtonText = Text(_prompt.getCenter(), "Submit")
    ButtonText.draw(win)
    win.getMouse()

    #Get principal's value and APR from entry point
    principal = eval(textbox.getText())
    textbox.setText("0")
    textlabel.setText('Enter investment APR:')
    win.getMouse()
    apr = eval(textbox.getText())

    #Clean up buttons and prompt
    textbox.undraw()
    ButtonText.undraw()
    _prompt.undraw()

    #Move label so it's ready for total later
    textlabel.move(0, -6400)


    # Setup labels and position them
    Text(Point(-1, 0), ' 0.0K').draw(win)
    Text(Point(-1, 2500), ' 2.5K').draw(win)
    Text(Point(-1, 5000), ' 5.0K').draw(win)
    Text(Point(-1, 7500), ' 7.5k').draw(win)
    Text(Point(-1, 10000), '10.0K').draw(win)

    # Draw bar for initial principal
    bar = Rectangle(Point(0, 0), Point(1, principal))
    bar.setFill("green")
    bar.setWidth(2)
    bar.draw(win)

    # Do math on principal and draw bars for each year
    for year in range(1, 11):
        principal = principal * (1 + apr)
        bar = Rectangle(Point(year, 0), Point(year + 1, principal))
        bar.setFill("green")
        bar.setWidth(2)
        bar.draw(win)

    #Tell user how much their investment is worth and wait for a mouse click to close the program
    textlabel.setText("The value of your investment after 10 years is: " + str(round(principal)))
    win.getMouse()
    win.close()




main()
