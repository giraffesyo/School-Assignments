//Michael McQuade
//C Programming
//Chapter 5 Program B
//Assignment_5B.cpp
//This program finds the median of a set of 3 numbers.

#include <iostream>

using namespace std;

void printHeader()
{
	cout
		<< "This program finds the median of a set of numbers."
		<< endl
		<< "Please enter 3 numbers separated by a space: ";
}

double getMedian(double Num1, double Num2, double Num3)
{
	double median;

	if ((Num1 > Num2 && Num1 < Num3) || (Num1 > Num3 && Num1 < Num2))
		median = Num1;
	else if ((Num2 > Num1 && Num2 < Num3) || (Num2 > Num3 && Num2 < Num1))
		median = Num2;
	else if ((Num3 > Num1 && Num3 < Num2) || (Num3 > Num2 && Num3 < Num1))
		median = Num3;
	else //all values are equal
		median = Num1;
	
	return median;
}

int main()
{
	double Num1, Num2, Num3;
	
	printHeader();
	cin >> Num1 >> Num2 >> Num3;
	cout << "The median is: " << getMedian(Num1, Num2, Num3) << endl;

	return 0;
}
