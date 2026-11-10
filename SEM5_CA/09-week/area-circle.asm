.data
prompt:.asciiz "Enter the radius of circle: "
result: .asciiz "The area of circle is: "
pi: .double 3.1415926535897924


.text
.globl main
main:
	li $v0, 4
	la $a0, prompt
	syscall
	
	#read r into $f0
	li $v0, 7
	syscall
	
	#load pi into $f2
	l.d $f2, pi
	
	#calculate r^2 ($f4 = r * r)
	mul.d $f4, $f0, $f0
	
	#calculate area = pi*r^2 ($f12 = pi * r^2)
	mul.d $f12, $f4, $f2
	
	li $v0, 4
	la $a0, result
	syscall
	
	
	li $v0, 3
	syscall
	
	li $v0, 10
	syscall
