#to find the largest element in an array using MIPS

.data
array: .word 10, 20, 30, 40, 50, 60, 70, 80, 90, 10
size: .word 10
msg: .asciiz "The largest is: "

.text
.globl main

main:
    la $t0, array
    lw $t1, size
    lw $t2, 0($t0)

    addi $t0, $t0, 4
    addi $t1, $t1, -1

loop:
    blez $t1, end
    lw $t3, 0($t0)
    ble $t3, $t2, skip
    move $t2, $t3

skip:
    addi $t0, $t0, 4
    addi $t1, $t1, -1
    j loop

end:
    li $v0, 4
    la $a0, msg
    syscall

    li $v0, 1
    move $a0, $t2
    syscall

    li $v0, 10
    syscall
