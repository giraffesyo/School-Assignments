//Michael McQuade
//C++ Programming
//Assignment 3
//Ass3_SavingsAccount.cpp
//This file contains the prototypes for the SavingsAccount Class for assignment 3. 


#include <string>

class SavingsAccount 
{
public:
	SavingsAccount();
	SavingsAccount(std::string name);
	SavingsAccount(std::string name, double startBalance);
	
	void setName(std::string name);
	std::string getName() const;
	void setBalance(double newBalance);
	double getBalance() const;
	static void setInterestRate(double newInterestRate);
	static double getInterestRate(); 
	double getNumber() const;
	void display() const;
	void calculateNewBalance();

private:
	std::string firstName;
	std::string lastName;
	double savingBalance;
	static double annualInterestRate;
	static int objectCount;
	const int objectNumber;
	void SavingsAccount::parseName(std::string name);
};