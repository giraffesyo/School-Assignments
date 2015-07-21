# bmi.py
# Michael McQuade

# Assignment (for reference):
# The body mass index is calculated as a person's weight (lbs) times 720,
# divided by the square of the person's height (in). A BMI in the range 19-25,
# (inclusive), is considered healthy. Write a program that calculates a person's bmi
# and prints a message telling whether they are above, within, or below the healthy range.

def bmi(weight, height):
    score = weight * 720 // (height * height)
    if score > 25:
        health = "above"
    elif score < 19:
        health = "below"
    else:
        health = "within"
    return score, health

def main():
    print("This program evaluates your BMI and advises if you are within a healthy range.\n")
    weight = eval(input("Please enter your weight in pounds >> "))
    height = eval(input("Please enter your height in inches >> "))
    score, health = bmi(weight, height)
    print("Your BMI is:", score, "\n Your BMI is "+health+" the normal range.")

if __name__ == "__main__":
    main()
