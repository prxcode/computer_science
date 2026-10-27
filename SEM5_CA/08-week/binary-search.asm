.data
    # A sorted array to search through (each element is a word = 4 bytes)
    array:  .word 11, 22, 33, 44, 55, 66, 77, 88, 99
    length: .word 9             # Number of elements
    target: .word 66            # Element to find (index should be 5)
    result: .word 0             # Stores the returned index
    msg:    .asciiz "Index found at: " # Label text for clarity

.text
.globl main

main:
    la $a0, array               # $a0 = base address of array A
    lw $a1, target              # $a1 = data (value to search)
    li $a2, 0                   # $a2 = lo (starting index 0)
    lw $a3, length              # Get length to calculate hi
    subu $a3, $a3, 1            # $a3 = hi (length - 1)

    # Call recursive binary search
    jal bin_search              # Index returned in $v0

    # Save final result to memory
    sw $v0, result

    # --- NEW CODE TO SHOW OUTPUT ---
    # 1. Print the string label "Index found at: "
    move $t0, $v0               # Temporarily save result ($v0) so it doesn't get overwritten
    li $v0, 4                   # Syscall 4: Print String
    la $a0, msg                 # Load address of msg
    syscall

    # 2. Print the actual result index integer
    li $v0, 1                   # Syscall 1: Print Integer
    move $a0, $t0               # Move the saved index into $a0 for printing
    syscall
    # -------------------------------

    # Exit program
    li $v0, 10
    syscall


# --- Recursive Binary Search Function ---
# Inputs: $a0 = A[], $a1 = data, $a2 = lo, $a3 = hi
# Output: $v0 = mid index (found) or -1 (not found)
bin_search:
    # Base Case 1: if (lo > hi) return -1
    bgt $a2, $a3, not_found

    # Calculate mid = (lo + hi) / 2
    addu $t0, $a2, $a3          # $t0 = lo + hi
    sra $t0, $t0, 1             # $t0 = (lo + hi) / 2  (mid index)

    # Calculate memory address of A[mid]: base + (mid * 4)
    sll $t1, $t0, 2             # $t1 = mid * 4
    addu $t1, $a0, $t1          # $t1 = address of A[mid]
    lw $t2, 0($t1)              # $t2 = A[mid]

    # Case 2: if (data == A[mid]) return mid
    beq $a1, $t2, found_match

    # Stack Setup (Required because we are making a nested/recursive call)
    subu $sp, $sp, 8            # Allocate 8 bytes on stack
    sw $ra, 4($sp)              # Save return address
    sw $t0, 0($sp)              # Save current mid index

    # Case 3: if (data < A[mid]) return bin_search(A, data, lo, mid - 1)
    blt $a1, $t2, search_left

    # Case 4: else (data > A[mid]) return bin_search(A, data, mid + 1, hi)
    # Target is in the right half
    addu $a2, $t0, 1            # lo = mid + 1 ($a3 'hi' stays unchanged)
    jal bin_search
    j restore_stack             # Skip over the left search logic

search_left:
    # Target is in the left half
    subu $a3, $t0, 1            # hi = mid - 1 ($a2 'lo' stays unchanged)
    jal bin_search

restore_stack:
    # Clean up stack and return the value passed up from the recursive chain
    lw $ra, 4($sp)              # Restore return address
    addu $sp, $sp, 8            # Deallocate stack
    jr $ra                      # Return to caller

found_match:
    move $v0, $t0               # Return the mid index
    jr $ra

not_found:
    li $v0, -1                  # Return -1
    jr $ra
