Partial 2 - Homework 1

Knapsack Problem

Given n items of known weights **w**₁, ...,**w**n and values **v**₁, ..., **v**n and
a knapsack of capacity **W**, find the most valuable subset of the items that fit into the knapsack.

- Implement the recursive algorithm to solve the knapsack problem discussed in class.

- Approximate its time complexity utilizing the heuristic method.

- Can you determine its time complexity with another method?

---

Answers:

1. Please run `knapsack.js` to see that the implementation optimally solves the original problem worked inc lass. You can run it by pasting it into the chrome developer tools console or by running `node knapsack.js` in your terminal with node.js installed.

2. The excel sheet was my original way to graph the times taken by the test cases, but then I made the `index.html` file.

    You can refresh the page and it will rerun the tests and generate new results. The top graph and bottom graph both use the same test cases, but the bottom graph has its y-axes (time taken for experiment) run through the log function. The x-axes in both represent the size of the array used.

    I didn't incorporate it into the webpage, but the program knapsack.js supports different step sizes for arrays, you can uncomment the block of code and comment `OriginalProblem()` in order to run the program in a console. The `stepSize` variable is what controls how much bigger each array should be than the last.

    Careful, growing quickly means your computer will have a hard time doing a large number of test cases. Since we see that the numbers grow (roughly) linearly in the logarithmic view, we know that the knapsack function has an exponential order of growth. `n = logb(x)` -> `b^n = x`

3.
    Finally, can we calculate its time complexity in another manner?

    The answer is yes, but we will have trouble doing so. The complexity can be described as `K(W,n) = K(W - weight[i], n-1) + K(W, n-1)`. Which is equal to `K(n) = K(n-1) + K(n-1)`, which is equal to `2K(n-1)`. This can be solved further using the substition method but it will not be trivial to further reduce.

