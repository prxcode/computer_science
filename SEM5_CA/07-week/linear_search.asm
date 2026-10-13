#Linear search in MIPS

.data
    array:      .word 12, 45, 7, 23, 9, 56, 31, 88
    size:       .word 8
    prompt:     .asciiz "Enter the element to search for: "
    msg_found:  .asciiz "Element found at index: "
    msg_not:    .asciiz "0 (element not found)\n"
    newline:    .asciiz "\n"

.text
.globl main

main:
    li $v0, 4
    la $a0, prompt
    syscall

    li $v0, 5
    syscall
    move $s2, $v0        # Store the search element

    la $a0, array        # Pass array address
    lw $a1, size         # Pass array size
    move $a2, $s2        # Pass search element

    jal linear_search
    move $s0, $v0        # Store search status
    move $s1, $v1        # Store found index

    beq $s0, $zero, not_found

    li $v0, 4
    la $a0, msg_found
    syscall

    li $v0, 1
    move $a0, $s1
    syscall

    li $v0, 4
    la $a0, newline
    syscall
    j exit

not_found:
    li $v0, 4
    la $a0, msg_not
    syscall

exit:
    li $v0, 10
    syscall

# Linear search: returns status in $v0 and index in $v1
linear_search:
    li $t0, 0            # Initialize index to zero

loop:
    bge $t0, $a1, element_not_found

    sll $t1, $t0, 2      # Calculate byte offset
    add $t2, $a0, $t1
    lw $t3, 0($t2)       # Load current array element

    beq $t3, $a2, element_found

    addi $t0, $t0, 1     # Advance to next element
    j loop

element_found:
    li $v0, 1            # Indicate element found
    move $v1, $t0        # Return matching index
    jr $ra

element_not_found:
    li $v0, 0            # Indicate element not found
    li $v1, -1
    jr $ra
