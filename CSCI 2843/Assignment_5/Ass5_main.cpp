//Michael McQuade
//C++ Programming
//Assignment 5
//Ass5_main.cpp
//This file contains the main function for assignment 5. 

#include <vector>
#include <iostream>
#include <fstream>
#include "ass5_staff.h"
#include "ass5_student.h"

void printMenu();
void AddNewStudent(std::vector <student> & phoneBook);
void AddNewStaff(std::vector <staff> & phoneBook);
void LookUpStudent(std::vector <student> & phoneBook);
void LookUpStaff(std::vector <staff> & phoneBook);
void OutputAll(std::vector <student> & student, std::vector <staff> & staff);
void FileOutputAll(std::vector <student> & student, std::vector <staff> & staff);


std::ofstream fileOutput("phonebook_out.txt");

int main()
{
	std::vector <student> studentPhonebook;
	std::vector <staff> staffPhonebook;
	
	int choice;
	bool running = true;

	do
	{
		printMenu();
		std::cin >> choice;
		switch (choice)
		{
			case 1:
				AddNewStudent(studentPhonebook);
				break;
			case 2: 
				AddNewStaff(staffPhonebook);
				break;
			case 3:
				LookUpStudent(studentPhonebook);
				break;
			case 4:
				LookUpStaff(staffPhonebook);
				break;
			case 5:
				OutputAll(studentPhonebook, staffPhonebook);
				break;
			case 6:
				FileOutputAll(studentPhonebook, staffPhonebook);
				break;
			case 7:
				running = 0;
				break;
			default:
				break;
		}

	}
	while (running);


	return 0;
}

//Prints main menu for program
void printMenu()
{
	std::cout << "Please select one of the following options:" << std::endl;
	std::cout
		<< "1: Add new student\n"
		<< "2: Add new staff member\n"
		<< "3: Look up student by last name\n"
		<< "4: Look up staff by last name\n"
		<< "5: Show all phone book entries on screen\n"
		<< "6: Save phonebook to file\n"
		<< "7: Exit Program\n";
	std::cout << std::endl << "Please enter any number 1-7 to choose an option: ";
}

//Lets user create a new student object and puts it in the last spot of student phonebook vector.
void AddNewStudent(std::vector <student> & phoneBook)
{
	std::string first;
	std::string last;
	std::string phoneNumber;
	double gpa;
	int hours;

	std::cout << "Student first name: ";
	std::cin >> first;
	std::cout << "Student last name: ";
	std::cin >> last;
	std::cout << "Student phone number: ";
	std::cin >> phoneNumber;
	std::cout << "Student GPA: ";
	std::cin >> gpa; 
	std::cout << "Student current enrolled hours: ";
	std::cin >> hours;
	std::cout << std::endl;

	phoneBook.emplace_back(first, last, phoneNumber, gpa, hours);
	
	std::cout << "Student " + first + " " + last + " added succesfully\n\n";
}

//Lets user create a new staff object and put it in the last spot of staff phonebook vector
void AddNewStaff(std::vector <staff> & phoneBook)
{
	std::string first;
	std::string last;
	std::string phoneNumber;
	std::string position;
	int employedSince;

	std::cout << "Staff first name: ";
	std::cin >> first;
	std::cout << "Staff last name: ";
	std::cin >> last;
	std::cout << "Staff phone number: ";
	std::cin >> phoneNumber;
	std::cout << "Staff Position: ";
	std::cin >> position;
	std::cout << "Staff year of hire: ";
	std::cin >> employedSince;
	std::cout << std::endl;

	phoneBook.emplace_back(first, last, phoneNumber, position, employedSince);

	std::cout << "Staff " + first + " " + last + " added succesfully\n\n";
}

//Searches and outputs all students with given last name
void LookUpStudent(std::vector <student> & phoneBook)
{
	std::string last;
	std::cout << "Please type in student's last name and press enter: ";
	std::cin >> last;

	for (unsigned int i = 0; i < phoneBook.size(); i++)
	{
		if (phoneBook.at(i).getLastName() == last)
			std::cout << phoneBook.at(i);
	}
}

//Searches and outputs all staff with given last name
void LookUpStaff(std::vector <staff> & phoneBook)
{
	std::string last;
	std::cout << "Please type in staff's last name and press enter: ";
	std::cin >> last;

	for (unsigned int i = 0; i < phoneBook.size(); i++)
	{
		if (phoneBook.at(i).getLastName() == last)
		std::cout << phoneBook.at(i);
	}
}

//Outputs information about all student and staff to screen
void OutputAll(std::vector <student> & student, std::vector <staff> & staff)
{
	for (unsigned int i = 0; i < student.size(); i++)
		std::cout << student.at(i);
	for (unsigned int i = 0; i < staff.size(); i++)
		std::cout << staff.at(i);
}

//Outputs information about all student and staff to file
void FileOutputAll(std::vector <student> & student, std::vector <staff> & staff)
{
	for (unsigned int i = 0; i < student.size(); i++)
		fileOutput << student.at(i);
	for (unsigned int i = 0; i < staff.size(); i++)
		fileOutput << staff.at(i);

	std::cout << "Student and Staff phonebook entries have been written to a file." << std::endl;
}

