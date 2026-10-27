
.data
    n:      .word 5         # Input value 'n' (e.g., 5 means 5+4+3+2+1)
    sum:    .word 0         # Variable to store final answer (Sum of 5 = 15)

.text
.globl main

main:
    # Load argument from memory
    lw $a0, n               # $a0 = n

    # Call the recursive function
    jal RSum                # Result returns in $v0

    # Save the final result into memory
    sw $v0, sum

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
