/**
 * Created by giraffe on 8/29/2016.
 */

import java.util.Scanner;

public class Average {
    public static void main(String[] args)
    {
        int currentInput;
        int runningSum = 0;
        int countOfNums = 0;
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter as many numbers as you would like to be averaged, type a negative number to quit: ");


        while(true)
        {
            currentInput = userInput.nextInt();

            if(currentInput < 0)
            {
                break;
            }
            runningSum += currentInput;
            countOfNums++;


        }
        System.out.println("You entered " + countOfNums + " numbers. The average is: " + runningSum / countOfNums);
    }
}
