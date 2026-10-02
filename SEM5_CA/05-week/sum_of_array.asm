#sum of all elements in array using MIPS 

.data
array: .word 1, 2, 3, 4, 5
size: .word 5
msg: .asciiz "The sum is: "
.text
.globl main

main:
	la $t0, array
	lw $t1, size
	li $t2, 0
	
loop:
	blez $t1, end
	lw $t3, 0($t0)
	add $t2, $t2, $t3
	
	addi $t0, $t0, 4
	addi $t1, $t1, -1
	j loop
	
end:
	li $v0, 4
	la $a0, msg
	syscall
	
	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 10
	syscall
