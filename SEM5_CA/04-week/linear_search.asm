#linear search of element in array in MIPS

.data
array: .word 10, 20, 30, 40, 50, 60, 70, 80, 90, 100
size: .word 10
n: .word 30

msg_found: .asciiz "Element found at position: "
msg_not_found: .asciiz "Element not found!"


.text
.globl main

main:
	la $t0, array
	lw $t1, size 
	lw $t2, n
	
	li $t3, 0
	
loop:
	bge $t3, $t1, not_found
	
	sll $t4, $t3, 2
	add $t5, $t0, $t4
	
	lw $t6, 0($t5)
	
	beq $t6, $t2, found
	
	addi $t3, $t3, 1
	j loop
	
found:
	li $v0, 4
	la $a0, msg_found
	syscall
	
	li $v0, 1
	move $a0, $t3
	syscall
	
	li $v0, 10
	syscall
	

	
not_found: 
	li $v0, 4
	la $a0, msg_not_found
	syscall
	
	li $v0, 10
	syscall
