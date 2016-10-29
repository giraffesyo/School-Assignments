# This simple program will average the numbers entered by a user.
# By Michael McQuade CSYS1203

def main():
    print("This program will average comma separated numbers you enter.")
    n = eval(input("How many numbers are to be averaged? "))
    avg = eval(input("Please enter the numbers you would like averaged: "))

    avg = sum(avg) / n
    print(avg)


main()
