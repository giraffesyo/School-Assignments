#Fibonacci numbers (30 points)
The Fibonacci sequence is a famous mathematical sequence where each successive term is the sum of the two preceding ones. This can be expressed mathematically as F<subscript>n</subscript> = F<subscript>(n−1)</subscript> + F<subscript>(n−2)</subscript>, where F<subscript>1</subscript> = 1 and F<subscript>2</subscript> = 1. The sequence, therefore, goes 1, 1, 2 (1+1), 3 (1+2), 5 (2+3), 8 (3+5), 13 (5+8), 21, 34, 55, 89, 144... 

Write a program called `Fib.java` which allows a user to enter a number `n` as a command-line argument. The program will print out the `n`th Fibonacci number.

Hint: you will have to change the argument in the variable `arg[0]` from a `String` to an `int` using `Integer.parseInt()`.


```sh
$ java Fib 4
3
$ java Fib 7
13
$ java Fib 11
89
```
