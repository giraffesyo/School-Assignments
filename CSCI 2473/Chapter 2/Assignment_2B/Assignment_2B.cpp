//Michael McQuade
//C Programming
//Chapter 2 Problem 4
//Assignment_2B.cpp
//A simple program which prints out eight business cards in a single window.

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

//All business card fields
const string myName = "Michael McQuade";
const string myAddress = "700 N Greenwood Ave, Tulsa, OK 74106";
const string myPhone = "918-594-8000";
const string myEmail = "michael.mcquade@okstate.edu";

int main()
{								  
	int cardLength = myAddress.length(); // get length of longest string

	int n = 0;
	while (n<4) // need 4 rows of cards
	{
		cout << left << setw(cardLength) << myName << '\t' << myName << endl; //make two columns and use cardLength for width of card
		cout << left << setw(cardLength) << myAddress << '\t' << myAddress << endl;
		cout << left << setw(cardLength) << myPhone << '\t' << myPhone << endl;
		cout << left << setw(cardLength) << myEmail << '\t' << myEmail << endl << endl; //Double end line manipulator for space after each card
		n++;
	}
	return 0;
}
