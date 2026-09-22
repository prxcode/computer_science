#creating first array in MIPS

.data
array: .word 10, 20, 30, 40, 50, 60, 70, 80, 90, 100
size: .word 10
space: .asciiz " "

.text
.globl main

main:
	la $t0, array	#add of first element
	lw $t1, size	#no. of elements
	li $t2,0

loop:
	bge $t2, $t1, exit
	
	lw $a0, 0($t0)  #load current element
	li $w0, 1	#print integer
	syscall
	
	li $v0, 4
	la $a0, space
	syscall
	
	addi $t0, $t0, 4
	addi $t2, $t2, 1
	
	j loop
	
exit: 
	li $v0, 10
	syscall
