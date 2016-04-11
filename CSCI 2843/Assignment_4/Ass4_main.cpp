//Michael McQuade
//C++ Programming
//Assignment 4
//Ass4_main.cpp
//This file contains the main function for assignment 4. 


#include "Ass4_SavingsAccount.h"
#include <iostream>

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

	//Begin 4th object for Assignment 4:

	SavingsAccount Saver4;
	std::cin >> Saver4;

	Saver4 += 5000.00;
	Saver4 -= 2500.00;

	std::cout << Saver4;


	return 0;
}
