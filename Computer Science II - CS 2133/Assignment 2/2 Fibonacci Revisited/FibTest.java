/**
 * Created by giraffe on 9/3/2016.
 */
public class FibTest {
    public static boolean debug = false;

    public static void main(String[] args)
    {

        final int iterations =  40;

        long IterTimeStart = System.currentTimeMillis();
        long IterResult = FibIter(iterations);
        long IterTimeStop = System.currentTimeMillis();
        System.out.println("The iteration method resolved the " + iterations + "th Fibonacci number as: " + IterResult);
        System.out.println("The iteration method took " + (IterTimeStop - IterTimeStart) + " milliseconds to complete.");

        long RecurTimeStart = System.currentTimeMillis();
        long RecurResult = FibRecur(iterations);
        long RecurTimeStop = System.currentTimeMillis();
        System.out.println("The recursion method resolved the " + iterations + "th Fibonacci number as: " + RecurResult);
        System.out.println("The recursion method took " + (RecurTimeStop - RecurTimeStart) + " milliseconds to complete.");

    }

    public static long FibIter(int n)
    {
        long fibSum = 1;
        long fibIndex = 0;
        long fibIndexPrevious = 0;

        for (int i = 1;i < n; i++)
        {
            fibIndex = fibSum;
            fibSum = fibIndex + fibIndexPrevious;
            fibIndexPrevious = fibIndex;
        }
        return fibSum;
    }

    public static long FibRecur(int n) {

        if (n <= 2)
        {
            if(debug)
                System.out.println( "Value of 'n' is " + n + ", 1 was returned");
            return 1;
        }
        else
        {
            if(debug)
                System.out.println("Value of 'n' is " + n + ", returning FibRecur(" + (n -1) + ") + FibRecur(" + (n - 2) + ").");
            return FibRecur(n - 1) + FibRecur(n - 2);
        }
    }

}