Partial 2 - Homework 2

Knapsack Problem Revisited

---

Implement a solution to the Knapsack problem utilizing three different techniques:

1. Brute force

2. Backtracking

3. Branch and bound

Then, analyze the time complexity of you implementations utilizing the heuristic method. Compare your results and determine which has the lowest time complexity.

---

Answers: 
  The original problem has been implemented and solved in the corresponding files.
    - `backtracking.js`
    - `branchandbound.js`
    - `bruteforce.js`
  Each of these files can be ran with node.js or chrome developer tools.

  The timed versions of them using randomly filled arrays were implemented in:
    - `backtrackingHeuristics.js`
    - `branchAndBoundHeuristics.js`
    - `bruteforceHeuristics.js`
  I ran these with Node.js instead of Chrome developer tools because the original plan was to use the node.js filesystem api. However, I only implemented this solution in the `branchAndBoundHeuristics.js` file. The other two simply output their times to the console. I didn't convert these to the filesystem api because I decided to redo the implementation of the graphing site as seen in the previous homework.

Instead of Chart.js, I used Google's charting library available from: https://developers.google.com/chart/ 

I created three buttons which when clicked add their corresponding graphs to the page. Note that it takes a bit for it to generate the data in order to update the page's DOM, please be patient.

The results of these tests was that Branch and Bound has a much lower time complexity than the other two methods analyzed. 

For instance, on the base example that we continually used ( from class ), we went from 24 iterations to only 9 iterations after the implementation of branch and bound (vs backtracking). Based on these tests, the bruteforce method seemed to take cubic time. You can see the trendline applied to the graph in order to compare the results to a cubic polynomial. Finally, the backtracking method was previously analyzed and said to have a complexity of `b^n`.
