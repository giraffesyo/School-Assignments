//Michael McQuade
//C++ Programming
//Assignment 2
//Ass2_main.cpp
//This file contains the rectangle class prototypes for assignment 2. 

#pragma once

class rectangle
{
public:
	rectangle();
	rectangle(double l);
	rectangle(double l, double w);
	void setlength(double l);
	void setwidth(double w);
	double getlength();
	double getwidth();
	bool isSquare();
	double getperimeter();
	double getarea();
private:
	double length;
	double width;
	void printError(double size);
};