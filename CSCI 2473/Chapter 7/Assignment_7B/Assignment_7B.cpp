//Michael McQuade
//C Programming
//Chapter 7 Program B
//Assignment_7B.cpp
//This program draws a figure using ASCII characters

#include <iostream>

const int linemax = 7;

int main()
{

	for (int line = 1; line <= linemax; line++)
	{
		for (int lessthan = 1; lessthan <= linemax - line; lessthan++)
			std::cout << '<';
		for (int space = 1; space <= line; space++)
			std::cout << ' ';
		for (int pound = 1; pound <= 2 * linemax - 2 * line; pound++)
			std::cout << '#';
		for (int asterisk = 1; asterisk <= line * 2 - 2; asterisk++)
			std::cout << '*';
		for (int space = 1; space <= line; space++)
			std::cout << ' ';
		for (int greaterthan = 1; greaterthan <= linemax - line; greaterthan++)
			std::cout << '>';
		std::cout << std::endl;
	}

	return 0;
}

/*
t
*/