.data
    base:   .word 3         # Input base 'a'
    exp:    .word 4         # Input exponent 'n'
    result: .word 0         # Variable to store final answer (3^4 = 81)
    msg:    .asciiz "The result is: " # Label text for visual confirmation

.text
.globl main

main:
    # Load arguments from memory
    lw $a0, base            # $a0 = base 'a'
    lw $a1, exp             # $a1 = exponent 'n'

    # Call the recursive power function
    jal power               # Result will return in $v0

    # Save the result into memory
    sw $v0, result

    # --- NEW CODE TO SHOW OUTPUT ---
    # 1. Print the string label "The result is: "
    move $t0, $v0           # Temporarily save result ($v0) so it doesn't get overwritten
    li $v0, 4               # Syscall 4: Print String
    la $a0, msg             # Load address of msg
    syscall

    # 2. Print the actual result exponent integer
    li $v0, 1               # Syscall 1: Print Integer
    move $a0, $t0           # Move the saved result into $a0 for printing
    syscall
    # -------------------------------

    # Exit program (syscall 10)
    li $v0, 10
    syscall

# Recursive Power Function
# Inputs:  $a0 = base (a), $a1 = exponent (n)
# Outputs: $v0 = result
power:
    # Base Case: if (n == 1), return a
    li $t0, 1
    beq $a1, $t0, base_case

    # Recursive Step:
    # Allocate stack frame to save return address ($ra) and current exponent ($a1)
    subu $sp, $sp, 8
    sw $ra, 4($sp)          # Save return address
    sw $a1, 0($sp)          # Save current exponent 'n'

    # Prepare arguments for next recursive call: power(a, n - 1)
    subu $a1, $a1, 1        # n = n - 1 ($a0 base remains unchanged)
    jal power               # Recursive call: $v0 = power(a, n - 1)

    # Restore registers from stack
    lw $a1, 0($sp)          # Restore 'n'
    lw $ra, 4($sp)          # Restore return address
    addu $sp, $sp, 8        # Deallocate stack frame

    # Multiply current base by the returned recursive result: a * power(a, n - 1)
    mul $v0, $a0, $v0       # $v0 = base * result_of_recursive_call
    jr $ra                  # Return to caller

base_case:
    move $v0, $a0           # If n == 1, return base 'a'
    jr $ra                  # Return to caller
