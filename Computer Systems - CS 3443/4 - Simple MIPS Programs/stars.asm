.data
	name: .asciiz "Michael McQuade\n"
	userInput: .space 100
	#star: .byte '*'
	star: .asciiz "*"
	newline: .asciiz "\n"
.text 
	la $a0, name # load name
	addi $v0, $zero, 4 #indicates we're printing a string
	syscall  #print the string
	
	la $a0, userInput #load addres of array into $a0 
	addi $a1, $zero, 100 #load size of array into $a1, used by syscall
	addi $v0, $zero, 8 #indicates we're getting input
	syscall #get input
	

    	
        	#i++;
	addi $t0, $zero, 0 #int i = 0; ($t0 is going to be the size of the string we get from input)
	countWhile:	#while(input[i]!='\0') ; while $a0[$t0] != '\0' 
		######################
		#add $a0, $t0, $zero #
		#addi $v0, $zero, 1  # Used these for testing where the loop was
		#syscall             #
		######################
		
		la $t1, userInput #load address of userInput into $t1
		add $t1, $t1, $t0 # set $t1 to the address of $t1 + offset
		lb $t1, 0($t1) # load the byte (current character)
		beq $t1, $zero, afterCountWhile # if we reached null character, we're done counting
		nop
		addi $t0, $t0, 1 # $t0++
		j countWhile
		nop
	afterCountWhile:
		add $s0, $zero, $t0 #Save the size of the string
		
		la $t0, userInput # $t0 = &userInput
		add $t0, $t0, $s0 # $t0 = &$t0[$s0] where $s0 is our count of the string
		addi $t0, $t0, -1
		sb $zero, 0($t0)
		
		jal printStars # print top stars
		nop
		
		la $a0, star # single
		addi $v0, $zero, 4
		syscall
		
		la $a0, userInput
		addi $v0, $zero, 4
		syscall # print the word the user put
		
		la $a0, star
		addi $v0, $zero, 4
		syscall
		
		la $a0, newline
		addi $v0, $zero, 4
		syscall
		
		jal printStars #print bottom stars
		nop
	 
	addi $v0, $zero, 10 #indicates we're exiting
	syscall #exit the program
	
	printStars:
		#addi $sp, $sp, -4 # decrement stackpointer
		#sw $s0, 0($sp) # store value in $s0 at stack pointer
		
		add $t0, $zero, $s0
		
		la $a0, star #address for star
		addi $v0, $zero, 4 #indicate we're printing a string
		syscall #print the string 
		#print stars
		printing:
			la $a0, star #address for star
			addi $v0, $zero, 4 #indicate we're printing a string
			syscall #print the string 
			addi $t0, $t0, -1
			beq $t0, $zero, return
			nop
			j printing
			nop
		return:
		la $a0, newline
		addi $v0, $zero, 4
		syscall
		
		#return from function
		#lw $s0, 0($sp)
		#addi $sp, $sp, 4
		jr $ra
	
