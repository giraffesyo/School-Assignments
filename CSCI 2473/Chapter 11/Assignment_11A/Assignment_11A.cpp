#include <fstream>

using namespace std;

const string output_filename = "output.txt";

void taskA(int data[], int size);
void taskB(ofstream & outputfile, int data[], int size);
void taskC(ofstream & outputfile, int data[], int size);
void taskD(ofstream & outputfile, int data[], int size);
void taskE(ofstream & outputfile, int data[], int size);
void taskF(ofstream & outputfile, int data[], int size);
void taskG(ofstream & outputfile, int data[], int size);
void taskH(ofstream & outputfile, int data[], int size);


int main()
{
	const int numOfInts = 10;

	ofstream outputFile;
	outputFile.open(output_filename);

	int data[numOfInts];
	taskA(data, numOfInts);
	taskB(outputFile, data, numOfInts);
	taskC(outputFile, data, numOfInts);
	taskD(outputFile, data, numOfInts);
	taskE(outputFile, data, numOfInts);
	taskF(outputFile, data, numOfInts);
	taskG(outputFile, data, numOfInts);
	taskH(outputFile, data, numOfInts);
	taskB(outputFile, data, numOfInts);

	return 0;
}

//Loads the ten integers into the array
void taskA(int data[], int size)
{
	ifstream inputFile;
	inputFile.open("input.txt");

	for (int i = 0; i < size; i++)
	{
		inputFile >> data[i];
	}
}

//Outputs all ints on one line
void taskB(ofstream & outputfile, int data[], int size)
{
	outputfile << "All integers: ";
	for (int i = 0; i < size; i++)
	{
		outputfile << data[i] << ' ';
	}
	outputfile << endl;
}

//Outputs the 4th integer on a line
void taskC(ofstream & outputfile, int data[], int size)
{
	outputfile << "Fourth integer: ";
	outputfile << data[3];
	outputfile << endl;
}

//Outputs the computed sum and average of the last 6 integers in the array
void taskD(ofstream & outputfile, int data[], int size)
{
	const int num = 6;

	int sum = 0;
	int temp;
	
	for (int i = size - num; i < size; i++)
	{
		temp = data[i];
		sum += temp;
	}
	outputfile << "Sum of last 6: " << sum << endl;
	outputfile << "Average of last 6: " << double(sum) / double(num) << endl;
}

//Outputs the smallest number in the array
void taskE(ofstream & outputfile, int data[], int size)
{
	int smallest = data[0];
	for (int i = 1; i < size; i++)
		if (smallest > data[i])
			smallest = data[i];
	outputfile << "Smallest number: " << smallest << endl;
}

//Outputs the largest number in the array
void taskF(ofstream & outputfile, int data[], int size)
{

	int largest = data[0];
	for (int i = 1; i < size; i++)
		if (largest < data[i])
			largest = data[i];
	outputfile << "Largest number: " << largest << endl;
}

//Outputs the first 4 integers in the array on the same line in reverse order
void taskG(ofstream & outputfile, int data[], int size)
{
	outputfile << "First four ints in reverse order: ";
	for (int i = 3; i >= 0; i--)
	{
		outputfile << data[i] << ' ';
	}
	outputfile << endl;
}

//SelSort
void taskH(ofstream & outputfile, int data[], int size)
{
	int temp, minIndx;

	for (int passCount = 0; passCount < size - 1; passCount++)
	{
		minIndx = passCount;

		for (int searchIndx = passCount + 1; searchIndx < size; searchIndx++)
			if (data[searchIndx] < data[minIndx])
				minIndx = searchIndx;

		temp = data[minIndx];
		data[minIndx] = data[passCount];
		data[passCount] = temp;
	}
}