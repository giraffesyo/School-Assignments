//Michael McQuade
//C++ Programming
//Assignment 4
//Ass4_SavingsAccount.cpp
//This file contains the definitions for the SavingsAccount Class for assignment 4. 

#include <string>
#include <iostream>
#include <iomanip>
#include "Ass4_SavingsAccount.h"


int SavingsAccount::objectCount = 0; // This number will be one behind objectNumber at all times.
double SavingsAccount::annualInterestRate = 0.0; //Shared by all accounts

//Default constructor which initializes data members to empty strings and 0 values, object assigned objectCount+1.
SavingsAccount::SavingsAccount() : objectNumber(objectCount + 1)
{
	firstName = "";
	lastName = "";
	savingBalance = 0.0;
	objectCount++;
}

//Consturctor with only name given, initializes balance to 0.0; object assigned objectCount+1
SavingsAccount::SavingsAccount(std::string name) : objectNumber(objectCount + 1)
{
	parseName(name);
	savingBalance = 0.0;
	objectCount++;
}

//Full constructor, initializes name to passed value and balance to passed value. object assigned objectCount+1
SavingsAccount::SavingsAccount(std::string name, double startBalance) : objectNumber(objectCount + 1)
{
	parseName(name);
	savingBalance = startBalance;
	objectCount++;
}

//Destructor - when an account object goes out of scope will print a message to the screen.
SavingsAccount::~SavingsAccount()
{
	std::cout << "Object has gone out of scope" << std::endl;
}

//setName is alias for parseName function which handles string types.
void SavingsAccount::setName(std::string name)
{
	parseName(name);
}

//Concatenates firstName and lastName members and returns them to caller
std::string SavingsAccount::getName() const
{
	return firstName + " " + lastName;
}

//Sets the account balance to passed double.
void SavingsAccount::setBalance(double newBalance)
{
	savingBalance = newBalance;
}

//Returns account balance.
double SavingsAccount::getBalance() const
{
	return savingBalance;
}

//Sets the interest rate. Pass the interest rate naturally e.g setInterestRate(4.50)
void SavingsAccount::setInterestRate(double newInterestRate)
{
	annualInterestRate = newInterestRate / 100.0;
}

//Returns the interest rate for all accounts. Returns it naturally e.g 4.5
double SavingsAccount::getInterestRate() 
{
	return annualInterestRate * 100.0;
}

//Returns the account number for the object.
double SavingsAccount::getNumber() const
{
	return objectNumber;
}

//Outputs to the screen all information about the account.
void SavingsAccount::display() const
{
	std::cout << std::fixed << std::showpoint << std::setprecision(2);
	std::cout << "Name: " << getName() << std::endl;
	std::cout << "Balance: " << getBalance() << std::endl;
	std::cout << std::setprecision(0) << std::noshowpoint;
	std::cout << "Account Number: " << getNumber() << std::endl << std::endl;
}

//Calculates the new balance of an account after 1 month of interest has accrued.
void SavingsAccount::calculateNewBalance()
{
	savingBalance += annualInterestRate / 12.0 * savingBalance;
}

//ParseName function used privately within class
//reads the received name string and sets account firstName to anything before first space, everything after is lastName. If no last name, only sets the first name.
void SavingsAccount::parseName(std::string name)
{
	if (name.find(" ") != std::string::npos)
	{
		firstName = name.substr(0, name.find(" "));
		lastName = name.substr(name.find(" ") + 1, name.size() - 1);
	}
	else
		firstName = name;
}

//Allows increase of account balance with operator+=
void SavingsAccount::operator+=(const double ammountToIncrease)
{
	setBalance(getBalance() + ammountToIncrease);
}

//Allows decrease of account balance with operator-=
void SavingsAccount::operator-=(const double ammountToDecrease)
{
	setBalance(getBalance() - ammountToDecrease);
}

//Requests input for keyboard which will populate a SavingsAccount object
std::istream & operator>>(std::istream & input, SavingsAccount & account)
{
	std::cout << "Please enter in an an account name: ";
	std::string inputString;
	double newBalance;
	std::getline(input, inputString);
	account.parseName(inputString);
	std::cout << "\nName set to: " << account.getName();
	std::cout << "\nPlease enter in a new balance: ";
	input >> newBalance;
	account.setBalance(newBalance);
	return input;
}

//displays information on the screen about received SavingsAccount 
std::ostream & operator<<(std::ostream & output, const SavingsAccount & account)
{
	account.display();
	return output; 
}
