//ass5_staff.cpp
//COntains member function definitions for staff class.

#include "ass5_staff.h"


staff::staff(std::string first, std::string last, std::string Number, std::string title, int employedSince) : individual(first, last, Number), position(title), yearEmployed(employedSince)
{}

//Returns current position for this staff member
std::string staff::getPosition()
{
	return position;
}

//Returns the year this staff member was employed
int staff::getYearEmployed()
{
	return yearEmployed;
}

std::ostream & operator<<(std::ostream & output, staff & const staff)
{
	output << "Name: " << staff.getName() << std::endl;
	output << "Phone Number: " << staff.getPhoneNumber() << std::endl;
	output << "Position: " << staff.getPosition() << std::endl;
	output << "Employed Since: " << staff.getYearEmployed() << std::endl << std::endl;
	return output;
}
