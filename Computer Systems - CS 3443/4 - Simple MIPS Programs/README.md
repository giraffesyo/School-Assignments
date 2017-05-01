<article class="markdown-body">

### [<span class="headeranchor"></span>](#cs-3443-computer-systems-program-4-simple-mips-programs)CS 3443 : Computer Systems
Program 4: Simple MIPS programs

Dr. David Cline

* * *

In this assignment, you will write some programs in C and then in MIPS assembly that can be run in Spim or Mars.

#### [<span class="headeranchor"></span>](#directions)Directions

Write the following programs in C, and then in MIPs assembly. Make sure your C programs compile and run before you start the assembly programs. Then, use your C programs as a guide to write the assembly versions. The C program is worth half of the points, and the MIPS program is worth the other half, so make sure to do them both.

*   WordBorder (25% of grade). First print out your name, and then ask the user to input a string. Finally, print out the string with a border of “*” characters around it.

*   Collatz (25% of grade). The Collatz conjecture suggests that, starting with any positive integer n, and iterating on the following rules, you will eventually reach the number one:

    *   if (n is odd) n = 3*n+1;
    *   if (n is even) n = n/2;
        Write a program that first prints your name, and then asks the user to input a number. Then, have the program follow the Collatz rules, printing out each successive number until you reach 1\. Finally exit.
*   ConnectFour (50% of grade). Connect Four is a classic game played on a grid with 7 columns and 6 rows. In the game, players drop checkers in vertical slots, which slide down the selected column until they rest on the bottom of the board, or on the last checker placed in that slot. The goal of the game is to get four checkers of your color in a row (across, down, or diagonal) while preventing your oponent from doing the same. Write a connect four program that uses ASCII characters to represent the two checker colors. When the program first starts, it must print your name and state that it is a connect four game. Let each player indicate which slot they want to place their checker in using they keyboard. Between each input, draw the board. If a player wins the game, the program should indicate which player has won and exit. If there are no more spaces available on the borad, the game should state that no one has won and exit. The game must also prevent players from placing checkers in slots that are already full.

When you are confident that your programs work, pass off both your C and MIPS programs directly to the instructor. Turn in your source for all of the programs to D2L.

* * *

#### [<span class="headeranchor"></span>](#suggestions)Suggestions

*   Write your programs in C first, without using any math functions, and then translate them to assembly.

*   The MIPS handouts are a reasonably good starting point, particularly the mipsQuickTutorial and testHandout.

*   Keep in mind that MIPS assembly does not have the concept of a 2D array, so you will have to figure out the indexing yourself.

</article>
