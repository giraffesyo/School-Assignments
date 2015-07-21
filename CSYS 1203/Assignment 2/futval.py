# futval.py
#    A program to compute the value of an investment
#    carried 10 years into the future
#    Michael McQuade CSYS 1203

def main():
    print("This program calculates the future value")
    print("of an investment.")

    principal = eval(input("Enter the initial principal: "))
    apr = eval(input("Enter the annual interest rate: "))
    years = eval(input("Enter the amount of year(s) interest will compound: "))

    for i in range(years):
        principal = principal * (1 + apr)

    print("The value in", years, "year(s) is:", principal)

main()
