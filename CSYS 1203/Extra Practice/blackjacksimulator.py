# Michael McQuade
# Simulate the probability the dealer will bust in a game of blackjack.
from random import randrange

def getProbability(n):
    Won = 0
    Lost = 0
    for i in range(n):
        result = playGame()
        if result < 22:
            Won = Won + 1
        else:
            Lost = Lost + 1

    return Won, Lost


def playGame():
    hasAce = False
    handsum = drawCard()
    if handsum == 1:
        hasAce = True
    while drawing(handsum):
        if hasAce:
            if ((handsum + 10) <= 21) and ((handsum + 10) >= 17):
                handsum = handsum + 10
            else:
                handsum = handsum + drawCard()
        else:
            handsum = handsum + drawCard()
    return handsum


def drawCard():
    n = randrange(1, 14)
    if n > 10:
        n = 10
    return n


def drawing(n):
    return n < 17

def printResults(W, L):
    total = W + L

    print("Total games played:", total)
    print("Dealer didn't bust: {}\nDealer busted: {}".format(W, L))
    print("Percent dealer didn't bust:", str(W/total*100) + "%")


def main():
    n = 1000000
    Won, Lost = getProbability(n)
    printResults(Won, Lost)


if __name__ == '__main__':
    main()