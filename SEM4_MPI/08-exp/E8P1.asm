.MODEL SMALL
.STACK 100H

.DATA
    MSG1 DB 'Enter N (1-7): $'
    MSG2 DB 0DH, 0AH, 'Fibonacci Sequence: ', '$'

.CODE
MAIN PROC
    ; Initialize Data Segment
    MOV AX, @DATA
    MOV DS, AX

    ; Display input message
    LEA DX, MSG1
    MOV AH, 09H
    INT 21H

    ; Read N from user
    MOV AH, 01H
    INT 21H
    SUB AL, 30H       ; Convert ASCII character to numeric value
    MOV CL, AL        ; Store N in CL for the loop counter

    ; Display heading
    LEA DX, MSG2
    MOV AH, 09H
    INT 21H

    ; Initialize Fibonacci terms
    MOV BH, 00H       ; First term (n-2)
    MOV BL, 01H       ; Second term (n-1)

PRINT_LOOP:
    ; 1. Display current term (stored in BH)
    MOV DL, BH
    ADD DL, 30H       ; Convert numeric value back to ASCII
    MOV AH, 02H
    INT 21H

    ; 2. Print a space (Fix: Added space between quotes)
    MOV DL, ' '       
    MOV AH, 02H
    INT 21H

    ; 3. Generate next term
    MOV AL, BH        ; AL = current (n-2)
    ADD AL, BL        ; AL = (n-2) + (n-1) -> Next term
    MOV BH, BL        ; Shift: current becomes the old next
    MOV BL, AL        ; Shift: next becomes the newly calculated sum

    ; 4. Loop control
    DEC CL
    JNZ PRINT_LOOP

    ; Exit Program
    MOV AH, 4CH
    INT 21H
MAIN ENDP
END MAIN
