//Michael McQuade
//C Programming
//Chapter 2 Problem 1
//Assignment_2A.cpp
//Simple program which outputs my weekly class schedule.

#include<iostream>
#include<string>

using namespace std;

//Days and timeslots
const string Mon = "Monday  ";
const string Tue = "Tuesday  ";
const string Wed = "Wednesday  ";
const string Thu = "Thursday  ";

const string Time1 = "4:00 PM  ";
const string Time2 = "3:30 PM  ";
const string Time3 = "5:30 PM  ";

//Classes and room numbers
const string Algebra[] = { "College Algebra  ", "8127\n" };
const string Nihongo[] = { "Japanese  ", "410\n" };
const string Geo[] = { "Geology  ", "523\n" };

// Combined strings where efficient
const string MonWedMath = Time1 + Algebra[0] + Algebra[1];
const string TueThuJapan = Time2 + Nihongo[0] + Nihongo[1];
const string TueThuGeo = Time3 + Geo[0] + Geo[1];

void main()
{
	cout << Mon + MonWedMath;
	cout << Mon + "6:00 PM  " + "C Language  " + "4204\n"; 
	cout << Tue + TueThuJapan;
	cout << Tue + TueThuGeo;
	cout << Wed + MonWedMath;
	cout << Thu + TueThuJapan;
	cout << Thu + TueThuGeo;
	cout << Thu + "7:00 PM  " + "Geology Lab  " + Geo[1]; 
}