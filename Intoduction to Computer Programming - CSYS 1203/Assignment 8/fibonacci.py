# fibonacci.py
# Michael McQuade

# Assignment (for reference:
# The Fibonacci sequence starts 1, 1, 2, 3, 5, 8, .......
# Each number in the sequence (after the first two) is the
# sum of the previous two. Write a program that computes the
# nth Fibonacci number, where n is a value entered by the user.

def main():
    print("This program computes the Fibonacci sequence.")
    n = eval(input("Please enter a number >> "))

    value = 1
    sum = 0
    for i in range(n):
        sum = sum + value
        value = sum - value

    n = str(n)
    if n[-2:] == "11" or n[-2:] == "12" or n[-2:] == "13":
        n = n + "th"
    else:
        if n[-1] == "1":
            n = n + "st"
        elif n[-1] == "2":
            n = n + "nd"
        elif n[-1] == "3":
            n = n + "rd"
        else:
            n = n + "th"

    print("The", n, "number in the Fibonacci sequence is:", sum)

if __name__ == '__main__':
    main()
