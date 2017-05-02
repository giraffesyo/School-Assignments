//Prints Michael McQuade, gets input from keyboard, then puts a border on it
#include <stdio.h>

int stringlen(char *input);
void print_stars(int length);

int main() {

    //Print my name
    printf("%s", "Michael McQuade\n");

    //Get input
    char string[64];
    scanf("%s", string); // no prompt before this input

    int length = stringlen(string);
    print_stars(length);
    printf("%c", '*');
    printf("%s", string);
    printf("%c\n", '*');
    print_stars(length);

    return 0;
}


//Counts the number of chars in the string
int stringlen(char* input){
    int i = 0;
    while(input[i]!='\0')
        i++;
    return i;
}

//Prints star border based on length of string we previously counted
void print_stars(int length){
    for ( int i = 0; i < length + 2; i ++)
        printf("%c",'*');
    printf("\n");
}
