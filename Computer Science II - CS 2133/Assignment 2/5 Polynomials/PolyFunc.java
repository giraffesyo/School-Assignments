/**
 * Created by giraffe on 9/13/2016.
 */

/**
 * This class extends the Function class and has several class methods available for various operations on Polynomials.
 * The evaluate() method allow finding the root of a polynomial by returning the result of a
 * polynomial to the findRoot() method within the Function class.
 * Finding the root this way is accessible by creating an object of type PolyFunc and calling its findRoot() method
 */

public class PolyFunc extends Function {

    private int[] coefficients;


    PolyFunc(int[] coefficients)
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

    private PolyFunc add(PolyFunc a)
    {
        int newLength = coefficients.length;

        if (newLength < a.coefficients.length )
            newLength = a.coefficients.length;

        int[] newPoly = new int[newLength];

        for( int i = 0; i < newLength; i++)
        {
            newPoly[i] = this.coefficients[i] + a.coefficients[i];
        }
        return new PolyFunc(newPoly);
    }

    public double evaluate(double x)
    {
        double sum = coefficients[0];
        for (int i = 1; i < coefficients.length; i++)
            sum += Math.pow(x, i) * coefficients[i];
        return sum;
    }

}
