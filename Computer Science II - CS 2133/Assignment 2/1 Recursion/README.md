#Recursion (10 points)


Create a file called `Factorial.java`. This file should have the following method:

`public static long calculate(long n)`

`Factorial.calculate` should recursively calculate `n!`, where `0! = 1` and `n! = n(n − 1)!`. The method should also print out an error and exit if `n < 0` or `n > 20`, since factorial is not defined for negative numbers and will overflow Java’s long variable with larger numbers (if we used an int, it would overflow even sooner!).

Inside `Factorial.java`, also include a `main` method which runs a couple of tests on `Factorial.calculate`:

```sh
java Factorial
Factorial.calculate(0) returned 1. Test passed!
Factorial.calculate(5) returned 120. Test passed!
```

(Obviously, if these tests do not return 1 and 120 respectively, the tests should fail and print out an appropriate message.)
