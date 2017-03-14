<article class="markdown-body">

* * *

### [<span class="headeranchor"></span>](#cs-3443-computer-systems-program-3-mips-simulator)CS 3443 : Computer Systems  
Program 3: MIPS simulator

Dr. David Cline

* * *

One of the best ways to understand how computers works at a basic level is to write a simulator. This will force you to look at the fetch-execute cycle at a deeper level than just using a simulator or talking about how processors work. In this assignment, you will write a simulator that can load and run full MIPS programs (similar to, but more basic than SPIM or MARS). The simulator should run on the command line and take as input a text file. You may use whatever language you wish to program the simulator.

* * *

### [<span class="headeranchor"></span>](#memory-specification)Memory specification

**Main memory.** The memory for your simulator should be declared as a large array of ints. Before loading the program, you should instantiate this memory and set all of its values to 0\. By default, your array should have 4 MB of memory, or 2^20 ints.

**General purpose registers.** MIPS uses 32 general purpose registers. These can also be stored as  
an array of 32 ints.

**Special purpose registers.** Besides the general purpose registers, you will need four additional  
registers to complete the simulator: PC (the program counter), nPC (the next program counter), LO and HI (used to store the results of multiplication and division). A full MIPS implementation has several other registers that we will not need for this assignment, as well as a full set of floating point registers.

* * *

### [<span class="headeranchor"></span>](#file-format)File Format

The file format that we will use will be an ASCII format, rather than a binary format. Lines of the file will specify either memory values or register values. By default, all of the memory values and registers should be set to 0 initially.

A file line that specifies a register will have a register number or name in square brackets []. General purpose registers will use an “R” followed by the register number (e.g. [R13]), and the PC can also be set using [PC]. When the PC is set, nPC should be set to PC+4\. The value for the register will be given in hex following the register number, as in the following:

<div class="codehilite">

<pre>    [R13] 0x0000ffff
    [PC] 0x00004000
</pre>

</div>

A line that specifies a memory location will give an address followed by some number of memory words, all expressed in hex, and beginning with the prefix “0x”. The memory location comes first and is placed in square brackets []. Any line not beginning with a square bracket should be ignored. Subsequent strings that begin with “0x” are words to be placed consecutively in memory. Any string that does not begin with “0x” signals the end of valid input for the line. This format has several good points. First, it allows us to use SPIM to assemble our programs (we can construct an input file by copying and pasting from its various readout windows in SPIM, and making a few minor adjustments). Second, since the SPIM printouts show the instruction in assembly format, it may help in debugging your simulator.

As an example, the following line contains an add immediate instruction that adds the value 4 to register $29 and stores the result in register $5\.

<div class="codehilite">

<pre> <span class="x">[0x00400004] 0x27a50004   addiu</span> <span class="p">$</span><span class="x">5,</span> <span class="p">$</span><span class="x">29, 4;   184: addiu</span> <span class="p">$</span><span class="nv">a1</span> <span class="x"></span> <span class="p">$</span><span class="nv">sp</span> <span class="x">4</span>
</pre>

</div>

For the purposes of your simulator, only the first two hex values matter; the rest of the line, which lists the generated code in assembly format (and the actual code from input file), can be considered a comment.

Address A=[0x00400004] is a byte address. Since words (ints) are 4 bytes long, the index in your memory array should be A/4\. Thus, if V=0x27a50004 is the value on the line, and MEM is the name of your memory array, your code might have a line like:

<div class="codehilite">

<pre>    MEM[A/4] = V;
</pre>

</div>

Another example, which contains multiple data words on the same line, and is given as follows:

<div class="codehilite">

<pre>    [0x00010000]  0x6c6c6548  0x6f57206f  0x00646c72  0x00000000
</pre>

</div>

In this case, the 4 words spell out the text “Hello World” in ASCII. The encoding places the low order byte first in the character stream. Consequently, the word 0x6c6c6548 spells out the letters  
“Hell”, but from right to left (e.g. 0x48=’H’, 0x65=’e’, and 0x6c=’l’).

* * *

### [<span class="headeranchor"></span>](#mips-instructions)MIPS Instructions

Your simulator must implement the 40 or so MIPS instructions listed below. This may seem like a daunting task, but keep in mind that each one is quite simple. Traditionally, they are clustered in 3 types: R (register), I (immediate) and J (jump). A more fine-grained classification might give groups: Register type, Immediate, Branches, Jumps, Loads, Stores, Multiply and Divide, and Syscall. The most straightforward way to implement the simulator would be to have a big if-else chain that goes through all the valid bit patterns one-by-one. This is fine, but if you are feeling ambitious it is possible to be more clever and efficient. The encodings for all of the instructions can be found on D2L, as well as a good overview of MIPS assembly.

