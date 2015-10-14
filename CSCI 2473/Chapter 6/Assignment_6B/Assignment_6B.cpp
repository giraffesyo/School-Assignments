//Michael McQuade
//C Programming
//Chapter 6 Program B
//Assignment_6B.cpp
//Program which counts all 3, 4, 5 and 6 letter words in an input file and outputs the results to the screen.

#include <fstream>

int main()
{
	std::ifstream quotesFile;
	std::ofstream outputFile;

	quotesFile.open("QUOTES.txt");
	outputFile.open("NUMWORDS.txt");

	int letters;
	int words3 = 0;
	int words4 = 0;
	int words5 = 0;
	int words6 = 0;
	char inchar;

	while (quotesFile)
	{
		quotesFile.get(inchar);
		letters = 0;
		while (toupper(inchar) >= 'A' && toupper(inchar) <= 'Z')
		{
			letters++;
			quotesFile.get(inchar);
		}

		if (letters == 3)
			words3++;
		else if (letters == 4)
			words4++;
		else if (letters == 5)
			words5++;
		else if (letters == 6)
			words6++;
	}

	outputFile << "3 letter words: " << words3 << std::endl;
	outputFile << "4 letter words: " << words4 << std::endl;
	outputFile << "5 letter words: " << words5 << std::endl;
	outputFile << "6 letter words: " << words6 << std::endl;
}
