**C Programming**

**CSC 2473**

**Programming Assignments**

**Chapter 4**

**Due: 9/21/2015**

There are 2 programming assignments for this chapter.

1. **Programming Assignment #1**

  The quadratic equation is often used by mathematicians and scientists. It has the form

  >Ax^2 + Bx + C = 0

  A, B, and C are called coefficients and must be given to solve for the values of X.
  To help solve for the **two** values of X, a formula, called the quadratic formula, has been derived as follows:

  >X1 = (-b + sqrt(b^2 - 4AC))/2A

  >X2 = (-b - sqrt(b^2 - 4AC))/2A

  Write an interactive program that allows the user to enter values for A, B, and C.
  Use the formulas to solve for the two values X1 and X2.  
  Display the input values and the values of X1 and X2 with appropriate labels.
  Use **floating point** variables for all variables.


  Run your program at least twice.  Use the following test data to test your program:

  ```
  First Run         Second Run
  A = 2.0           A = 4.0
  B = 3.0           B = 5.0
  C = -65.0         C = -174.0
  ```

  Hint: One of the computed values for X is -6.50.

  Turn in the output of your program using these 2 sets of data.

2.  **Programming Assignment #2**

  Using the editor that you have been using to create your programs, create and save a file that contains only the following data:

  ```
  X   19312.34    34
  Y   26825.12    56
  Z   28562.40    80
  ```

  The data in this file has the following meaning:

  - The first column is an Employee Category letter (X,Y, Z).
  - The second column is the sum of the pay for all employees in the category.
  - The third column is the number of employees in the category.

  This program will perform the following tasks:

  - Read the input data in the file above.
  - Output the input data to the output file with an appropriate label.
  - Compute and output the following averages:
    - Average number of employees in the three categories (average of the integers)
    - Average pay for employees in each category (3 averages)
    - Average pay for all employees (sum of doubles / sum of integers)

  All averages will be type double and will be output to the file with 2 decimal places.

  **All output data in this program will be written to a file.**
  This program may not have any input from the keyboard and may not have any output to the screen, that's OK.

3. **Turn in the following:**
    - A printed copy of your programs.
    - A printed copy of the output produced by Programming Assignment #1 using the test data provided.
    - A printed copy of the output **file** produced by your program for Programming Assignment #2.
    - The USB device containing your programs.