*   ADD – Add (ignore overflow)
*   ADDI – Add immediate (ignore overflow)
*   ADDIU – Add immediate unsigned (same as addi)
*   ADDU – Add unsigned (same as add)
*   AND – Bitwise and
*   ANDI – Bitwise and immediate
*   BEQ – Branch on equal
*   BGEZ – Branch on greater than or equal to zero
*   BGEZAL – Branch on greater than or equal to zero and link
*   BGTZ – Branch on greater than zero
*   BLEZ – Branch on less than or equal to zero
*   BLTZ – Branch on less than zero
*   BLTZAL – Branch on less than zero and link
*   BNE – Branch on not equal
*   DIV – Divide
*   J – Jump
*   JAL – Jump and link
*   JR – Jump register
*   LB – Load byte
*   LUI – Load upper immediate
*   LW – Load word
*   MFHI – Move from HI
*   MFLO – Move from LO
*   MULT – Multiply
*   OR – Bitwise or
*   ORI – Bitwise or immediate
*   SB – Store byte
*   SLL – Shift left logical
*   SLLV – Shift left logical variable
*   SLT – Set on less than (signed)
*   SLTI – Set on less than immediate (signed)
*   SLTIU – Set on less than immediate unsigned
*   SLTU – Set on less than unsigned
*   SRA – Shift right arithmetic
*   SRL – Shift right logical
*   SRLV – Shift right logical variable
*   SUB – Subtract (with overflow)
*   SUBU – Subtract unsigned
*   SW – Store word
*   SB – Store byte
*   SYSCALL – System call (handles input, output, and exiting the program)
*   XOR – Bitwise exclusive or
*   XORI – Bitwise exclusive or immediate

* * *

### [<span class="headeranchor"></span>](#system-calls)System Calls

In MIPS, a syscall instruction calls a utility routine. The routine may do something like print a string, read input, or exit the program. the program chooses which syscall to run based on a number placed in register $v0=$2 before the call is made. Your simulator needs to handle the following system calls:

*   (1) Print integer – Prints an integer held in register $a0=$4\.

*   (4) Print string – Prints a null-terminated string, where $a0 points to the string. Note that the string will be stored as consecutive bytes in your memory array (of ints), so you will have to deal with the differences.

*   (11) Print character – Prints a single character held in a register $a0=$4\.

*   (5) Read integer – Reads an integer from stdin (the keyboard), place it in register $v0=$2\.

*   (8) Read string – Reads a string into address pointed to by $a0=$4, up to $a1-1 characters, and null terminates the string. Note that the characters must be stored as bytes, so you will have to deal with converting a string from the language used for your simulator to a null terminated string stored in an array of ints.

*   (9) Allocate memory – Allocates bytes based on $a0=$4, returns address in $v0=$2\. This can be done by incrementing a global pointer by the size of the memory allocation, and then returning the value of the pointer before incrementing it.

*   (10) Exit – Exits the program, stopping the simulator.

More information can be found in the Syscalls handout on D2L.

* * *

### [<span class="headeranchor"></span>](#running-modes)Running Modes

Your simulator must be able run in two different modes, Debug and Normal, that can be changed when you run the program (on the command line, for example). You are not required to change modes while the program is running.

In Normal mode, the program should run without printing any debug information, and should not pause between instructions. However, the program should print a message stating that it is a MIPS simulator written by you when it starts. The only other output should come from system calls. Also, you should not print anything during a system call unless it is one of the printing system calls.

In Debug mode, your program should once again print your name when it starts. It must print the PC and instruction in Hex as it executes, and require the user to hit a key, such as “Enter” to advance one instruction. You also need to provide commands to print out the contents of the registers in Hex or Decimal, or the value stored at a location in memory without advancing.

* * *

### [<span class="headeranchor"></span>](#assignment)Assignment

*   Download the example programs and example simulator from D2L.

*   Implement the simulator, including both Normal and Debug running modes.

*   Test your simulator on the example programs provided.

*   Write an original program of your own in C. Translate it to MIPS assembly by hand, and convert it to an input file that will run in the simulator. You may use SPIM to help you do this, or do it by hand. Your program must print your name out when it starts. The program should not be trivial, but should be rather simple. An example of the scope I am looking for is something like this: “The program prints your name, and then asks the user to input a string. The program takes the input, reverses it, and prints it out.” Of course, your program must do something different.

*   Pass off your simulator directly to the instructor, and run your program for the instructor.

*   Turn in your simulator code, executable, and any documentation you have made to D2L.

* * *

</article>
