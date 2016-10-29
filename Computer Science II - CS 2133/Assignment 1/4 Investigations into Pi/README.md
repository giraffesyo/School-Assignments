# Investigations into π (30 points)

Thirty-five digits of π are sufficient to calculate the circumference of the universe to within the size of a hydrogen nucleus. In other words, finding the value of π to ten quadrillion digits is pretty much the definition of pointless. But people seem to enjoy doing it anyhow. How? There are a number of methods, but one common approach is to discover an infinite series that converges to the correct value. Here’s one that has been around for hundreds of years, known as the Gregory Series:

[Gregory Series](https://i.stack.imgur.com/ZfOyV.png)

Write a program called `Gregory.java` that takes a number `n` specified by the user (via the command line) and calculates π using the first n terms of the Gregory series. The program should print this approximate value of π, as well as the percentage error between this value and the one provided by Java in the constant `Math.PI`.

Hint: remember to correct for the fact that this series converges to `π/4`, not π itself.

```sh
$ java Gregory 10
Pi according to Gregory series: 3.0418396189294032
This differs from Java’s value by 3.175237710923643 percent.
$ java Gregory 1000
Pi according to Gregory series: 3.140592653839794
This differs from Java’s value by 0.03183098066059948 percent
```
