//Michael McQuade
//C Programming
//Chapter 3 Problem 1
//Assignment_3A.cpp
//A simple programming which calculates the volume for 3 cones.

#include <iostream>
#include <iomanip>

using namespace std;

const double pi = 3.1416;

//define our cones
const double cones_radius[] = { 10.10, 40.20, 80.30 };
const double cones_height[] = { 20.10, 60.20, 90.30 };

//calculates the volume from radius and height
double getVolume(double radius, double height)
{
	double volume = 1.0 / 3.0 * pi * radius * radius * height;
	return volume;
}

int main() 
{
	//prepare stream and label columns
	cout << fixed << setprecision(2); 
	cout << setw(16) << "Radius" << setw(11) << "Height" << setw(12) << "Volume" << endl; 
	
	int i = 1; // loop counter and cone index
	
	while (i < 4)
	{
		cout
			<< "Cone " << i 
			<< setw(10) << cones_radius[i - 1]
			<< setw(11) << cones_height[i - 1]
			<< setw(12) << getVolume(cones_radius[i - 1], cones_height[i - 1])
			<< endl;

		i++;
	}

	return 0;
}