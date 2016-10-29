/**
 * Created by giraffe on 9/3/2016.
 */
public class Factorial {

    public static void main(String[] args)
    {
        if (calculate(0) == 1)
        {
            System.out.println("Factorial.calculate(0) returned " + calculate(0) + ". Test passed!");
        }
        else
        {
            System.out.println("Factorial.calculator(0) returned " + calculate(0) + ". Test failed!");
        }

        if (calculate(5) == 120)
        {
            System.out.println("Factorial.calculate(5) returned " + calculate(5) + ". Test passed!");
        }
        else
        {
            System.out.println("Factorial.calculator(5) returned " + calculate(5) + ". Test failed!");
        }

    }

    public static long calculate(long n)
    {
        if (n == 0)
            return 1;
        else if (n < 0)
        {
            System.out.println("Non-negative numbers are not accepted, returned -1");
            return -1;
        }
        else if ( n > 20)
        {
            System.out.println("Too big. Cannot calculate factorials for numbers greater than 20.");
            return -1;
        }
        else
        {
            return n * calculate(n - 1);
        }
    }

}
