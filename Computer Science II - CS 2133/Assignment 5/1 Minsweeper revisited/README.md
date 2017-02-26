# 1 - Minesweeper revisited (30 points)

In this problem, we return to the Minesweeper game you wrote two assignments ago. First of all, if you did not get full credit on this question on Assignment 3, you have a chance to earn back some points here. Return to your code, now that we have gone over it and you have seen how to construct a working version using good MVC design. Refactor and fix it until you have a working game. This will net you half the points you lost on assignment 3.

For this assignment, you will enhance your Minesweeper game with a couple of features. Add a menu bar to your JFrame, with a "File" menu. 

This menu should include four menu items: "New", "Save", "Load" and "Quit":

- When a user selects "New", the game should elicit information about how di cult the new game should be. Exactly how this works is up to you { specifying a gameboard size, odds of encountering a mine, or simply selecting a di culty level.

- "Save" should save the current game state to disk. Present the user with a le chooser dialog for specifying a name and place to save the game. Hint: If you have implemented the MVC architecture well, this should be only a couple of lines of code.

- "Load", by contrast, should load a saved game o the disk. Again, present the user with a le chooser. Handle the case where the user chooses a le that is not in fact a saved Minesweeper game. When the game has loaded, the board should look just like it did when the user saved it before. Hint: the removeAll() method of a JComponent (like a JPanel) removes everything inside, including any JButtons or other user interface elements. You can then add new elements that represent the new (or newly-loaded) game. Once you have done this, however, you must then call the JComponent's validate() method, which tells the JVM to x all of the entries in its event-loop lookup table which you just messed up.

- "Quit" should simply end the program. The program should only quit when the user selects this option or clicks the JFrame's close box. If the game is lost, the user should be able to look at the revealed game board and then select "New" to start again.
