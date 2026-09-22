# finding largest in assembly in MIPS


.data
A: .word 10, 25, 7, 42, 18, 33, 56, 12, 9, 30

.text
.globl main
main:
    la   $t0, A
    lw   $t1, 0($t0)
    li   $t2, 1

loop:
    lw   $t3, 0($t0)
    ble  $t2, 9, check
    j    print

check:
    ble  $t3, $t1, next
    move $t1, $t3

next:
    addi $t0, $t0, 4
    addi $t2, $t2, 1
    ble  $t2, 9, loop

print:
    move $a0, $t1
    li   $v0, 1
    syscall

    li   $v0, 10
    syscall
