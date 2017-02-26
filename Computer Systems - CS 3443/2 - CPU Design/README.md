<article class="markdown-body">

* * *

### [<span class="headeranchor"></span>](#cs-3443-computer-systems-program-2-cpu-design)CS 3443 : Computer Systems  
Program 2: CPU Design

Dr. David Cline

* * *

In this assignment, you will once again use the CircuitSim tool, but this time you will design, down to the gate level, a large chunk of a CPU capable of running a subset of the MIPS instructions. Once the principles of Digital Logic design are known, it is surprising how straightforward a task this can be.

### [<span class="headeranchor"></span>](#directions)Directions

Download the starter files and test cases from D2L.

Using the starter file as an interface, create a circuit that will decode and run a subset of R-type MIPS instructions. The input to your circuit will be three 32-bit numbers, namely, the instruction itself and two other numbers that will serve as register values. Your circuit will have a 32-bit output, the result of the instruction. Note that you do not need to save the value anywhere, just output it from the circuit.

Your circuit must implement the following instructions:

*   ADDU – add unsigned (does the same thing as ADD)
*   ADD – Add (ignore the overflow)
*   ADDI – Add immediate (ignore the overflow)
*   AND – Bitwise AND of two registers
*   ANDI – Bitwise AND immediate
*   OR – Bitwise OR
*   ORI – Bitwise OR immediate
*   SLT – Set less than
*   SLTI – Set less than immediate
*   SRL – Shift right logical
*   SRLV – Shift right logical variable
*   SRA – Shift right arithmetic
*   SUB – Subtract (ignore the overflow)
*   MULT – Multiply
*   XOR – Bitwise exclusive or
*   XORI – Bitwise exclusive or immediate

Test your circuit with the test files provided.

Pass off your circuits directly to the instructor. Also, zip up your circuit files and turn them in to D2L. Use a zip file, not rar!

* * *

### [<span class="headeranchor"></span>](#suggestions)Suggestions

*   Read the MIPSCPUunits.txt handout

*   Build up your design by incrementally creating larger and larger units.

*   Start by building all of the simple gates. You may also want to create larger variants of many of these. For example AND8 might be an AND gate that takes 8 inputs instead of 2\. Similarly, parts of the different units might be built in several stages. For example, you could build a 1-bit ALU, and then stack 32 of these together to complete the 32-bit ALU. Keep in mind that gate names should not start with a number.

*   Build up the different functionalities in different circuits and test them separately. Then combine them together. Don’t try to create the whole circuit in one file. This is a sure fire way to have major problems.

*   The instruction encodings can be found in the handouts.

*   If you have multiple inputs that represent a number, put the high-order bits first. In other words, use B[31:0] instead of B[0:31]. That way, the inputs will line up in natural order to be read as binary numbers.

</article>
