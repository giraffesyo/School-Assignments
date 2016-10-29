//Michael McQuade
//C Programming
//Chapter 8 Program B
//Assignment_8.cpp
//This program allows a loan officer to determine loan eligibility for clients.

#include <iostream>

using namespace std;

void getInput(int& Loantype, double& Income, double& Totaldebt, double& Loanamount);
void Autoloan(double Income, double Totaldebt, double Loanamount, bool& Eligible);
void Mortgage(double Income, double Totaldebt, double Loanamount, bool& Eligible);
void printReport(int Loantype, double Loanamount, bool Eligible);

int main()
{
	int Loantype;
	double Income;
	double Totaldebt;
	double Loanamount;
	bool Eligible;

	do
	{
		getInput(Loantype, Income, Totaldebt, Loanamount);
		if (Loantype == 1)
			Autoloan(Income, Totaldebt, Loanamount, Eligible);
		else if (Loantype == 2)
			Mortgage(Income, Totaldebt, Loanamount, Eligible);
		if (Loantype == 1 || Loantype == 2)
			printReport(Loantype, Loanamount, Eligible);

	} while (Loantype != 3);
	
	return 0;
}

//Acts as our menu, getting all input from keyboard necessary to determine eligibility
void getInput(int& Loantype, double& Income, double& Totaldebt, double& Loanamount)
{
	cout << "SELECT ONE OF THE FOLLOWING OPTIONS:" << endl << endl;
	cout << "   1   AUTO LOAN" << endl;
	cout << "   2   HOME MORTGAGE LOAN" << endl;
	cout << "   3   STOP PROGRAM" << endl << endl;

	cout << "ENTER A NUMBER: ";
	cin >> Loantype;
	if (Loantype == 1 || Loantype == 2)
	{
		cout << "ENTER INCOME, TOTAL DEBT, AND LOAN AMOUNT" << endl;
		cin >> Income >> Totaldebt >> Loanamount;
	}
}
//Determines eligibility of Auto Loan
void Autoloan(double Income, double Totaldebt, double Loanamount, bool& Eligible)
{
	if ((Income - Totaldebt) >= Loanamount * .5)
		Eligible = true;
	else
		Eligible = false;
}

//Determines eligibility of Home Mortgage Loan
void Mortgage(double Income, double Totaldebt, double Loanamount, bool& Eligible)
{
	if ((Income - Totaldebt) >= Loanamount * .3)
		Eligible = true;
	else
		Eligible = false;
}

//Prints Report on eligibility of chosen loan
void printReport(int Loantype, double Loanamount, bool Eligible)
{
	cout << endl << "Loan Type: ";
	if (Loantype == 1)
		cout << "Auto" << endl;
	else
		cout << "Mortgage" << endl;
	cout << "Loan Amount: " << Loanamount << endl;
	cout << "Eligible: ";
	if (Eligible)
		cout << "YES" << endl << endl;
	else
		cout << "NO" << endl << endl;
}
