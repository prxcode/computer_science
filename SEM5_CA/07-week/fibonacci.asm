.data
prompt: .asciiz "Enter n: "
result: .asciiz "Fibonacci number: "

.text
.globl main

main:
    # Print prompt
    li $v0, 4
    la $a0, prompt
    syscall

    # Read n
    li $v0, 5
    syscall
    move $a0, $v0

    # Call Fibonacci procedure
    jal fib

    # Print result
    move $t0, $v0

    li $v0, 4
    la $a0, result
    syscall

    move $a0, $t0
    li $v0, 1
    syscall

    # Exit
    li $v0, 10
    syscall


# Procedure: fib(n)
# Input:  $a0 = n
# Output: $v0 = fib(n)

fib:
    li $t0, 0          # a = 0
    li $t1, 1          # b = 1

    beq $a0, $zero, fib_zero

    li $t2, 1
    beq $a0, $t2, fib_one

    li $t3, 2          # i = 2

loop:
    bgt $t3, $a0, done

    add $t4, $t0, $t1  # c = a + b
    move $t0, $t1      # a = b
    move $t1, $t4      # b = c

    addi $t3, $t3, 1   # i++
    j loop

fib_zero:
    move $v0, $zero
    jr $ra

fib_one:
    li $v0, 1
    jr $ra

done:
    move $v0, $t1
    jr $ra
