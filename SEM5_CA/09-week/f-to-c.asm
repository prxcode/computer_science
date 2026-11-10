.data
prompt: .asciiz "Enter temp in F: "
result: .asciiz "Temperature in C: "
val32: .double 32.0
val5: .double 5.0
val9: .double 9.0

.text
.globl main
main:
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 7
	syscall
	
	l.d $f2, val32
	l.d $f4, val5
	l.d $f6, val9
	
	#calculate (f-32)
	sub.d $f0, $f0, $f2
	
	#calculate (5/9)
	div.d $f4, $f4, $f6
	
	#calculate (c=(5/9)*(f-32))
	mul.d $f12, $f4, $f0
	
	li $v0, 4
	la $a0, result
	syscall
	
	li $v0, 3
	syscall
	
	li $v0, 10
	syscall
	 
