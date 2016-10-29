# Averages files using accumulator principles
# By Michael McQuade

def main():
    print("Averages comma separated numbers. ")
    n = (eval(input("Enter number of items to be averaged: ")))
    avg = (eval(input("Enter the numbers to be averaged: ")))
    _sum = 0

    for numbers in avg:
        _sum = _sum + numbers

    avg = _sum / n
    print(avg)


main()
