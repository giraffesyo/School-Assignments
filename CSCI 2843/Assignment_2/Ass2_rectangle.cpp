// Michael McQuade
//C++ Programming
//Assignment 2
//Ass2_main.cpp
//This file contains the rectangle class prototypes for assignment 2. 

#pragma once
#include "Ass2_rectangle.h"
#include <fstream>

extern std::ofstream RectOutput;

//default rectangle is 1.0 length and 1.0 width
rectangle::rectangle()
{
	length = 1.0;
	width = 1.0;
}

//length parameter received as length, width set to default of 1.0
rectangle::rectangle(double l)
{
	if (l > 0.0 && l <= 20.0)
		length = l;
	else
	{
		length = 1.0;
		printError(l);
	}
	width = 1.0;
}

//length and width parameters received and set
rectangle::rectangle(double l, double w)
{
	if (l > 0.0 && l <= 20.0)
		length = l;
	else
	{
		length = 1.0;
		printError(l);
	}
	if (w > 0.0 && w <= 20.0)
		width = w;
	else
	{
		width = 1.0;
		printError(w);
	}
}

//Sets length of rectangle - must be between 0.0 and 20.0 or default will be used
void rectangle::setlength(double l)
{
	(l > 0.0 && l <= 20.0) ? length = l : length = 1.0;
}

//Sets width of rectangle - must be between 0.0 and 20.0 or default will be used
void rectangle::setwidth(double w)
{
	(w > 0.0 && w <= 20.0) ? width = w : width = 1.0;
}

//Returns rectangle::length
double rectangle::getlength()
{
	return length;
}

//returns rectangle::width;
double rectangle::getwidth()
{
	return width;
}

//returns True if object is a square (mathematically)
bool rectangle::isSquare()
{
	return 0.0001 > length - width;
}

//Returns the calculated perimeter for the rectangle object
double rectangle::getperimeter()
{
	return 2.0 * (length + width);
}

//Returns the calculated area for the rectangle object
double rectangle::getarea()
{
	return length * width;
}

//Prints error message if invalid specifications for rectangle object are provided
void rectangle::printError(double size)
{
	RectOutput << "Value of " << size << " is invalid. Values must be greater than 0.0 and less than or equal to 20.0. Default of 1.0 used." << std::endl;
}