/**
 * Created by giraffe on 9/11/2016.
 */
public class FunctionTest {

    public static double findRoot(double a, double b, double epsilon)
    {
        double x = (a + b) / 2;

        if (Math.abs(a - x) < epsilon)
            return x;
        else if ((Math.sin(x) < 0 && Math.sin(a) < 0) || (Math.sin(x) > 0 && Math.sin(a) > 0))
        {
            return findRoot(x, b, epsilon);

        }
        else
        {
            return findRoot(a, x, epsilon);
        }
    }

    public static void main(String[] args)
    {
        System.out.print("The root of sin(x) that falls between 3 and 4 is: " + findRoot(3,4,0.00000001));
    }
}
