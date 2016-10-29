# Fibonacci revisited (10 points)

Create a file called `FibTest.java`. Refactor your `Fib.java` from assignment 1 to be a `static` method in `FibTest`. Odds are that your assignment 1 answer is coded in iterative style, where you are looping from `1` to `n` and adding up numbers as you go. If not, you should write an iterative Fibonacci calculator that does so (and refactor the version that you wrote for assignment 1 for the next part of the problem). This method should be called:

`public static int fibIter(int n)`

The recurrence relation for the Fibonacci sequence is the following:

```
f ib(1) = 1
f ib(2) = 1
f ib(n) = f ib(n − 1) + f ib(n − 2)
```

Write another `static` method in the same `FibTest` class, this time in recursive style, using this relationship.

`public static int fibRecur(int n)`

In FibTest’s `main` method, write a series of tests that establishes that both of these functions work correctly. Finally, using Java’s `System.currentTimeMillis()` function, print out the time it takes to execute `FibTest.fibIter(40)` and `FibTest.fibRecur(40)`.
