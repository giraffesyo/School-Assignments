//Michael McQuade
//C Programming
//Chapter 4 Program A
//Assignment_4A.cpp
//This program calculates the roots of a quadratic equation

#include <iostream>
#include <cmath>

using namespace std;

//Quadratic Formula, calculates roots given floats A, B, C, stores values in X1 and X2
void quadratic(double A, double B, double C, double& X1, double& X2)
{
	X1 = (-B + sqrt(B * B - 4 * A * C)) / (2 * A);
	X2 = (-B - sqrt(B * B - 4 * A * C)) / (2 * A);
}

int main()
{
	double X1, X2;
	double A, B, C;

	cout
		<< "This program calculates the two roots of a quadratic equation given A, B, and C." << endl << endl
		<< "Press enter or space after each value." <<endl
		<< "Please enter values for A, B, and C: ";
	
	cin >> A >> B >> C;
	
	cout
		<< endl
		<< "A: " << A << endl
		<< "B: " << B << endl 
		<< "C: " << C << endl;
 
	quadratic(A, B, C, X1, X2);
	
	cout 
		<< "X1: " << X1 << endl
		<< "X2: " << X2 << endl;

	return 0;
}
