#factorial of N numbers in assembly (MIPS)

.data
msg1: .asciiz "Enter N: "
msg2: .asciiz "\n The factorial of N: "
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

      #t0 =1, t1=1, t2=N
      li $t0,1
      li $t1,1
      lw $t2,no
      
next:
      bgt $t1,$t2,over                    #t1>t2 then jump to over
      mul $t0,$t0,$t1                     #t0 = t0*t1
      addi $t1,$t1,1                      #t1=t1+1
      j next                              #jump to next ie loop
      
over:
      sw $t0,sum                          #sum = t0
      
      #print msg2
      li $v0,4
      la $a0,msg2
      syscall

      #print value for final sum
      li $v0,1
      lw $a0,sum
      syscall

      #exit
      li $v0,10
      syscall
