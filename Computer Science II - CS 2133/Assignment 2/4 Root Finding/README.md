# Root finding (20 points)

The roots of a continuous function are points at which the value of the function is equal to zero.

If we happen to know a value for which the function is positive and another value for which it is negative, then we know for certain that somewhere between the two values lies a zero. In other words, if `f(a) > 0` and `f(b) < 0`, then there exists a value `x` between `a` and `b` for which `f(x) = 0`.  
This fact suggests that we can zero in on the value of `x` using the following algorithm, where epsilon is the amount of error we are willing to tolerate:

1. Compute x, where x is halfway between `a` and `b`, ie `x = (a+b)/2`.
2. If `|a − x| < epsilon` return `x`.
3. If `f(x)` has the same sign as `f(a)`, the root lies between `x` and `b`. Recursively perform the algorithm with `x` as the new `a`.
4. Otherwise, the root lies between `a` and `x`. Recursively perform the algorithm with x as the new `b`.

Write a class `FunctionTest.java` and implement the following method:

`public static double findRoot(double a, double b, double epsilon)`

Within `findRoot()`, use `Math.sin()` as the function to be evaluated. In your main function, print out the root of `sin(x)` that falls between 3 and 4, to within 0.00000001.

Does the number look familiar?
