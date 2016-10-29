/**
 * Created by giraffe on 8/29/2016.
 */
public class Fib {
    public static void main(String[] args)
    {
        int userInput = Integer.parseInt(args[0]);

        double fibSum = 1;
        double fibIndex = 0;
        double fibIndexPrevious = 0;

        for(int i = 1; i < userInput; i++)
        {
            fibIndex = fibSum;
            fibSum = fibIndex + fibIndexPrevious;
            fibIndexPrevious = fibIndex;
        }
        System.out.println("The fibonacci number for the position " + userInput + " is: " + fibSum);
    }

}
