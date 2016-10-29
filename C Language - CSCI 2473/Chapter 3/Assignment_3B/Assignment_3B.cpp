//Michael McQuade
//C Programming
//Chapter 3 Program 2
//Assignment_3B.cpp
//Program to calculate monthly remaining balance of a car loan given monthly payments, interest rate, and duration of loan.

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

//loan data
const double Payment = 165.25;
const double Monintrate = .0075;
const double Totnum = 36.0;

//returns balance of loan after n months
double getBalance(double month)
{
	double balance = Payment * (1 - pow(1 + Monintrate, month - Totnum)) / Monintrate;
	return balance;
}

int main() 
{

	cout << fixed << showpoint << setprecision(2); //prepare stream for money

	//General information about loan
	cout << "You pay $" << Payment << " per month." << endl;
	cout << "Your annual interest rate is " << Monintrate * 12.0 * 100.0 << "%." << endl;
	cout << "In total you will make " << Totnum << " payments." << endl << endl;
	
	int i = 1;
	while (i < 4) // the programming assignment only wants 3 months
	{
		cout << "After month " << i << " your balance will be: $" << getBalance(i) << endl;
		i++;
	}
	return 0;
}