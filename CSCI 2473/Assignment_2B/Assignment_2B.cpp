//Michael McQuade
//C Programming
//Chapter 2 Problem 4
//Assignment_2B.cpp
//A simple program which prints out eight business cards in a single window.

#include<iostream>
#include<string>

using namespace std;

//All business card fields
const string myName = "Michael McQuade";
const string myAddress = "700 N Greenword Ave, Tulsa, OK 74106";
const string myPhone = "918-594-8000";
const string myEmail = "michael.mcquade@okstate.edu";

//This will create the two columns.
const string nameLine = myName + "\t\t\t\t" + myName;
const string addressLine = myAddress + "\t" + myAddress;
const string phoneLine = myPhone + "\t\t\t\t" + myPhone;
const string emailLine = myEmail + "\t\t" + myEmail;


int main()
{
	cout << nameLine << endl;
	cout << addressLine << endl;
	cout << phoneLine << endl;
	cout << emailLine << endl << endl; //Double end line manipulator for space after each card

	cout << nameLine << endl;
	cout << addressLine << endl;
	cout << phoneLine << endl;
	cout << emailLine << endl << endl;

	cout << nameLine << endl;
	cout << addressLine << endl;
	cout << phoneLine << endl;
	cout << emailLine << endl << endl;

	cout << nameLine << endl;
	cout << addressLine << endl;
	cout << phoneLine << endl;
	cout << emailLine << endl << endl;

	return 0;
}
