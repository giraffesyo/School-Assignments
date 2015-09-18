//Michael McQuade
//C Programming
//Chapter 4 Program A
//Assignment_4A.cpp
//This program calculates the roots of a quadratic equation

#include <iostream>
#include <cmath>

using namespace std;

double A, B, C;
double X1, X2;

//Quadratic Formula, calculates roots given floats A, B, C
void quadratic(double A, double B, double C)
{
	X1 = (-B + sqrt(B * B - 4 * A * C)) / (2 * A);
	X2 = (-B - sqrt(B * B - 4 * A * C)) / (2 * A);
}

int main()
{
	cout << "This program calculates the two roots of a quadratic equation given A, B, and C." << endl;
	cout << "Please enter A, B, and C: ";
	
	cin >> A >> B >> C;
	
	cout
		<< endl
		<< "A: " << A << endl
		<< "B: " << B << endl 
		<< "C: " << C << endl;
 
	quadratic(A, B, C);
	
	cout 
		<< "X1: " << X1 << endl
		<< "X2: " << X2 << endl;

	return 0;
}
