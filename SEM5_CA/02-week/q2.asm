#sum of N integer in assembly (MIPS) Example: If N = 52, then 5 + 2 = 7, so the program should print 7

.data
msg1: .asciiz "Enter an integer N: "
result: .asciiz "The sum of digits is: "

.text
.globl main

main:
      #printing msg1
      li $v0,4
      la $a0,msg1
      syscall

      #taking input as int
      li $v0,5
      syscall

      #t0=N
      move $t0,$v0

      #t1=0
      li $t1,0
      
      loop:
      beqz $t0,loopend            #if t0 == 0 then loopend

      #t2=10, do t0/t2
      li $t2,10
      div $t0,$t2
      
      mflo $t0                    #quotient of it is t0
      mfhi $t3                    #reminder of it is t3
      
      add $t1,$t1,$t3             #t1=t1+t3
      
      j loop                      #jump to loop

      #print result 
      loopend:
      li $v0,4
      la $a0,result
      syscall

      #print result value as int
      li $v0,1
      move $a0,$t1
      syscall

      #exit
      li $v0,10
      syscall
