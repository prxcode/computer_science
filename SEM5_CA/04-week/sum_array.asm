#Sum of two Array in MIPS 

.data
A:        .word 10, 20, 30, 40, 50    # Array A
B:        .word  1,  2,  3,  4,  5    # Array B
C:        .word  0,  0,  0,  0,  0    # Array C
EndA:     .word  0                    # Label marking where array A ends

          .text
          .globl main
main:
          # Load starting memory addresses into pointer registers
          la   $t1, A         # $t1 = current pointer for A
          la   $t2, B         # $t2 = current pointer for B
          la   $t3, C         # $t3 = current pointer for C
          la   $t0, EndA      # $t0 = target end address (boundary check)

loop: 
          # Load data values directly from current pointer addresses
          lw   $t4, 0($t1)    # $t4 = value at current address of A
          lw   $t5, 0($t2)    # $t5 = value at current address of B

          # Perform addition and store result
          add  $t4, $t4, $t5  # $t4 = dataA + dataB
          sw   $t4, 0($t3)    # Store result into current address of C

          # Advance all three pointers by 4 bytes (1 word forward)
          addi $t1, $t1, 4    # Move pointer A to next element
          addi $t2, $t2, 4    # Move pointer B to next element
          addi $t3, $t3, 4    # Move pointer C to next element

          # Loop boundary control
          bne  $t1, $t0, loop # If pointer A has not reached EndA, repeat loop

          # Terminate program execution smoothly
          li   $v0, 10        
          syscall
