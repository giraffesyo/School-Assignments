//Ass5_individual.h
//Contains member function prototypes and data member declarations for individual class.

#pragma once

#include <string>

//base class for student and staff
class individual
{
public:
	//Public Set and Get
	std::string getName();
	std::string getPhoneNumber();
	std::string getLastName();
protected:
	individual(std::string first, std::string last, std::string number);
private:
	//Private Data Members
	std::string firstName;
	std::string lastName;
	std::string phoneNumber;

	//Private Functions
	void individual::parseName(std::string name);
};
