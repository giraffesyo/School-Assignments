**C Programming**

**CSC 2473**

**Programming Assignment**

---

Due: **9/14/2015**

1.  There are two programming assignments for this chapter.  Be sure to refer to the "Green Sheet" for guidance for preparing the programs.

2.  The first programming assignment is to write a program as indicated in Programming Problem 1 on page 133 in the textbook.  Compute the volume for 3 cones using the values indicated below.  The output will be formatted as shown below:

  ```
          Radius     Height      Volume
Cone 1     10.10      20.10     
Cone 2     40.20      60.20   
Cone 3     80.30      90.30   
  ```

  Declare Pi with the value 3.1416 as a constant (type double) above the main function in your program.  Set the precision of all floating point output to 2 decimal positions.

3.  Following is information related to the second program in this assignment.  Dilbert wants to buy a car. The loan company will charge him an annual interest rate of 9% for a loan.  His payments will be 165.25 each month for 36 months.  He wants to know what the balance will be after he makes the first payment, after the second payment and after the third payment.  He knows that you are a computer programmer and solicits your assistance.

  The formula for computing the remaining balances is:

  ```
baIN = Payment * (1 - pow(1 + Monintrate, N - Totnum)) / Monintrate
  ```
  (This formula will be used 3 times with different values for N.)

  where
  ```c++
baIN = balance remaining after the Nth payment
N = payment number //(1, 2, 3, ...)
Payment = amount of monthly payment
Monintrate = interest rate per month //(annual rate / 12)
Totnum = total number of payments to be made
  ```

  Your program will output the basic information related to the loan (monthyl payments, annual interest rate, and total number of payments).  It will also output the balance remaining after the first, second, and third payments. The balances will be shown in dollars and cents.

4. Below are some helpful hints for writing the second program:
  - Include cmath and iomanip header files in your include statements.
  - Declare monthyl interest rate, number of payments, and payment amount as constants.
  - Declare balance and payment number as variables.
  - Use setprecision to control the number of decimal positions displayed.
  - If you need to clear the screen use `system ("cls"); //(requires #include cstdlib)`
  - Take some time to think about the program requirements before rushing to write the program. Make sure you understand the requirements before proceeding.  If some part of it is not clear, please talk to me.
  - The balance after the first payment is $5070.31.  I give you this value so you will have something to confirm you have written the formula correctly.

5. Please turn in the following:

  - Printed copies of the 2 programs.
  - Printed copies of the output produced.
  - A USB device containing the 2 programs.
