.MODEL SMALL
.STACK 100H

.DATA
PRINT MACRO MSG
    MOV AH, 09H
    LEA DX, MSG
    INT 21H
ENDM

    MSG1 DB 0DH, 0AH, 'Enter new date (DD-MM-YY): $'
    MSG2 DB 0DH, 0AH, 'System date set successfully $'
    MSG3 DB 0DH, 0AH, 'Invalid date entered $'
    BUFFER DB 10, 0, 10 DUP('$')

.CODE
START:
    MOV AX, @DATA
    MOV DS, AX
    MOV ES, AX
    
    PRINT MSG1
    
    MOV AH, 0AH
    LEA DX, BUFFER
    INT 21H
    
    LEA SI, BUFFER+2

    ; 1. Get DAY
    CALL READ_NUMBER
    PUSH DX              ; Push Day to stack

    ; 2. Get MONTH
    CALL READ_NUMBER
    PUSH DX              ; Push Month to stack

    ; 3. Get YEAR and convert to 20xx
    CALL READ_NUMBER     
    MOV AL, DL
    MOV AH, 0
    ADD AX, 2000         ; Converts '26' to '2026'
    MOV CX, AX           ; CX gets the full Year
    
    ; 4. Retrieve Month and Day safely
    POP AX               ; Pops Month into AX (AL = Month)
    MOV DH, AL           ; Safely set DH to Month
    
    POP AX               ; Pops Day into AX (AL = Day)
    MOV DL, AL           ; Safely set DL to Day
    
    ; 5. Set Date
    MOV AH, 2BH          
    INT 21H
    
    CMP AL, 00H          
    JE SUCCESS
    PRINT MSG3
    JMP EXIT

SUCCESS:
    PRINT MSG2

EXIT:
    MOV AH, 4CH
    INT 21H

READ_NUMBER PROC
    XOR DX, DX
    MOV BL, 10
NEXT_DIGIT:
    MOV AL, [SI]
    INC SI
    CMP AL, 0DH          
    JE DONE
    CMP AL, '-'          
    JE DONE
    SUB AL, '0'
    MOV CL, AL
    MOV AL, DL
    MUL BL               
    ADD AL, CL
    MOV DL, AL
    JMP NEXT_DIGIT
DONE:
    RET
READ_NUMBER ENDP

END START
