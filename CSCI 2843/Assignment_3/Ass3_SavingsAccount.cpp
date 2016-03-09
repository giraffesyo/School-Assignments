//Michael McQuade
//C++ Progrmaming
//Assigment 3

#include <string>
#include "Ass3_SavingsAccount.h"

SavingsAccount::SavingsAccount() : objectNumber(objectCount)
{
	firstName = "";
	lastName = "";
	savingBalance = 0.0;
	objectCount++;
}
SavingsAccount::SavingsAccount(std::string name)
{

}
SavingsAccount::SavingsAccount(std::string name, double startBalance)
{

}
void SavingsAccount::setName(std::string name)
{

}
std::string SavingsAccount::getName() const
{

}
void SavingsAccount::setBalance(double newBalance)
{

}
double SavingsAccount::getBalance() const
{

}
void SavingsAccount::setInterestRate(double newInterestRate) //instructions said static?
{

}
double SavingsAccount::getInterestRate() const //instructions said static?
{

}
double SavingsAccount::getNumber() const
{

}
void SavingsAccount::display() const
{

}
void SavingsAccount::calculateNewBalance()
{

}