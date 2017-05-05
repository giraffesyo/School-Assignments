.data 
myName: .asciiz "Michael McQuade\n"
prompt: .asciiz "Enter a number: "
newLine: .asciiz "\n"


.text

la $a0 myName
addi $v0 $zero, 4 #string
syscall # print my name

la $a0 prompt
syscall # print prompt

addi $v0 $zero 5 
syscall #get integer

add $s0, $zero, $v0 # save integer we got from user

addi $s1, $zero, 1 #collatz eventually becomes 1

while:
	beq $s0, $s1, afterWhile #if we're 1 we're done!
	nop
	
	addi $t0, $zero, 2 # $t0 = 2
	div $s0, $t0 #divide $s0 / $t0
	mfhi $t1 # save modulus
	bne $zero, $t1, odd #if we're not 0, branch! (branches if odd)
	nop
	mflo $s0 # save division
	add $a0, $zero, $s0 # $a0 = $s0
	addi $v0, $zero, 1 #print integer syscall
	syscall #print $a0 ($s0 or really the division result)
	la $a0, newLine
	addi $v0, $zero, 4
	syscall #print newLine (\n)
	j while
	nop
	odd:
	addi $t0, $zero, 3
	mult $s0, $t0 # 3 * $s0
	mflo $s0 #save multiplication
	addi $s0, $s0, 1
	add $a0, $zero, $s0 # $a0 = $s0 for print
	addi $v0, $zero, 1
	syscall
	la $a0, newLine
	addi $v0, $zero, 4
	syscall
	j while
	nop
afterWhile:
	


addi $v0, $zero, 10
syscall #exit the program


