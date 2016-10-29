//ass5_individual.cpp
//Contains function definitions for individual base class.

#include "ass5_individual.h"

//Returns full name for this individual.
std::string individual::getName()
{
	return firstName + " " + lastName;
}

std::string individual::getLastName()
{
	return lastName;
}

//Returns phone number for this individual.
std::string individual::getPhoneNumber()
{
	return phoneNumber;
}


//Individual initializer used by derived classes.
individual::individual(std::string first, std::string last, std::string number)
{
	firstName = first;
	lastName = last;
	phoneNumber = number;
}
