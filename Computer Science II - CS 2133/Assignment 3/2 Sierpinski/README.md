#Sierpinski’s Triangle (30 points)

Sierpinski’s Triangle is a simple and famous example of a fractal image. It is built recursively from a simple set of rules, illustrated in Figure 2.

Your task will be to create an application that illustrates a perfect Sierpinski triangle, regardless of how large the application frame is. As the user moves and resizes the application window, the triangle should be redrawn and made larger or smaller as appropriate.

Your program should display a frame that is based on the size of the user’s screen. The
`paintComponent` method of the panel on which you are drawing will be called whenever the frame is resized, so that happens automagically and you don’t have to worry about it. `JPanel` includes a `getHeight()` and `getWidth()` method that you will be able to use to get the information you need for passing to a recursive draw function that you will write.

The draw algorithm takes the coordinates and dimensions of a square area of the screen as
input. If that square is the size of a single pixel, it should call `drawRect()` on the Graphics object
passed into `paintComponent`, drawing a one-pixel square at the given coordinates. If larger, it should call the draw method three times recursively, once on the lower left quadrant of the square, once on the lower right, and once on an area centered above the other two (as illustrated in Figure 2).

The solution will look a lot like Figure 3, with the largest triangle fitting into the largest square area of the frame, and the smallest triangles being three pixels in size.


![Figure 1](https://i.stack.imgur.com/HWJL0.png)  
Figure 1: Example output for Problem 1. Feel free to be more creative than this.

![Figure 2](https://i.stack.imgur.com/uFhM7.png)  
Figure 2: Fractal representation of Sierpinski construction from Problem 2. (Image source: Wikipedia)

![Figure 3](https://i.stack.imgur.com/dBdJO.png)  
Figure 3: Representative illustration of the Sierpinski problem solution.
