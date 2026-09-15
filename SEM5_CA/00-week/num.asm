#printing number in MIPS assembly

.data
msg: .asciiz "Enter a number: "

.text
main: # Print Message
	      li $v0, 4
	      la $a0, msg
	      syscall 
	
      # Read Integer
      	li $v0, 5
      	syscall
      	
      # Save the entered number
      	move $t0, $v0
      	
      # Print the number
      	li $v0, 1
      	move $a0, $t0
      	syscall
      	
      # Exit
      	li $v0, 10
        syscall
