/**
 * Created by giraffe on 9/13/2016.
 */

/**
 * This extends the Function class allowing evaluate to use the Sin function when
 * the evaluate() method is called from a SinFunc object.
 */

public class SinFunc extends Function {

    public double evaluate(double x)
    {
        return Math.sin(x);
    }


}
