#arithmetic operations on two number in MIPS

.data
num1: .asciiz "Enter your first number(x): "
num2: .asciiz "Enter your second number(y): "

msg_sum: .asciiz "Sum (x+y): "
msg_dif: .asciiz "\nDifference (x-y): "
msg_mul: .asciiz "\nProduct (x*y): "
msg_div: .asciiz "\nQuotient (x/y): "

newline: .asciiz "\n"

.text
.globl main

main:
	#reading num1
	li $v0, 4
	la $a0, num1
	syscall
	li $v0, 5
	syscall
	move $s0, $v0


	#reading num2
	li $v0, 4
	la $a0, num2
	syscall
	li $v0, 5
	syscall
	move $s1, $v0


	#calling sum
	move $a0, $s0
	move $a1, $s1
	jal sum
	move $t0, $v0

	li $v0, 4
	la $a0, msg_sum
	syscall
	li $v0, 1
	move $a0, $t0
	syscall


	#calling diff
	move $a0, $s0
	move $a1, $s1
	jal difference
	move $t0, $v0

	li $v0, 4
	la $a0, msg_dif
	syscall
	li $v0, 1
	move $a0, $t0
	syscall


	#calling multiplication
	move $a0, $s0
	move $a1, $s1
	jal multiplication
	move $t0, $v0

	li $v0, 4
	la $a0, msg_mul
	syscall
	li $v0, 1
	move $a0, $t0
	syscall

	#calling division
	move $a0, $s0
	move $a1, $s1
	jal division
	move $t0, $v0

	li $v0, 4
	la $a0, msg_div
	syscall
	li $v0, 1
	move $a0, $t0
	syscall

	
	#exit
	li $v0, 10
	syscall

sum: 
	add $v0, $a0, $a1
	jr $ra

difference:
	sub $v0, $a0, $a1
	jr $ra

multiplication:
	mul $v0, $a0, $a1
	jr $ra

division:
	div $v0, $a0, $a1
	jr $ra
