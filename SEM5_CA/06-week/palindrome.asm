#MIPS program to check palindrome for a string 

.data
string: .asciiz "Samwin"
msg1:   .asciiz "\nIts a palindrome"
msg2:   .asciiz "\nIts not a palindrome"
rev:    .space 100

.text
.globl main

main:
    la $t0, string
    la $t1, rev
    move $t2, $t0

find_end:
    lb $t3, 0($t2)
    beq $t3, $zero, copy_reverse
    addi $t2, $t2, 1
    j find_end

copy_reverse:
    addi $t2, $t2, -1

reverse_loop:
    blt $t2, $t0, palindrome

    lb $t3, 0($t2)
    sb $t3, 0($t1)

    lb $t4, 0($t0)
    bne $t3, $t4, not_palindrome

    addi $t0, $t0, 1
    addi $t1, $t1, 1
    addi $t2, $t2, -1
    j reverse_loop

palindrome:
    sb $zero, 0($t1)

    li $v0, 4
    la $a0, rev
    syscall

    li $v0, 4
    la $a0, msg1
    syscall

    j exit

not_palindrome:
    sb $zero, 0($t1)

    li $v0, 4
    la $a0, rev
    syscall

    li $v0, 4
    la $a0, msg2
    syscall

exit:
    li $v0, 10
    syscall
