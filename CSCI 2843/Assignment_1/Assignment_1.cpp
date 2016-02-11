//Michael McQuade
//Russel Sowell
//C++ Programming
//Assignment_1.cpp
//This is a program that will take 3 files containing different types of data as input, sort them, then output files containing the sorted data.
//Due: 2/11/2016

#include <fstream>
#include <string>

template <typename UnsortedDataType> void fillArray(std::ifstream & InputFile, UnsortedDataType * UnsortedData, const int SIZE, int & count);
template <typename T> void SelSort(T * data, int length);
template <typename SortedDataType> void OutputArray(std::ofstream & outputfile, SortedDataType * SortedData, int count);

int main()
{
	std::ifstream IntFile("intFile.txt");
	std::ifstream FloatFile("FloatFile.txt");
	std::ifstream StringFile("Quotes.txt");

	std::ofstream IntOutput("IntOutput.txt");
	std::ofstream FloatOutput("FloatOutput.txt");
	std::ofstream StringOutput("StringOutput.txt");

	const int ARRAY_SIZE = 100;

	int integers[ARRAY_SIZE];
	double floats[ARRAY_SIZE];
	std::string strings[ARRAY_SIZE];
	
	int intCount;
	int floatCount;
	int stringCount;

	fillArray(IntFile, integers, ARRAY_SIZE, intCount);
	fillArray(FloatFile, floats, ARRAY_SIZE, floatCount);
	fillArray(StringFile, strings, ARRAY_SIZE, stringCount);

	SelSort(integers, intCount);
	SelSort(floats, floatCount);
	SelSort(strings, stringCount);

	OutputArray(IntOutput, integers, intCount);
	OutputArray(FloatOutput, floats, floatCount);
	OutputArray(StringOutput, strings, stringCount);

	return 0;
}


//Template function for filling our arrays from our inputs files
template <typename UnsortedDataType> void fillArray(std::ifstream & InputFile, UnsortedDataType * UnsortedData, const int SIZE, int & count)
{
	count = 0;
	while(InputFile)
	{
		InputFile >> UnsortedData[(count)];

		if (count == SIZE - 1)
			break; // if input file has more than ARRAY_SIZE, break out of loop so we don't write outside of our array
		count++;
	}
	count--; // count++ increments until InputFile evaluates false, this causes addition of 1 at the end of loop. Maybe a better solution here?
}

//This is instructor provided code, modified to be a template instead of merely sorting ints.
template <typename T> void SelSort(T * data, int length)
{
	T temp;
	int minIndx;

	for (int passCount = 0; passCount < length - 1; passCount++)
	{
		minIndx = passCount;

		for (int searchIndx = passCount + 1; searchIndx < length; searchIndx++)
			if (data[searchIndx] < data[minIndx])
				minIndx = searchIndx;

		temp = data[minIndx];
		data[minIndx] = data[passCount];
		data[passCount] = temp;
	}
}

//Outputs arrays into a file
template <typename SortedDataType> void OutputArray(std::ofstream & outputFile, SortedDataType * SortedData, int count)
{
	for (int i = 0; i < count; i++)
		outputFile << SortedData[i] << std::endl;
}
