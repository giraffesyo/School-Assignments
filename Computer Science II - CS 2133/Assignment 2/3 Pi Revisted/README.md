# Pi Revisited (10 points)

In Assignment 1, you used the Gregory formula to compute an approximation of π. Here, you will use Ramanujan’s series, discovered in 1910. It converges much faster than Gregory’s, and has been used to calculate π to billions of digits. Implement `Ramanujan.java` exactly like `Gregory.java`, taking a number n specified by the user on the command line and calculating π using the first `n` terms of the Ramanujan series. The program should print this approximate value of π, as well as the percentage error between this value and the one provided by Java in the constant `Math.PI`.

[Ramanujan’s series](https://i.stack.imgur.com/12OWO.png)  

Notice that this formula makes use of the factorial function. Call your `Factorial.calculate` method from Problem 1.

**Extra credit:** Look at the Java API definitions of `BigDecimal` and `BigInteger`. Rework your Factorial and Ramanujan code (call the classes something else, like `RamanujanBig`, so that you don’t overwrite your regular-credit work) to use these instead, and calculate π to 100 digits or more. Note that, in order for the terms to be perfectly accurate, you also need a `BigDecimal` representation of √2. There is unfortunately no native library support for calculating this; however, you can implement it yourself using a `BigDecimal` version of the evaluate method you will write in Problem 6.  
You will get a little extra credit simply by explaining (in comments in your Ramanujan code) how `BigDecimal` and `BigInteger` differ from ordinary doubles and ints, and why the latter are insufficient for calculating very precise values of π
