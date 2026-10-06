#concatenation of two strings in MIPS

.data
str1: .asciiz "Hello"
str2: .asciiz "World"
result: .space 100

.text
.globl main

main:
    la $t0, str1
    la $t1, result

copy1:
    lb $t2, 0($t0)
    beq $t2, $zero, copy2
    sb $t2, 0($t1)
    addi $t0, $t0, 1
    addi $t1, $t1, 1
    j copy1

copy2:
    la $t0, str2

loop:
    lb $t2, 0($t0)
    beq $t2, $zero, finish
    sb $t2, 0($t1)
    addi $t0, $t0, 1
    addi $t1, $t1, 1
    j loop

finish:
    sb $zero, 0($t1)

    li $v0, 4
    la $a0, result
    syscall

    li $v0, 10
    syscall
