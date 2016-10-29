**C Programming**  
**CSC 2473**  
**Programming Assignment**  
**Chapter 8**

1. **Programming Assignment 1** <sup>1</sup>
  1. Revise the first programming assignment in Chapter 6 so that the 8 tasks performed in main are performed in separate functions. Call each of the functions from the main function.
  2. The only global variables referenced in the functions will be the file names. All other variables must be local. Parameters are no required in Assignment 1.
  3. I recommend that you code and test the functions one at a time.
  4. You will have to close and reopen the input file several times in accordance with the instructions in the Chapter 6 assignment.
  5. Write all the output to a file called PROCOUT.txt
2. **Programming Assignment 2**

  In this programming assignment you will be writing a program which will allow you to test your understanding of modular programming using C++ functions.

  A loan officer at a bank needs a program to determine whether a loan applicant qualifies for one of two kinds of loans: automobile loans or home mortgage loans.

  Write a menu driven program to allow the loan officer to determine the eligibility for these two types of loans. Your program will contain a main function and the following additional functions:

       Function Getinput
            This function will display a menu and read the income, total debt, and loan amount.
            Parameters: Loantype, Income, Totaldebt, Loanamount

       Function Autoloan
            This function will determine the eligibility for an auto loan.
            Parameters: Income, Totaldebt, Loanamount, Eligible

       Function mortgage
            This function will determine the eligibility for a home mortgage loan.
            Parameters: Income, Totaldebt, Loanamount, Eligibile

       Function Printreport
            This function will produce the output. See the output formate below.
            Paramters: Loantype, Loanamount, Eligible
3. NOTES for Programming Assignment 2
  - **Income** = annual income in the parameter lists.  
  - **Eligible** is a boolean, reference parameter.  
  - All variables will be local.  
  - All variables related to money should be typed `double`.  
  - Eligibility:

	    	A borrower is eligible for an automobile loan if
		    	(Income - Total debt) >= 50% of Loan amount
     		A borrower is eligible for a home mortgage loan if
		    	(Income - Total debt) >= 30% of Loan amount

 - Place the request for information and the processing in a loop.
 - Continue to process data until 3 (Stop Program) is entered.

4. Sample Output format for Programming Assignment 2:
  >Loan Type: Auto  
  Loan Amount: 21000  
  Eligible: YES  

5. Input for Programming Assignment 2:  
  Please use the following data to test your program:

  Autoloans:

  |             | Test A | Test B |
  |-------------|--------|--------|
  | Income      | 21,000 | 19,000 |
  | Total Debt  | 3,000  | 5,000  |
  | Loan Amount | 18,000 | 36,000 |

  Mortgage loans:

  |             | Test A  | Test B  |
  |-------------|---------|---------|
  | Income      | 91,000  | 49,000  |
  | Total Debt  | 10,000  | 15,000  |
  | Loan Amount | 100,000 | 140,000 |

6. Your `Getinput` function shoud look like the one below:
  ```C++
  void Getinput(int& Loantype, double& Income, double& Totaldebt, double& Loanamount)
  {
    cout << "SELECT ONE OF THE FOLLOWING OPTIONS:" << endl << endl;
    cout << "   1   AUTO LOAN" << endl;
    cout << "   2   HOME MORTGAGE LOAN" << endl;
    cout << "   3   STOP PROGRAM" << endl << endl;

    cout << "ENTER A NUMBER: ";
    cin >> Loantype;
    if (Loantype == 1 || Loantype == 2)
    {
      cout << "ENTER INCOME, TOTAL DEBT, AND LOAN AMOUNT" << endl;
      cin >> Income >> Totaldebt >> Loanamount;
    }
  }
  ```
7. Turn in:
  - a USB device containing the 2 programs
  - a printed copy of the 2 programs
  - a printed copy of the PROCOUT.DAT
  - a printed copy of the screens displaying the output from the loan program
  - program structure charts for the 2 programs
8. **NOTES REGARDING PROGRAM STRUCTURE CHARTS**
  Your author calls these charts "module structure charts." An example of one is on page 367 (the blue boxes only). There should be one rectangle for the main function and one rectangle for each other function in the program.

  I recommend the following improvements to the chart on page 367:

  Inside the rectangle the first word should almost always be a verb and the function names should not be used. For example, I recommend the following words for the rectangles on page 367:
  - Process Loan Data (instead of Main)
  - Get Loan Amount (Instead of GetLoanAmt)
  - Get Interest and Loan Years (instead of GetRest)
  - Get Interest Rate (instead of GetInterest)
  - Get Number of Years (Instead of GetYears)
  - Determine Loan Payment (Instead of Loan Payment)
  - Display Results (instead of Print Results)

  The Program structure chart is a simple but powerful programming tool. It indicates what modules your program contains, how the modules are related to each other, and how they are invoked.

  ---
<sup>1</sup>*I will not be doing assignment 1 as my original chapter 6 submission exceeded the criteria for this assignment, so you will only see assignment 2 in this repository.*
