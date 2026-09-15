#sum of 5 + 10 in assembly (MIPS)

.data
x: .word 5
y: .word 10
z: .word 0

.text
.globl main

main:
      lw $t0,x                                            #t0=5
      lw $t1,y                                            #t1=10
      add $t2,$t0,$t1                                     #t2=5+10
      sw $t2,z                                            #z=15

      #printing value of z
      li $v0,1
      lw $a0,z
      syscall

      #exit
      li $v0,10
      syscall
