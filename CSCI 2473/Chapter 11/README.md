C Programming  
CSC 2473  
Programming Assignment  
Chapter 11A - Single Dimension Arrays
Chapter 11B - Two Dimension Arrays
11A Due:  11/16/2015 11B Due: 11/30/2015

1. Assignment 11A:
  1. Place the following values in a file. Use this file as an input to your program.
  `62 8 25 7 90 82 22 46 15 54`
  2. Write a program that performs the following:
    1. Read 10 integers from the input file into a 10 position array.
    2. Output the 10 integers on the same line from the array.
    3. Output the 4th integer in the array.
    4. Computer and output the sum and average of the last 6 integers in the array.
    5. Find and output the smallest integer in the array.
    6. Find and output the largest integer in the array.
    7. Output the first 4 integers in the array on the same line in reverse order.
    8. Sort the integers in the array. You may want to use the function SelSort in the file named cch11SelSort.cpp
    9. Output the 10 integers on the same line from the array to confirm that the sort took place correctly.
  3. All 10 integers must be read into the array before any other processing can be accomplished. That is, steps 1.2 through 1.9 cannot be performed during the reading of the integers. The purpose of this exercise is to practice manipulating a single dimension array.
  4. Write all output to a file.
2. Assignment 11B:
  The Oklahoma Fishery Laboratory has been doing research in 6 lakes in Oklahoma attempting to determine the populations of 4 different, almost extinct, fish living in the state.The researchers have compiled the data and are now ready to process it. They need a program as described below to process the data.
  
  The program will do the following:
  - Use a 2-dimension array of integers that has 6 rows representing the6 lakes and 4 columns representing the 4 fish being studied.
  - Read 24 integers from a file called DATAFILE3.TXT into the array such that the rows are filled first, from left to right.
  - Computer and store the sums of each row and column. This task will be performed in a separate function. Use parameters to pass data to and from the function. Global variables will not be used except for file names.
  - Compute and store the averages of each row and column. This task will be performed in a separate function. Use parameters to pass data to and from the function. Global variables will not be used except for file names.
  - Display a table on the screen that contains the original table data and the averages of the rows and columns. The average of each row should be displayed to the right of each row in the table. The average of each column should be displayed at the bottom of each column in the table. 
  
  Properly label all parts of the table so the user will easily understand what the table represents.

3. Turn in:
  - a printed copy of your program
  - a printed copy of the output (file) produced by this program
  - a USB device containing your program
