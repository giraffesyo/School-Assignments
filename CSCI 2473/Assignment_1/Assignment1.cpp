//Michael McQuade
//C Programming
//Chapter 1 Assignment
//Assignment1.cpp
//This program computes the midpoint between the freezing and boiling points of water

#include <iostream>
using namespace std;

const double FREEZE_PT = 32.0;
const double BOIL_PT = 212.0;

void main()
{
	double avgTemp;

	cout << "Michael McQuade" << endl;
	cout << "Water freezes at " << FREEZE_PT << endl;
	cout << "and boils at " << BOIL_PT << " degrees." << endl;

	avgTemp = FREEZE_PT + BOIL_PT;
	avgTemp = avgTemp / 2.0;

	cout << "Halfway between is ";
	cout << avgTemp << " degrees." << endl;

}