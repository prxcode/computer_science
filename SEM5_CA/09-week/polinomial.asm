.data
prompt: .asciiz "Enter value of x: "
result: .asciiz "Ouput is: "

.text
.globl main
main:

	li.d $f2, 2.0
	li.d $f4, 3.0
	li.d $f6, 4.0
	
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 7
	syscall
	
	
	#f10=x*x
	mul.d $f10, $f0, $f0
	
	#f10=a*x^2
	mul.d $f10, $f2, $f10
	
	#f8 =b*x
	mul.d $f8, $f4, $f0
	
	#f10= ax^2 + bx
	add.d $f10, $f10, $f8
	
	#f12= ax^2 + bx + c
	add.d $f12, $f10, $f6
	
	
	li $v0, 4
	la $a0, result
	syscall
	
	li $v0, 3
	syscall
	
	li $v0, 10
	syscall
