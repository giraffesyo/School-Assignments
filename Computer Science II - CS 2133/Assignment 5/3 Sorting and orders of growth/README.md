# 3 -	Sorting and orders of growth (35 points)

Implement a program (command-line one will do) that generates two double arrays of length n, filled with identical random doubles between 0 and 1. 
Sort one array using bubble sort, and the other using merge sort (both of which you must implement). 
Time each execution and print the result. 
If it takes longer than 20 seconds, stop executing and report the fact. 
If you run out of memory, stop executing and report the fact. 
Exception handling will help here, don't let your program crash or run for hours.

Your program should do this over and over until you either run out of memory or neither sort nishes within twenty seconds. 
Start n out at ten, and multiply by 10 each time, so you're testing the algorithm at n = 10; 100; 1000; 10000; etc.

Write a couple of lines in the code's comments discussing the running time di erence between O(n^2) and O(n log n) sorting methods.
