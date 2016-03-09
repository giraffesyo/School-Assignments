//Michael McQuade
//C++ Progrmaming
//Assigment 3

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
	void setInterestRate(double newInterestRate); //instructions said static?
	double getInterestRate() const; //instructions said static?
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
};