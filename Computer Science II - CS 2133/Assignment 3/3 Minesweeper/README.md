Minesweeper (50 points)

You are going to write the game of Minesweeper. The Minesweeper board is a graphical grid of squares. A certain number of squares, chosen randomly, conceal dangerous mines. Play proceeds when a user left-clicks on a square. If that square hides a mine, the game is over and the player loses. If not, then stepping on the square reveals the number of mines hidden by squares adjacent to that square – a number between 0 and 8. A player can right-click on a square that has not yet been stepped on to mark it as being potentially mined, and remove the mark with another right-click.

![Figure 1](https://i.stack.imgur.com/y0eJq.png) . 
Figure 1: A half-completed game of Minesweeper with a rudimentary design.

Figure 1 shows a game in progress. Numbers represent squares that have been clicked, ’F’s are places the player has placed a flag, and ’?’s are squares that have not yet been clicked. This is a singularly unattractive gameboard; you are welcome to add icons or grid squares or any other kinds of graphics to liven up your own version.

You are responsible for designing and implementing the whole game. This is a big task; start early.

Here are some suggestions:

- Model-View-Controller architecture! Implement a minesweeper class that plays the game
without relying on any GUI elements, instead using method calls for making moves and
sending information. This is the model. The paintComponent methods of your UI objects
should ask this model what to display. This is the view. The event handlers should call the gameplay methods in the model. This is the controller. Don’t let things get mixed up or complicated!
- This is a perfect setting for using a `GridLayout`. Make it easy to change the number of squares on the board, maybe by setting a static final int.
- JButtons might be a good choice for board squares, but keep in mind that an `ActionListener` does not know how to respond to right-clicks. You will have to use a MouseAdapter instead. A grid full of JLabels or JButtons that have been extended to have access to the model, and to know where they sit in the grid, would work, as would other more attractive user interface elements.
- When you are setting up your board, you need to randomly determine whether each square
is mined or safe. You can select a specific number of squares to be mines, or you can assign each square’s status based on a certain probability of being a mine. The latter is easier.
- The class with the main method (Minesweeper.java) and the one extending your `JFrame`
should be only be a couple of lines. All of the heavy GUI lifting will probably be split
between the class that extends `JPanel` and the one that extends whatever you decide to use to represent individual grid squares. Your MouseListener can belong to either of these, but it’s probably easier if each individual square is given its own `MouseListener`. And the most important object, the model that actually implements the game, shouldn’t involve GUI at all!
- Make sure the program ends in a satisfying manner when the user clicks on a bomb.


**Extra Credit:** Because it is always safe to click every mine surrounding a square with a ’0’ in it, most commercial versions of the game will automatically do so, and then do it again for any new ’0’ squares uncovered. This can reveal large swaths of safe territory with a single click. Implement this functionality.

**Extra Credit:** In the header area of the JFrame’s `BorderLayout`, implement a counter showing
how many mines remain to be found. This should initially report the number of mines on the board, and decrement or increment whenever the player plants or removes a flag.

**Extra Credit:** Wow us with the graphic design of your game.
