//Michael McQuade
//C++ Programming
//Assignment 4
//Ass4_SavingsAccount.h
//This file contains the prototypes for the SavingsAccount Class for assignment 4. 


#include <string>
#include <iostream>

class SavingsAccount 
{
public:
	SavingsAccount();
	SavingsAccount(std::string name);
	SavingsAccount(std::string name, double startBalance);
	~SavingsAccount();
	
	void setName(std::string name);
	std::string getName() const;
	void setBalance(double newBalance);
	double getBalance() const;
	static void setInterestRate(double newInterestRate);
	static double getInterestRate(); 
	double getNumber() const;
	void display() const;
	void calculateNewBalance();
	friend std::istream & operator>>(std::istream & input, SavingsAccount & account);
	friend std::ostream & operator<<(std::ostream & output, const SavingsAccount & account);
	void operator+=(const double ammountToIncrease);
	void operator-=(const double ammountToDecrease);


private:
	std::string firstName;
	std::string lastName;
	double savingBalance;
	static double annualInterestRate;
	static int objectCount;
	const int objectNumber;
	void SavingsAccount::parseName(std::string name);
};