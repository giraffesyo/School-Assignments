//Ass5_student.h
//Contains member function prototypes and data member declarations for student class.

#pragma once

#include "ass5_individual.h"

class student : public individual
{
public:
	//Constructor
	student(std::string first, std::string last, std::string Number, double grade, int studenthours);
	//Public member functions
	double getGPA();
	int getCurrentHours();
	friend std::ostream & operator<<(std::ostream & output, student & const student);
	
private:
	//Private Data members
	double GPA;
	int hoursEnrolled;
};
