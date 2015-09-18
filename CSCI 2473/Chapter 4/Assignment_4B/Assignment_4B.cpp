//Michael McQuade
//C Programming
//Chapter 4 Program B
//Assignment_4B.cpp
//Computes averages from employee data and outputs data to a file

#include <fstream>

using namespace std;

int main()
{
	ifstream empData;
	ofstream empAvg;

	char empCat; 
	double empPay = 0.0;
	int empNum = 0;

	double readMarkerA, readMarkerB; //Used for temporary storage of values

	empData.open("data.txt");
	empAvg.open("avg.txt");

	int i = 0; //index for empNum average
	while (!empData.eof()) 
	{
		empData >> empCat >> readMarkerA;
		empPay = empPay + readMarkerA;
		empData >> readMarkerB;
		empNum = empNum + readMarkerB;
		empAvg << "Average pay for category " << empCat << " is " << readMarkerA / readMarkerB << endl;
		i++;
	}
	
	empAvg
		<< "Average number of employees (floored): " << empNum / i << endl
		<< "Average pay of all employees: " << empPay / double(empNum) << endl;

	return 0;
}
