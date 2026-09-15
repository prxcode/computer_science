# odd or even check in assembly (MIPS)

.data
msg1: .asciiz "Enter the no:"
msgo: .asciiz "The no is odd\n"
msge: .asciiz "The no is even\n"
num: .word 0

.text
.globl main

main:
      #printing msg1 ie asking for num
      li $v0,4
      la $a0,msg1
      syscall

      #taking input as int
      li $v0,5
      syscall

      #t0=num, t1=2
      move $t0,$v0
      li $t1,2
      div $t0,$t1                        #t0/t1
      
      mfhi $t0                            #t0=reminder
      beq $t0,$zero,even_no               #t0=0 then jump to even_no
      la $a0,msgo                          #if condition is false its odd so printing num is odd
      j print_msg

      #printing num is even
      even_no:
      la $a0,msge

      print_msg:
      li $v0,4
      syscall

      #exit
      li $v0,10
      syscall
      
      .end main
