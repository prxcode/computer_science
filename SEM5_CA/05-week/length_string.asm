#counting length of string in MIPS

.data
str: .asciiz "Computer"

.text
.globl main

main:
    la $t0, str
    li $t1, 0

loop:
    lb $t2, 0($t0)
    beq $t2, $zero, display
    addi $t1, $t1, 1
    addi $t0, $t0, 1
    j loop

display:
    li $v0, 1
    move $a0, $t1
    syscall

    li $v0, 10
    syscall
