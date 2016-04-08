//Michael McQuade
//C++ Programming
//Assignment 4
//Ass4_SavingsAccount.cpp
//This file contains the definitions for the SavingsAccount Class for assignment 4. 

#include <string>
#include <iostream>
#include <iomanip>
#include "Ass4_SavingsAccount.h"


int SavingsAccount::objectCount = 0;
double SavingsAccount::annualInterestRate = 0.0;

SavingsAccount::SavingsAccount() : objectNumber(objectCount + 1)
{
	firstName = "";
	lastName = "";
	savingBalance = 0.0;
	objectCount++;
}

SavingsAccount::SavingsAccount(std::string name) : objectNumber(objectCount + 1)
{
	parseName(name);
	savingBalance = 0.0;
	objectCount++;
}

SavingsAccount::SavingsAccount(std::string name, double startBalance) : objectNumber(objectCount + 1)
{
	parseName(name);
	savingBalance = startBalance;
	objectCount++;
}

SavingsAccount::~SavingsAccount()
{
	std::cout << "Object has gone out of scope" << std::endl;
}

void SavingsAccount::setName(std::string name)
{
	parseName(name);
}
std::string SavingsAccount::getName() const
{
	return firstName + " " + lastName;
}
void SavingsAccount::setBalance(double newBalance)
{
	savingBalance = newBalance;
}
double SavingsAccount::getBalance() const
{
	return savingBalance;
}
void SavingsAccount::setInterestRate(double newInterestRate)
{
	annualInterestRate = newInterestRate / 100.0;
}
double SavingsAccount::getInterestRate() 
{
	return annualInterestRate * 100.0;
}
double SavingsAccount::getNumber() const
{
	return objectNumber;
}
void SavingsAccount::display() const
{
	std::cout << std::fixed << std::showpoint << std::setprecision(2);
	std::cout << "Name: " << getName() << std::endl;
	std::cout << "Balance: " << getBalance() << std::endl;
	std::cout << std::setprecision(0) << std::noshowpoint;
	std::cout << "Account Number: " << getNumber() << std::endl << std::endl;
}
void SavingsAccount::calculateNewBalance()
{
	savingBalance += annualInterestRate / 12.0 * savingBalance;
}

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
}