//Michael McQuade
//C Programming
//Chapter 5 Program A
//Assignment_5A.cpp
//This program gets input and outputs the number which corresponds to it on a phone's keypad.

#include <iostream>

using namespace std;

int main()
{
	char userChar;
	char keypadnum;
	
	cout << "Enter a single letter, and I will tell you what the corresponding digit is on the telephone keypad." << endl << '>';
	cin >> userChar;

	userChar = char(toupper(userChar));

	if (userChar == 'A' || userChar == 'B' || userChar == 'C')
		keypadnum = '2';
	else if (userChar == 'D' || userChar == 'E' || userChar == 'F')
		keypadnum = '3';
	else if (userChar == 'G' || userChar == 'H' || userChar == 'I')
		keypadnum = '4';
	else if (userChar == 'J' || userChar == 'K' || userChar == 'L')
		keypadnum = '5';
	else if (userChar == 'M' || userChar == 'N' || userChar == 'O')
		keypadnum = '6';
	else if (userChar == 'P' || userChar == 'R' || userChar == 'S')
		keypadnum = '7';
	else if (userChar == 'T' || userChar == 'U' || userChar == 'V')
		keypadnum = '8';
	else if (userChar == 'W' || userChar == 'X' || userChar == 'Y')
		keypadnum = '9';
	else
	{
		cout << endl << "There is no digit on the telephone keypad that corresponds to " << userChar << '.' << endl;
		return 1;
	}

	cout << endl << "The digit " << keypadnum << " corresponds to the letter " << userChar << " on the telephone keypad." << endl;

	return 0;
}