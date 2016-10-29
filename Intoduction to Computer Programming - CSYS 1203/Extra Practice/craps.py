# Michael McQuade

# Player rolls 2 6-sided dice
# If the initial roll is 2, 3, or 12, the player loses
# If the roll is 7 or 11 the player wins.
# Any other roll causes the player to "roll for point"
# In other worcds, the dice is rerolled until the initial roll is repeated or the player rolls 7.
# If the initial roll is rolled first, the player wins
# If 7 is rolled first, the player loses.
# Simulate multiple games and estimate probability of winning
from random import randrange

def getResults(n):
    W = 0
    L = 0
    for i in range(n):
        result = playGame()
        if result == True:
            W = W + 1
        else:
            L = L + 1
    return W, L

def playGame():
    iRoll = rollDice()
    if iRoll == 7 or iRoll == 11:
        return True
    elif iRoll == 2 or iRoll == 3 or iRoll == 12:
        return False
    else:
        while True:
            newRoll = rollDice()
            if newRoll == 7:
                return False
            elif newRoll == iRoll:
                return True


def postResults(a, b):
    print("Total won:", a)
    print("Total lost:", b)
    print("Average win percent:", a/(a+b)*100)


def rollDice():
    n = randrange(1,7) + randrange(1,7)
    return n


def main():
    n = 10000
    W, L = getResults(n)
    postResults(W, L)


if __name__ == '__main__':
    main()