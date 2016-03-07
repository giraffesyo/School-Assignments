//Michael McQuade
//C++ Programming
//Assignment 2
//Ass2_main.cpp
//This file contains the main function for assignment 2. 

#include "Ass2_rectangle.h"
#include <vector>
#include <string>
#include <iomanip>
#include <fstream>

std::ofstream RectOutput("output.txt");


void outputTable(std::vector <rectangle> & Rectangles);

int main()
{
	std::vector <rectangle> Rectangles;
	Rectangles.reserve(5);

	//Initialize all of our rectangle objects within our vector
	Rectangles.emplace_back();
	Rectangles.emplace_back(7.1, 3.2);
	Rectangles.emplace_back(6.3);
	Rectangles.emplace_back(21.0, 21.0);
	Rectangles.emplace_back(Rectangles[1]);

	RectOutput << std::endl << "Original Data Table:" << std::endl;
	outputTable(Rectangles);

	Rectangles.at(0).setlength(5.4);
	Rectangles.at(0).setwidth(10.5);
	Rectangles.at(3).setlength(15.6);
	Rectangles.at(3).setwidth(15.6);

	RectOutput << std::endl << std::endl << "Changed Data Table:" << std::endl;
	outputTable(Rectangles);
	RectOutput << std::endl;

	return 0;
}

void outputTable(std::vector <rectangle> & Rectangles)
{
	std::vector <std::string> topLabels{ "", "length", "width", "perimeter", "area", "is square?" };
	std::vector <std::string> leftLabels{ "Object 1", "Object 2","Object 3","Object 4", "Object 5" };

	//Adds labels to top of table from topLabels vector
	for (int i = 0; i < 6; i++)
		RectOutput << std::setw(10) << topLabels.at(i) << "||";
	
	RectOutput << std::endl;

	//Prints content of table and left labels
	for (int i = 0; i < 5; i++)
	{
		RectOutput << std::setw(10) << leftLabels.at(i) << "||";
		RectOutput << std::setw(10) << Rectangles.at(i).getlength() << "||";
		RectOutput << std::setw(10) << Rectangles.at(i).getwidth() << "||";
		RectOutput << std::setw(10) << Rectangles.at(i).getperimeter() << "||";
		RectOutput << std::setw(10) << Rectangles.at(i).getarea() << "||";
		Rectangles.at(i).isSquare() ? RectOutput << std::setw(10) << "yes" : RectOutput << std::setw(10) << "no";
		RectOutput << "||";
		RectOutput << std::endl;
	}
}
