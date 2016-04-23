//ass5_student.cpp
//Contains member function definitions for student class.

#include "ass5_student.h"


student::student(std::string first, std::string last, std::string Number, double grade, int studenthours) : individual(first, last, Number), GPA(grade), hoursEnrolled(studenthours)
{}

//Returns current amount of enrolled hours for this student as int
int student::getCurrentHours()
{
	return hoursEnrolled;
}

//Returns current grade point average for this student
double student::getGPA()
{
	return GPA;
}

std::ostream & operator<<(std::ostream & output, student & const student)
{
	output << "Name: " << student.getName() << std::endl;
	output << "Phone Number: " << student.getPhoneNumber() << std::endl;
	output << "GPA: " << student.getGPA() << std::endl;
	output << "Current Hours: " << student.getCurrentHours() << std::endl << std::endl;
	return output;
}
