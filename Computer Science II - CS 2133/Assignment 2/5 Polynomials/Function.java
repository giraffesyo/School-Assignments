/**
 * Created by giraffe on 9/13/2016.
 */

/**
 * This class servers as an abstract, forcing implementation of the evaluate() method.
 * The main method instantiates an object of each class implementing this evaluate() method
 * and has it print out the roots using the findRoot method contained in this class.
 */
public abstract class Function {

    public abstract double evaluate(double x);

    public double findRoot(double a, double b, double epsilon) {
        double x = (a + b) / 2;

        if (Math.abs(a - x) < epsilon)
            return x;
        else if ((evaluate(x) < 0 && evaluate(a) < 0) || (evaluate(x) > 0 && evaluate(a) > 0)) {
            return findRoot(x, b, epsilon);

        } else {
            return findRoot(a, x, epsilon);
        }

    }

    public static void main(String[] args)
    {
        final double accuracy = 0.00000001;

        SinFunc SinTest = new SinFunc();
        CosFunc CosTest = new CosFunc();
        PolyFunc PolyTest = new PolyFunc(new int[]{-3,0, 1});
        PolyFunc PolyTest2 = new PolyFunc(new int[]{-2,-1,1});

        System.out.println("The root of sin(x) that falls between 3 and 4 is: " +  SinTest.findRoot(3,4,accuracy));
        System.out.println("The root of cos(x) that falls between 1 and 3 is: " + CosTest.findRoot(1,3,accuracy));
        System.out.println("The root of x^2 - 3 is: " + PolyTest.findRoot(0, Integer.MAX_VALUE, accuracy));
        System.out.println("The root of x^2-x-2 is: " + PolyTest2.findRoot(0, Integer.MAX_VALUE,accuracy));

    }


}
