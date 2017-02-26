<article class="markdown-body">

### [<span class="headeranchor"></span>](#cs-3443-computer-systems-program-1-combinatorial-circuits)CS 3443 : Computer Systems  
Program 1: Combinatorial Circuits

Dr. David Cline

* * *

Given the basics of Boolean algebra, and the rules of assembling logic gates, it is fairly straightforward to build up quite complicated and interesting circuits. In this assignment, you will design a number of combinatorial circuits using a text-based design tool implemented by the instructor. The goal of this, and the next assignment, is to allow you to design all of the internals of a fully functional CPU at the gate level, starting with nothing more than a NAND gate.

### [<span class="headeranchor"></span>](#directions)Directions

Download the CircuitSim tool and manual from github ([https://github.com/clinedav/circuitSim](https://github.com/clinedav/circuitSim)), and get it running on your machine. Then read the CircuitSim.txt manual. The tool itself is a simple command line utility written in Java and distributed as a .jar file. (Note that it does not have a GUI, so you have to run it from the command line.) It takes as input text files that specify the logical design of circuits, as well as test cases for the circuits.

Implement the circuits below, starting with nothing but a NAND gate, implemented as a truth table. For this assignment, implement all of the circuits by only using the NAND gate as a basis. In other words, do not use truth tables for any other circuit. (Hint: Think hierarchically. Build up the more complicated circuits using simpler circuits that you have already implemented.)

1.  AND, OR, NOT, XOR, NOR
2.  Majority of 5 circuit (5 inputs, 1 output)
3.  Full Adder (3 inputs, 2 outputs)
4.  8 bit ripple-carry adder with carry out (17 inputs, 9 outputs)
5.  16-bit carry-select adder (33 inputs, 17 outputs). Hint: use 3 8-bit adders.
6.  1 bit multiplexer - select one of two input bits (2 data inputs, 1 control line input, 1 output)
7.  4 bit multiplexer (4 inputs and 2 control lines, plus 1 output)
8.  3 to 8 decoder (3 inputs, 8 outputs)
9.  4 bit OR gate (4 inputs, 1 output. OUT = X3 | X2 | X1 | X0)
10.  16 bit selector - (a multiplexer that selects between two 16 bit words: 33 inputs, 16 outputs)
11.  1 bit ALU (6 inputs: F1, F0, INVB, CIN, A0, B0), (2 outputs: COUT, S0).
    *   F1, F0 give the operation: 00=add, 01=and, 10=or, 11=xor.
    *   The CIN value is also added, so that INVB=1 with CIN=1 performs two’s complement subtraction.
    *   2 outputs: COUT, S0)
12.  The Hack ALU defined in the book (inputs: x[15:0], y[15:0], zx, nx, zy, ny, f, no) (outputs: out[15:0], zr, ng)

For the smaller circuits, with 5 inputs or fewer, have CircuitSim print out a truth table to verify that they are working correctly. For the larger ones, you should make a test case file with a reasonable number of test cases. (I may add some others when I pass off your program.)

Pass off your circuits directly to the instructor or TA. turn in your circuit files and test cases to D2L.

* * *

### [<span class="headeranchor"></span>](#suggestions)Suggestions

*   Build up your design by incrementally creating larger and larger units.

*   Start by building all of the simple gates. You may also want to create larger variants of many of these. For example AND8 might be an AND gate that takes 8 inputs instead of 2\. Similarly, parts of the different units might be built in several stages.

*   Keep in mind that gate names should not start with a number. Use the same naming convention you would for identifiers in Java or C++.

*   Read the CircuitSim manual, and use the macro system available in CircuitSim. This makes things a lot easier.

*   If you have multiple inputs that represent a number, put the high-order bits first. In other words, use B[7:0] instead of B[0:7]. That way, the inputs will line up in natural order to be read as binary numbers.

</article>
