Michael McQuade A01677104

Partial 2  
Homework 3  

### Question 1:  

Dijkstra’s algorithm is used for finding shortest paths from a source
node to the rest of the nodes inside a graph. This algorithm
doesn’t determine correct solutions for weighted graphs with
negative values.

Find an example of such behavior and explain, in your own words,
what happens with the algorithm when a graph has negative
weights.


### Answer 1:

Dijkstra's algorithm goes through the adjacent vertices from the source vertex. On this first analysis, it sets a minimum value for the path based off of the value of the first vertex. 

Under normal circumstances, where you are only using positive weights, if you had a path that reaches the destination with only one edge, the minimum found for the other vertexes must be lower than the weight of the edge directly links the source and destination. Otherwise, if it is higher, then it can be assumed that it would be impossible for it to be the optimal path. This is because you will continually add the weights to the initial minimum.

However, this changes with negative values and invalidates this assumption. If you have a negative weight then you can have a shorter path where the minimum of the first edge is larger than the direct path from source to destination node. In this case, Dijkstra's algorithm will not find the shortest path.

### Problem 2:

[![Graph of two towns][1]][1]

The mayors of two small towns want to have roads to travel
among their different locations.

They ask for your help to determine
which of the available options for building a road to connect the
two towns is better.

The available options are:
- Road from d to i (in both directions) with 3 Km
- Road from c to j (in both directions) with 4 Km
- Road from i to e (in both directions) with 10 Km

Implement an algorithm to solve the problem and justify your
answer.


### Answer 2:

I was able to find out that the optimal road to build is the 3km road from d to i. 

I determined this by summing up the total weight of the shortest path for every possible combination of source and target nodes.

The results can be seen in the output of `shortestpath.js` (copied below):

> Total Node Distance with road from d to i: 1297  
> Total Node Distance with road from c to j: 1357  
> Total Node Distance with road from i to e: 1517  


[1]: https://i.stack.imgur.com/MOay7.png
