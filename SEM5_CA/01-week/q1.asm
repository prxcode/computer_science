# sum of two numbers in assembly (MIPS)

.data
msg1: .asciiz "Enter the first number: "
msg2: .asciiz "\n Enter the second number: "
result: .asciiz "\n The result of addition is: "

.text
.globl main
main:
      #printing msg1
      li $v0,4
      la $a0,msg1
      syscall

      #taking input for first num
      li $v0,5
      syscall
      move $t0,$v0

      #printing msg2
      li $v0,4
      la $a0,msg2
      syscall

      #taking input for second num
      li $v0,5
      syscall
      move $t1,$v0

      # adding two num t2= t1+t0
      add $t2,$t1,$t0

      #printing result message
      li $v0,4
      la $a0,result
      syscall

      # printing int value of result
      li $v0,1
      move $a0,$t2
      syscall

      #exit
      li $v0,10
      syscall
      .end main
