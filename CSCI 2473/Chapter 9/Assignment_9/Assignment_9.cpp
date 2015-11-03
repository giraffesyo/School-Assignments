#include <iostream>
#include <fstream>

using namespace std;

const double Pi = 3.1416;

int Menu();
double AreaOfSquare(double side);
double AreaOfRectangle(double length, double width);
double HypotenuseOfRTri(double side1, double side2);
double AreaOfRTri(double side1, double side2);
double AreaOfIsoTri(double height, double base);
double CircumferenceOfCircle(double radius);
double AreaOfCircle(double radius);
double VolumeOfSphere(double radius);

int main()
{
	ofstream papertrail;
	papertrail.open("output.txt");

	int selectedoption;
	while (true)
	{
		selectedoption = Menu();
		switch (selectedoption)
		{
			case 1 :  
			{
				double side;
				cout << "Enter the length of a side: ";
				cin >> side;
				cout << endl << "The area of that square is: " << AreaOfSquare(side);
				papertrail << endl << "The area of that square is: " << AreaOfSquare(side);
				break;
			}
			case 2 :
			{
				double length, width;
				cout << "Enter the length and width: ";
				cin >> length >> width;
				cout << endl << "The area of that rectangle is: " << AreaOfRectangle(length, width);
				papertrail << endl << "The area of that rectangle is: " << AreaOfRectangle(length, width);
				break;
			}
			case 3 : 
			{
				double side1, side2;
				cout << "Enter length of the two legs: ";
				cin >> side1 >> side2;
				cout << endl << "The hypotenuse of that right triangle is: " << HypotenuseOfRTri(side1, side2);
				papertrail << endl << "The hypotenuse of that right triangle is: " << HypotenuseOfRTri(side1, side2);
				break;
			}
			case 4 :
			{
				double side1, side2;
				cout << "Enter length of the two legs: ";
				cin >> side1 >> side2;
				cout << endl << "The area of that right triangle is: " << AreaOfRTri(side1, side2);
				papertrail << endl << "The area of that right triangle is: " << AreaOfRTri(side1, side2);
				break;
			}
			case 5 :
			{
				double height, base;
				cout << "Enter height and base: ";
				cin >> height >> base;
				cout << endl << "The area of that isosceles triangle is: " << AreaOfIsoTri(height, base);
				papertrail << endl << "The area of that isosceles triangle is: " << AreaOfIsoTri(height, base);
				break;
			}
			case 6 : 
			{
				double radius;
				cout << "Enter radius: ";
				cin >> radius;
				cout << endl << "The circumference of that circle is: " << CircumferenceOfCircle(radius);
				papertrail << endl << "The circumference of that circle is: " << CircumferenceOfCircle(radius);
				break;
			}
			case 7 : 
			{
				double radius;
				cout << "Enter radius: ";
				cin >> radius;
				cout << endl << "The area of that circle is: " << AreaOfCircle(radius);
				papertrail << endl << "The area of that circle is: " << AreaOfCircle(radius);
				break;
			}
			case 8 : 
			{
			double radius;
			cout << "Enter radius: ";
			cin >> radius;
			cout << "The volume of that sphere is: " << VolumeOfSphere(radius);
			papertrail << "The volume of that sphere is: " << VolumeOfSphere(radius);
			break;
			}
			case 99 : return 0;
		}
		cout << endl << endl;
	}
}

int Menu()
{
	cout << "Select one of the following calculations:" << endl;
	cout << '1' << '\t' << "AREA OF A SQUARE" << endl;
	cout << '2' << '\t' << "AREA OF A RECTANGLE" << endl;
	cout << '3' << '\t' << "HYPOTENUSE OF RIGHT TRIANGLE" << endl;
	cout << '4' << '\t' << "AREA OF RIGHT TRIANGLE" << endl;
	cout << '5' << '\t' << "AREA OF ISOSCELES TRIANGLE" << endl;
	cout << '6' << '\t' << "CIRCUMFERENCE OF CIRCLE" << endl;
	cout << '7' << '\t' << "AREA OF CIRCLE" << endl;
	cout << '8' << '\t' << "VOLUME OF SPHERE" << endl;
	cout << "99" << '\t' << "QUIT PROGRAM" << endl << endl;
	cout << "$ ";

	int choice;
	cin >> choice;
	return choice;
}

double AreaOfSquare(double side)
{
	return side * side;
}

double AreaOfRectangle(double length, double width)
{
	return length * width;
}

double HypotenuseOfRTri(double side1, double side2)
{
	return sqrt(side1 * side1 + side2 * side2);
}

double AreaOfRTri(double side1, double side2)
{
	return side1 * side2 / 2;
}

double AreaOfIsoTri(double height, double base)
{
	return height * base / 2;
}

double CircumferenceOfCircle(double radius)
{
	return 2 * radius * Pi;
}

double AreaOfCircle(double radius)
{
	return radius * radius * Pi;
}

double VolumeOfSphere(double radius)
{
	return 4 * Pi * radius * radius * radius / 3;
}
