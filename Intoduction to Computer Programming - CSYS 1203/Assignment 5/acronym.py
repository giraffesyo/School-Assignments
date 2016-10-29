#acronym.py
#Michael McQuade

def main():
    print("This program will output an acronym \n"
          "that is formed from the words you input.")
    inAcronym = input("Please type in some words: ")
    listAcronym = inAcronym.split()
    outAcronym = ""
    for i in listAcronym:
        outAcronym = outAcronym + i[0]
    print('The acronym for "'+inAcronym+'" is: ', outAcronym.upper())
main()
