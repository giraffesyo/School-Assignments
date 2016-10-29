//Michael McQuade
//C++ Programming
//Assignment 3
//Ass3_main.cpp
//This file contains the main function for assignment 3. 


#include "Ass3_SavingsAccount.h"

int main()
{
	
	SavingsAccount Saver1("Margaret Olson", 2000.00);
	SavingsAccount Saver2("Debra Baxter");
	SavingsAccount Saver3;

	Saver2.setBalance(5000.00);
	Saver3.setName("Arturo Ortiz");
	Saver3.setBalance(10000.00);

	Saver1.calculateNewBalance();
	Saver2.calculateNewBalance();
	Saver3.calculateNewBalance();

	Saver1.display();
	Saver2.display();
	Saver3.display();

	SavingsAccount::setInterestRate(10.0);

	Saver1.calculateNewBalance();
	Saver2.calculateNewBalance();
	Saver3.calculateNewBalance();

	Saver1.display();
	Saver2.display();
	Saver3.display();
	
	return 0;
}
