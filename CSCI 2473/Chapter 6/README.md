**C Programming**

**CSC 2473**

**Programming Assignments**

**Chapter 6**


Due: **10/19/2015**

1. **Programming Assignment #1**

  1. Write a program that reads a file called DATAFILE2.txt (to be furnished),
  performs the following taks, and writes the result of the tasks to an output file called ANSWERS.txt (open this output file only once; do not close it):
    - Read the file and write all of the integers to the output file on one line.
    - Reread the file and compute the average of all of the integers in the file. Output the average as a floating point number with 3 decimal positions.
    - Reread the file and compute the average of the first 12 integers in the file. Output the average as a floating-point number with 3 decimal positions.
    - Reread the file and compute the sum of every third integer in the file.  That is, compute the sum of the third, sixth, ninth etc. integers.
    - Reread the file and determine the range of the integers in the file.  That is, find the smallest and largest integers.
    - Reread the file and find the integer in the file that is closest to 200.
    - Reread the file and compute the average of all integers on the first two lines. See page 247 for guidance on designing the loop structure.  Output the average as a floating point number with 3 decimal positions.
    - Reread the file and compute the sum of the integers in the file as long as the sum does not exceed 1000. Use a flag controlled loop structure.
  2. Each of the tasks should be performed independently from the other tasks. Do not combine the tasks.  I recommend that you code and test the tasks one at a time.
  3. Each time you need to reread the input file you must close the file and open it again.  The syntax of the statements to close the file are:

    ```c++
    filename.close();
    filename.clear();
    ```
2. **Programming Assignment #2**

  Write a program to read a file called QUOTES.txt (to be furnished).  Your program will count all 3, 4, 5, and 6 letter words.  Display the results int he following format:


  > 3 letter words:   xxx  
  > 4 letter words:   xxx  
  > 5 letter words:   xxx  
  > 6 letter words:   xxx  

  The input for this program comes from a file; the output will go to an output file called NUMWORDS.txt
3. **Please turn in the following:**
  - Printed copies of both the programs.
  - Printed copies of the ANSWERS.txt file and the NUMWORDS.txt file.
  - A USB device containing the two programs.
