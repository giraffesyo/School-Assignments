/**
 * Created by giraffe on 9/13/2016.
 */

/**
 * This class extends the Function class, providing an implementation for the evaluate() method to evaluate using
 * the trigonometric Cos function by calling the evaluate() method on objects of the CosFunc class.
 */
public class CosFunc extends Function {

    public double evaluate(double x)
    {
        return Math.cos(x);
    }

}
