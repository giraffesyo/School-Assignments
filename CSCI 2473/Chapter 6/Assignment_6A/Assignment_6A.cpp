//Michael McQuade
//C Programming
//Chapter 6 Program A
//Assignment_6A.cpp
//This program reads numbers from a data file, performs various functions and outputs to an answers file.

#include <fstream>
#include <iomanip>

using namespace std;

//Function Prototypes
void reopenData(ifstream& input);
void allIntegers(ifstream& inputFile, ofstream& outputFile);
double avgOfAll(ifstream& inputFile);
double avgOf12(ifstream& inputFile);
int sumevery3rd(ifstream& inputFile);
void calculateRange(ifstream& inputFile, int& smallest, int& largest);
int closest200(ifstream& inputFile);
double avg2lines(ifstream& inputFile);
int sumlessthan1000(ifstream& inputFile);

//File Declarations
const char inputFile[] = "DataFile2.txt";
const char outputFile[] = "answers.txt";


int main()
{
	ifstream dataFile;
	ofstream answers;

	dataFile.open(inputFile);
	answers.open(outputFile);

	//Task A
	answers << "The input file contains the following data:" << endl;
	allIntegers(dataFile, answers);

	//Task B
	answers << fixed << setprecision(3);
	answers << endl << endl << "The average of all numbers in the input file (with 3 decimal positions) is: ";
	answers << avgOfAll(dataFile);
	
	//Task C	
	answers << endl << endl << "The average of the first 12 numbers in the input file (with 3 decimal positions) is: ";
	answers << avgOf12(dataFile);

	//Task D
	answers << endl << endl << "The sum of every third integer in the file is: ";
	answers << sumevery3rd(dataFile);

	//Task E
	int smallest = INT_MAX;
	int largest = INT_MIN;
	calculateRange(dataFile, smallest, largest);

	answers << endl << endl << "The smallest number is: " << smallest;
	answers << endl << "The largest number is: " << largest;
	
	//Task F
	answers << endl << endl << "The closest number to 200 is: ";
	answers << closest200(dataFile);

	//Task G
	answers << endl << endl << "The average of all integers on the first two lines is (with 3 decimal positions): ";
	answers << avg2lines(dataFile);

	//Task H
	answers << endl << endl << "The sum of the integers without exceeding 1000 is: ";
	answers << sumlessthan1000(dataFile) << endl;

	return 0;
}

//Closes file stream, clears buffer, reopens stream.
void reopenData(ifstream& input)
{
	input.close();
	input.clear();
	input.open(inputFile);
}

//Task A: Read file and write all integers to one line
void allIntegers(ifstream& inputFile, ofstream& outputFile)
{
	int num;
	inputFile >> num;
	while (inputFile)
	{
		outputFile << num << ' ';
		inputFile >> num;
	}

	reopenData(inputFile);
}

//Task B: Reread file and compute average of all integers in the file. 
double avgOfAll(ifstream& inputFile)
{
	int num;
	int dataSum = 0;
	int counter = 0;

	inputFile >> num;
	while (inputFile)
	{
		dataSum += num;
		counter++;
		inputFile >> num;
	}

	reopenData(inputFile);

	return double(dataSum) / double(counter);
}

//Task C: Reread file and compute average of first 12 integers in the file. 
double avgOf12(ifstream& inputFile)
{
	int dataSum = 0;
	int counter = 1;
	int num;

	inputFile >> num;
	while (counter <= 12)
	{
		dataSum += num;
		counter++;
		inputFile >> num;
	}

	reopenData(inputFile);

	return double(dataSum) / double(counter - 1);
}

//Task D: Reread file and get sum for every 3rd integer
int sumevery3rd(ifstream& inputFile)
{
	int dataSum = 0;
	int counter = 1;
	int num;

	inputFile >> num;
	while (inputFile)
	{
		if (counter % 3 == 0) //then this is an iteration we want to capture!
		{
			dataSum += num;
		}
		counter++;
		inputFile >> num;
	}

	reopenData(inputFile);
	return dataSum;

}

//Task E: Reread the file and determine the range of the numbers.
void calculateRange(ifstream& inputFile, int& smallest, int& largest)
{
	int num;

	inputFile >> num;
	while (inputFile)
	{
		if (largest < num)
			largest = num;
		if (smallest > num)
			smallest = num;
		inputFile >> num;
	}

	reopenData(inputFile);
}

//Task F: Reread the file and determine the integer which is closest to 200.
int closest200(ifstream& inputFile)
{
	int closest;
	int diff;
	int num;

	inputFile >> num;
	closest = num;
	while (inputFile)
	{
		diff = abs(num - 200);
		if (diff < abs(closest - 200))
			closest = num;
		inputFile >> num;
	}
	reopenData(inputFile);
	return closest;
}

//Task G: Reread the file and compute the average of all integers on the first two lines.
double avg2lines(ifstream& inputFile)
{

	int	dataSum = 0;
	int counter = 0;
	int lineCounter = 1;
	int num;

	inputFile >> num;
	while (lineCounter <= 2)
	{
		if (inputFile.peek() == '\n')
			lineCounter++;
		dataSum += num;
		counter++;
		inputFile >> num;
	}

	reopenData(inputFile);

	return double(dataSum) / double(counter);
}

//Task H: Reread the file and compute the sum of integers as long as the sum does not exceed 1000.
int sumlessthan1000(ifstream& inputFile)
{
	bool lessthan1000 = true;
	int dataSum = 0;
	int num;

	inputFile >> num;
	while (lessthan1000)
	{
		if (dataSum + num > 1000)
			lessthan1000 = false;
		else
			dataSum += num;
	}

	return dataSum;
}
