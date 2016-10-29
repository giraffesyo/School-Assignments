//Michael McQuade
//C Programming
//Chapter 11B Program
//Assignment_11B.cpp
//This program processes data on endangered fish

#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

const char inputFilename[14] = "DataFile3.txt";

void SumRows(int Data[][6], int rowSum[]);
void SumColumns(int Data[][6], int columnSum[]);
void AvgRows(int rowSum[], double rowAvg[]);
void AvgColumns(int columnSum[], double columnAvg[]);
void DrawTable(int Data[][6], int rowSum[], int columnSum[], double rowAvg[], double columnAvg[]);

int main()
{
	ifstream inputData;

	int FishyArray[4][6];
	int rowSum[4];
	int columnSum[6];
	double rowAvg[4];
	double columnAvg[6];

	inputData.open(inputFilename);

	//load our array from input file
	for (int i = 0; i < 4; i++)
	{

		for (int j = 0; j < 6; j++)
		{
			inputData >> FishyArray[i][j];
		}
	}

	SumRows(FishyArray, rowSum);
	SumColumns(FishyArray, columnSum);
	AvgRows(rowSum, rowAvg);
	AvgColumns(columnSum, columnAvg);
	DrawTable(FishyArray, rowSum, columnSum, rowAvg, columnAvg);


	return 0;
}

//Sums rows and stores them into an array, ordered by row number
void SumRows(int Data[][6], int rowSum[])
{
	int sum = 0;
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 6; j++)
		{
			sum += Data[i][j];
		}
		rowSum[i] = sum;
		sum = 0;
	}
}

//Sums columns and stores them into an array, ordered by column number
void SumColumns(int Data[][6], int columnSum[])
{
	int sum = 0;
	for (int j = 0; j < 6; j++)
	{
		for (int i = 0; i < 4; i++)
		{

			sum += Data[i][j];
		}
		columnSum[j] = sum;
		sum = 0;
	}
}

//Averages Rows and Stores them into an array, ordered by row number
void AvgRows(int rowSum[], double rowAvg[])
{
	for (int i = 0; i < 4; i++)
	{
		rowAvg[i] = rowSum[i] / 6;
	}

}

//Averages Columns and stores them into an array, ordered by column number
void AvgColumns(int columnSum[], double columnAvg[])
{
	for (int i = 0; i < 6; i++)
	{
		columnAvg[i] = columnSum[i] / 4;
	}
}

//Outputs to screen table of information using row and column data and averages.
void DrawTable(int Data[][6], int rowSum[], int columnSum[], double rowAvg[], double columnAvg[])
{
	for (int n = 0; n <= 34; n++)
	{
		cout << '*';
	}
	cout << " Row Averages";
	cout << endl;
	for (int i = 0; i < 4; i++)
	{

		cout << '|';
		for (int j = 0; j < 6; j++)
		{
			cout << setw(4) << Data[i][j] << "| ";
		}
		cout << setw(5) << rowAvg[i];
		cout << endl;
		for (int n = 0; n <= 34; n++)
		{
			cout << '*';
		}
		cout << endl;
	}
	for (int o = 0; o < 6; o++)
	{
		cout << setw(6) << columnAvg[o];
	}
	cout << endl;
	cout << setw(20) << "Column Averages" << endl;
}
