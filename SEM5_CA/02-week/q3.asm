# MIPS ALP to solve (a = a * b / c % d + e) and print final a value

.data
    prompt_a: .asciiz "Enter value for a: "
    prompt_b: .asciiz "Enter value for b: "
    prompt_c: .asciiz "Enter value for c: "
    prompt_d: .asciiz "Enter value for d: "
    prompt_e: .asciiz "Enter value for e: "
    res_msg:  .asciiz "The result x is: "
 
.text
.globl main
main:
 
    # Read a
    li $v0, 4
    la $a0, prompt_a
    syscall
    li $v0, 5
    syscall
    move $t0, $v0        						# $t0 = a
 
    # Read b
    li $v0, 4
    la $a0, prompt_b
    syscall
    li $v0, 5
    syscall
    move $t1, $v0        						# $t1 = b
 
    # Read c
    li $v0, 4
    la $a0, prompt_c
    syscall
    li $v0, 5
    syscall
    move $t2, $v0        						# $t2 = c
 
    # Read d
    li $v0, 4
    la $a0, prompt_d
    syscall
    li $v0, 5
    syscall
    move $t3, $v0        						# $t3 = d
 
 		# Read e
    li $v0, 4
    la $a0, prompt_e
    syscall
    li $v0, 5
    syscall
    move $t4, $v0        						# $t4 = e
 



    # Expression Evaluation (x = a * b / c % d + e)
 
    mul $t0, $t0, $t1
    div $t0, $t0, $t2
    div $t0, $t0, $t3
    mfhi $t0 
    add $t0, $t0, $t4
    
 
    # print result message
    li $v0, 4
    la $a0, res_msg
    syscall
 
    # print final calculated value of x
    li $v0, 1
    move $a0, $t0
    syscall
 
    # exit
    li $v0,10
    syscall
