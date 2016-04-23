//Ass5_staff.h
//Contains member function prototypes and data member declarations for staff class.

#pragma once

#include "ass5_individual.h"

class staff : public individual
{
public:
	//Constructor
	staff(std::string first, std::string last, std::string Number, std::string title, int employedSince);
	//Public Member Functions
	std::string getPosition();
	int getYearEmployed();
	friend std::ostream & operator<<(std::ostream & output, staff & const staff);
private:
	//Private Data Members
	std::string position;
	int yearEmployed;
};
