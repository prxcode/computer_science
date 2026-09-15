# sum of first N numbers in assembly (MIPS)

.data
msg1: .asciiz "Enter N: "
msg2: .asciiz "\n The result of the sum of first N: "
no: .word 0
sum: .word 0
crlf: .byte 0xd,0xa,0

.text
.globl main

main:
      #printing msg1
      li $v0,4
      la $a0,msg1
      syscall

      #taking input for N
      li $v0,5
      syscall
      sw $v0,no

      #t0=0, t1=1 and t2=N
      li $t0,0
      li $t1,1
      lw $t2,no
      
      next:
      
      bgt $t1,$t2,over                    #branch greater than ie t1>t2 go to over 
      add $t0,$t0,$t1                     #t0=t0+t1
      addi $t1,$t1,1                      #t1=t1+1
      j next
      
      over:
      sw $t0,sum                          #sum = t0
      li $v0,4
      la $a0,msg2                         #print msg2
      syscall
      
      li $v0,1
      lw $a0,sum                          #print sum value 
      syscall

      #exit
      li $v0,10
      syscall
