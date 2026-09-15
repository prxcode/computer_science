# check for prime or not in assembly (MIPS)

.data
msg: .asciiz "Enter a number: "
primeMsg: .asciiz "The number is prime!"
notPrimeMsg: .asciiz "The number is not prime!"

.text
.globl main

main:

	li $v0, 4
	la $a0, msg
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0
	
	li $t1, 2
	
loop:
	beq $t1, $t0, prime
	
	div $t0, $t1
	
	mfhi $t2
	
	beq $t2, $zero, notprime
	
	addi $t1, $t1, 1
	
	j loop
	
prime: 
	li $v0, 4
	la $a0, primeMsg
	syscall
	
notprime: 
	li $v0, 4
	la $a0, notPrimeMsg
	syscall
	
	
	li $v0,10
	syscall
	
