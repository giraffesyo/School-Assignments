/**
 * Created by giraffe on 9/11/2016.
 */
public class poly {

    private int[] coefficients;

    poly(int[] coefficients)
    {
        this.coefficients = coefficients;
    }

    public int degree()
    {
        return coefficients.length - 1;
    }

    public String toString()
    {
        String PolyString = "";

        //Handles first digit so we don't have a + sign at the beginning
        if (coefficients[coefficients.length - 1] < 0)
        {
            if (coefficients[coefficients.length - 1] == 1)
                PolyString += "x^" + (coefficients.length - 1);
            else
                PolyString += coefficients[coefficients.length - 1] + "x^" + (coefficients.length - 1);

        }
        else
        {
            if (coefficients[coefficients.length - 1] == 1)
                PolyString += "x^" + (coefficients.length - 1);
            else
                PolyString += coefficients[coefficients.length - 1] + "x^" + (coefficients.length - 1);
        }
        // -2  because we started with one outside the loop
        for (int i = coefficients.length - 2; i > 0; i--)
        {
            if (coefficients[i] == 0)
                continue;
            if (coefficients[i] < 0)
            {
                if (i > 1)
                {
                    if (coefficients[i] == 1)
                        PolyString += "x^" + i;
                    else
                        PolyString += coefficients[i] + "x^" + i;
                }
                else
                    {
                    if (coefficients[i] == 1)
                        PolyString += "x";
                    else
                        PolyString +=coefficients[i] + "x";
                    }
            }
            else
            {
                if (i > 1)
                {
                    if (coefficients[i] == 1)
                        PolyString += "+" + "x^" + i;
                    else
                        PolyString += "+" + coefficients[i] + "x^" + i;
                }
                else
                {
                    if (coefficients[i] == 1)
                        PolyString += "+" + "x";
                    else
                    PolyString += "+" + coefficients[i] + "x";
                }
            }

        }

        // This is outside loop so we don't get an x added
        if (coefficients[0] < 0)
            PolyString += Integer.toString(coefficients[0]);
        else
            PolyString += "+" + Integer.toString(coefficients[0]);

        return PolyString;
    }

    private poly add(poly a)
    {
        int newLength = coefficients.length;

        if (newLength < a.coefficients.length )
            newLength = a.coefficients.length;

        int[] newPoly = new int[newLength];

        for( int i = 0; i < newLength; i++)
        {
            newPoly[i] = this.coefficients[i] + a.coefficients[i];
        }
        return new poly(newPoly);
    }

    double evaluate(double x)
    {
        double sum = coefficients[0];
        for (int i = 1; i < coefficients.length; i++)
            sum += Math.pow(x, i) * coefficients[i];
        return sum;
    }

    public static void main(String[] args)
    {
        poly Polynomial1 = new poly(new int[]{4,0,-8,0,3,2});
        poly Polynomial2 = new poly(new int[]{1,1,1,1,1,1});

        final int ResultEvaluate = 84;
        //Test for f(2) == 84 to test evaluate method
        if( Polynomial1.evaluate(2) == ResultEvaluate)
            System.out.println("f(2) = " + ResultEvaluate + ", Test Passed!");
        else
            System.out.println("f(2) = " + Polynomial1.evaluate(2) + "; Test failed!");

        final int ResultDegree = 5;
        //Test degree is 6 for Polynomial 1
        if (Polynomial1.degree() == ResultDegree)
            System.out.println("Degree of polynomial == " + ResultDegree + "; Test Passed!");
        else
            System.out.println("Degree of polynomial == " + Polynomial1.degree() + "; Test failed!");

        final String ResultString = "2x^5+3x^4-8x^2+4";
        //Test .toString() method
        if (ResultString.equals(Polynomial1.toString()))
            System.out.println("The resulting string matches the expected '" + ResultString + "' Test Passed!");
        else
            System.out.println("The resulting string '" + Polynomial1.toString() + "' is incorrect. Test Failed!");

        poly ResultPoly = new poly(new int[]{5,1,-7,1,4,3});
        //Test add method
        if (ResultPoly.toString().equals(Polynomial1.add(Polynomial2).toString()))
            System.out.println("The resulting polynomial equals" + ResultPoly.toString() + " as expected. Test Passed!");
        else
            System.out.println("The resulting polynomial " + Polynomial1.add(Polynomial2).toString() + " is unexpected. Test Failed!;");

    }
}
