//Michael McQuade
//C Programming
//Chapter 7 Program A
//Assignment_7A.cpp
//This program gets input and outputs the number which corresponds to it on a phone's keypad.

#include <iostream>

void keyOutput(char keypad)
{
	std::cout << "That key corresponds to: " << keypad << std::endl;
}

int main()
{
	char userChar;
	char keypadnum;
	do {
		std::cout << "Enter a letter and I will tell you the corresponding number on the keypad: ";
		std::cin >> userChar;
		switch (toupper(userChar))
		{
			case 'A':
			case 'B':
			case 'C': keyOutput('2');
				break;
			case 'D':
			case 'E':
			case 'F': keyOutput('3');
				break;
			case 'G':
			case 'H':
			case 'I': keyOutput('4');
				break;
			case 'J':
			case 'K':
			case 'L': keyOutput('5');
				break;
			case 'M':
			case 'N':
			case 'O': keyOutput('6');
				break;
			case 'P':
			case 'R':
			case 'S': keyOutput('7');
				break;
			case 'T':
			case 'U':
			case 'V': keyOutput('8');
				break;
			case 'W':
			case 'X':
			case 'Y': keyOutput('9');
				break;
			default: std::cout << "That letter does not correspond to a key on the keypad." << std::endl;
				break;
		}

		

	} while (userChar != 'Z');



		return 0;
}
