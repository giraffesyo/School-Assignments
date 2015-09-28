//Michael McQuade
//C Programming
//Chapter 5 Program B
//Assignment_5B.cpp
//This program finds the median of a set of numbers.

#include <iostream>
#include <algorithm> //sort function
#include <vector>

using namespace std;

void printHeader()
{
	cout
		<< "This program finds the median of a set of numbers."
		<< endl << endl
		<< "Please enter space separated numbers."
		<< endl
		<< "Enter non-numeric data to stop: ";
}


int main()
{	
	vector <double> numbers; 
	double input;
	double median;

	printHeader();

	while (cin >> input)
		numbers.push_back(input);	

	sort(begin(numbers), end(numbers));

	if (numbers.size() % 2 == 0) //If even
		median = (numbers[numbers.size() / 2 - 1] + numbers[numbers.size() / 2]) / 2.0;
	else //otherwise odd
		median = numbers[numbers.size() / 2];

	cout << endl << "The median of those numbers is: " << median << endl;

	return 0;
}
