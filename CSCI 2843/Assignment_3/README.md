**C++ Programming**  
**CSC 2843**  
**Programming Assignment #3**  

Due: 3/29/2016

1. Write a program that includes a `SavingsAccount` class.
  Data members:
  - `firstName` (string)
  - `lastName` (string)
  - `savingBalance`
  - `annualInterestRate` (static)
  - `objectnumber` (1,2,3...) const

  Function members:
  - Default constructor - allows objects to be created without arguments. Set the names to the empty string and the balance to zero
  - Constructor that allows an object to be created with name arguments only.
    - Set the balance to zero.
  - Constructor that allows an object to be created with name arguments and a beginning balance
    - All constructs will provide a serial number to each object.
  - `setName`
  - `getName const`
  - `setBalance`
  - `getBalance const`
  - `setInterestRate static`
  - `getInterestRate static`
  - `getNumber const`
  - `display` - displays all account information
  - `calculateNewBalance` (monthly rate = `annualInterestRate / 12`)
  - Destructor - Display message to indicate that the object no longer exist

2. Write a *driver* program to test the class. Perform the following tasks in this order:
  - Declare at least 3 objects:
    - Saver1: `Margaret Olson` with a balance of `$2,000`
    - Saver2: `Debra Baxter` with no balance
    - Saver3: object without name or balance
  - Set Baxter's balance to `$5,000`
  - Set Saver3's name to `Arturo Ortiz` and the balance to `$10,000`
  - Calculate the new monthly balance for each customer
    - new balance = old balance + monthly interest earned
  - Display all the data for all of the objects
  - Set the annual interest rate to `10.0%`
  - Calculate the new monthly balance for each customer again
  - Display all the data for all of the objects

3. A header file will be used to declare the class. Other header files may be used if you wish. A separate .cpp file will be used to implement the class member functions. Hence, your program will consist of at least one header file and at least 2 .cpp files.

4. Turn in:
  - A printed copy of the 3 source files
  - A printed copy of the output produced by the program
  - A USB device containing the header file and the 2 source (.cpp) files
