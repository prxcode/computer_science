.data
    n:      .word 5         # Input value 'n' (e.g., 5 means 5+4+3+2+1)
    sum:    .word 0         # Variable to store final answer (Sum of 5 = 15)
    msg:    .asciiz "The sum is: " # Label text for visual confirmation

.text
.globl main

main:
    # Load argument from memory
    lw $a0, n               # $a0 = n

    # Call the recursive function
    jal RSum                # Result returns in $v0

    # Save the final result into memory
    sw $v0, sum

    # --- NEW CODE TO SHOW OUTPUT ---
    # 1. Print the string label "The sum is: "
    move $t0, $v0           # Temporarily save result ($v0) so it doesn't get overwritten
    li $v0, 4               # Syscall 4: Print String
    la $a0, msg             # Load address of msg
    syscall

    # 2. Print the actual result sum integer
    li $v0, 1               # Syscall 1: Print Integer
    move $a0, $t0           # Move the saved sum into $a0 for printing
    syscall
    # -------------------------------

    # Exit program (syscall 10)
    li $v0, 10
    syscall

# --- Recursive Sum Function ---
# Input:  $a0 = n
# Output: $v0 = result
RSum:
    # Base Case: if (n == 1) return n (which is 1)
    li $t0, 1
    beq $a0, $t0, base_case

    # Recursive Step:
    # Allocate stack frame to preserve values across the nested call
    subu $sp, $sp, 8
    sw $ra, 4($sp)          # Save return address
    sw $a0, 0($sp)          # Save current 'n'

    # Prepare argument for next call: RSum(n - 1)
    subu $a0, $a0, 1        # n = n - 1
    jal RSum                # Recursive call: $v0 = RSum(n - 1)

    # Restore registers from stack
    lw $a0, 0($sp)          # Restore 'n'
    lw $ra, 4($sp)          # Restore return address
    addu $sp, $sp, 8        # Deallocate stack frame

    # Add current 'n' to the result returned by the recursive call
    addu $v0, $a0, $v0      # $v0 = n + RSum(n - 1)
    jr $ra                  # Return to caller

base_case:
    move $v0, $a0           # If n == 1, return 1
    jr $ra                  # Return to caller
