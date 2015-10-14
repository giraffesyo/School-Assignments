//Michael McQuade
//C Programming
//Chapter 6 Program A
//Assignment_6A.cpp
//This program reads numbers from a data file, performs various functions and outputs to an answers file.

#include <fstream>
#include <iomanip>

using namespace std;

int main()
{
	ifstream dataFile;
	ofstream answers;

	int num;
	int counter = 0;
	double dataSum = 0.0;

	dataFile.open("DataFile2.txt");
	answers.open("answers.txt");
		
	//Read file and write all integers to one line
	answers << "The input file contains the following data:" << endl;
	dataFile >> num;
	while(dataFile)
	{	
		answers << num << ' ';
		dataFile >> num;
	}

	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");

	//Reread file and compute average of all integers in the file. 
	answers << endl << endl << "The average of all numbers in the input file (with 3 decimal positions) is: ";
	answers << fixed << setprecision(3);
	
	dataFile >> num;
	while(dataFile)
	{
		dataSum += num;
		counter++;
		dataFile >> num;
	}

	answers << double(dataSum) / double(counter);


	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");


	//Reread file and compute average of first 12 integers in the file. 
	dataSum = 0;
	counter = 1;

	dataFile >> num;
	while (counter <= 12)
	{
		dataSum += num;
		counter++;
		dataFile >> num;
	}

	answers << endl << endl << "The average of the first 12 numbers in the input file (with 3 decimal positions) is: ";
	answers << double(dataSum) / double(counter - 1);

	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");
	
	//Reread file and get sum for every 3rd integer
	dataSum = 0;
	counter = 1;
	dataFile >> num;
	while (dataFile)
	{
		if (counter % 3 == 0) //then this is an iteration we want to capture!
		{
			dataSum += num;
		}
		counter++;
		dataFile >> num;
	}
	answers << endl << endl << "The sum of every third integer in the file is: ";
	answers << dataSum;


	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");


	//Reread the file and determine the range of the numbers.
	int smallest = INT_MAX;
	int largest = INT_MIN;
	
	dataFile >> num;
	while (dataFile)
	{
		if (largest < num)
			largest = num;
		if (smallest > num)
			smallest = num;
		dataFile >> num;
	}
	
	answers << endl << endl << "The smallest number is " << smallest << " and the largest is " << largest << ".";


	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");

	//Reread the file and determine the integer which is closest to 200.
	int closest;
	int diff;

	dataFile >> num;
	closest = num;
	while (dataFile)
	{
		diff = abs(num - 200);
		if ( diff < abs(closest - 200))
			closest = num;
		dataFile >> num;
	}


	answers << endl << endl << "The closest number to 200 is: " << closest;

	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");

	//Reread the file and compute the average of all integers on the first two lines.
	dataSum = 0;
	counter = 0;
	int lineCounter = 1;

	dataFile >> num;
	while (lineCounter <= 2)
	{
		if (dataFile.peek() == '\n')
			lineCounter++;
		dataSum += num;
		counter++;
		dataFile >> num;
	}

	answers << endl << endl << "The average of all integers on the first two lines is: ";
	answers << double(dataSum) / double(counter);

	dataFile.close();
	dataFile.clear();
	dataFile.open("DataFile2.txt");

	//Reread the file and compute the sum of integers as long as the sum does not exceed 1000.
	bool lessthan1000 = true;
	dataSum = 0;

	dataFile >> num;
	while (lessthan1000)
	{
		if (dataSum + num > 1000)
			lessthan1000 = false;
		else
			dataSum += num;
	}

	answers << endl << endl << "The sum of the integers without exceeding 1000 is: " << dataSum;


	return 0;
}
