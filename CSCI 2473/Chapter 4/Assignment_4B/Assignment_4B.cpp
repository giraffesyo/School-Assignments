//Michael McQuade
//C Programming
//Chapter 4 Program B
//Assignment_4B.cpp
//Computes averages from employee data and outputs data to a file

#include <fstream>
#include <iostream> // Used in case data.txt isn't present

using namespace std;

int main()
{
	ifstream empDataIn;
	ofstream empAvgOut;

	char empCat; 
	double empPay = 0.0;
	int empNum = 0;

	double readMarkerA, readMarkerB; //Used for temporary storage of values

	empDataIn.open("data.txt");
	if (!empDataIn)
	{
		cout << "Data.txt not found, please make sure it's available." << endl;
		return 1;
	}

	empAvgOut.open("avg.txt");

	int i = 0; //index for empNum average
	while (!empDataIn.eof()) 
	{
		empDataIn >> empCat >> readMarkerA;
		empPay = empPay + readMarkerA;
		empDataIn >> readMarkerB;
		empNum = empNum + readMarkerB;
		empAvgOut << "Average pay for category " << empCat << " is " << readMarkerA / readMarkerB << endl;
		i++;
	}
	
	empAvgOut
		<< "Average number of employees (floored): " << empNum / i << endl
		<< "Average pay of all employees: " << empPay / double(empNum) << endl;

	return 0;
}
