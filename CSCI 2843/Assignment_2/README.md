**C++ Programming**  
**CSC 2843**  
**Programming Assignment #2**

Due: 03/08/2016

1. Write a program that uses a class named `Rectangle`. The class has floating point attributes `length` and `width`. It has member functions that calculate the perimeter and the area of the rectangle. It also has set and get functions for both length and width. The set functions verify that length and width are each floating-point numbers larger than 0.0 and less than or equal to 20.0. If invalid length or width are given, then length and width will be set to 1.0. A "predicate function" (member Boolean function) will determine if the rectangle is a square. (A square exists if the length and the width differ by less than .0001). The class will have a destructor that displays a message indicating that an object has "gone out of scope".

2. The class will have 3 overloaded constructor functions. The first will have no parameters. (In this function set the length and width to 1.0 in the body of the function.) The second will have one parameter (length). (In this function set the width to 1.0 in the body of the function.) The third will have two parameters (length and width). This third constructor will set length and width to 1.0 in the body of the function if the values for these members are invalid.

3. Error messages will indicate that an attempt has been made to create an object with invalid parameters.

4. A header file will be used to declare the class. Other header files may be used if you wish. A separate .cpp file will be used to implement the class member functions. Hence, your program will consist of at least one header file and at least 2 .cpp files.

5. Test the performance of your class by performing the following tasks in your program in the given order:
  1. Declare object 1 with no parameters.
  2. Declare object 2 with valid parameters for length (7.1) and width (3.2)
  3. Declare object 3 with only a length (6.3) parameter.
  4. Declare object 4 with invalid parameters for length and width.
  5. Declare object 5 and initialize it by assigning object 2.
  6. Display the length, width, perimeter, and area of all 5 objects and indicate whether or not they are squares.
  7. Change the length of object 1 to 5.4 and the width to 10.5.
  8. Change the length of object 4 to 15.6 and the width to 15.6
  9. Display the length, width, perimeter, and area of all 5 objects and indicate whether or not they are squares.

6. Write all output data to a file and print the file.

7. Turn in:
  - Printed copies of your source programs (.cpp) and header files
  - A printed copy of the output files
  - A USB device containing your soursce programs (.cpp) and header files

8. **Note**:
  If a global variable is declared in one .cpp file and used in another .cpp file, declarations similar to the following must be used:

  In File1 (for example, the file that contains the main function)
     - All include entries
     - `using namespace std;`
     - `ofstream Fileout;`
     - `float number;`
     
  In File2(for example, the file that contains the member function definitions)
    - All include entries
    - `using namespace std;`
    - `extern ofstream Fileout;`
    - `extern float number`;

    
