//Michael McQuade
//C Programming
//Chapter 7 Program B
//Assignment_7B.cpp
//This program draws a figure using ASCII characters

#include <iostream>

int main()
{
	for (int line = 1; line <= 7; line++)
	{
		for (int lessthan = 1; lessthan <= 7 - line; lessthan++)
			std::cout << '<';
		for (int space = 1; space <= line; space++)
			std::cout << ' ';
		for (int pound = 1; pound <= 14 - 2 * line; pound++)
			std::cout << '#';
		for (int asterisk = 1; asterisk <= line * 2 - 2; asterisk++)
			std::cout << '*';
		for (int space = 1; space <= line; space++)
			std::cout << ' ';
		for (int greaterthan = 1; greaterthan <= 7 - line; greaterthan++)
			std::cout << '>';
		std::cout << std::endl;
	}

	return 0;
}

/*
t
*/