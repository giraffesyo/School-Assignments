**C++ Programming**  
**CSC 2843**  
**Programming Assignment 5**  
**Inheritance**  

Due: April 26, 2015

1. Write a phone book program that uses the following classes:
  `Individual` - base class.
    - Private data members: last name, first name, phone number.
  `Student` - derived from `Individual`
    - Private data members: gpa, hours(current enrollment)
  `Staff` - derived from `Individual`
    - Private data members: position(string), year employed(integer)
2. The program should be menu driven, and should allow the user to do the following:
  - Create a new phone book entry and plate it in an array
  - Retrieve a selected phone book entry and display it on the screen.
    - Display all entries with "requested" last name.
  - Retrieve and display all phone book entries on the screen and write them to a file.
3. Your program will contain two arrays: an array of `Student` objects and an array of `Staff` objects. Arrays of 10 positions are sufficient for this program. You are not required to maintain the entries in any particular sequence.
4. When phone book entries are displayed all data members will be displayed. Create friend functions to overload the `<<` operator to output the phone book entries.
5. Before turning in this assignment you must have it evaluated by at least one other person. A short written evaluation, signed by the evaluator, should accompany your work.
6. Turn in the following:
  - a USB device containing your program
  - a printed listing of your program
  - a pritned copy of your phone book entries that have been written to a file (at least 3 students and 3 staff employees)
  - the program evaluation
  
