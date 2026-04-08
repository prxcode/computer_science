.MODEL SMALL
.STACK 100H

.DATA
    msg1    DB 10, 13, 'Enter Matrix 1 (4 elements, 2 hex digits each):', 10, 13, '$'
    msg2    DB 10, 13, 'Enter Matrix 2 (4 elements, 2 hex digits each):', 10, 13, '$'
    msg3    DB 10, 13, 10, 13, 'Resulting Matrix (Sum):', 10, 13, '$'
    space   DB ' $'
    newline DB 10, 13, '$'
    
    mat1    DB 4 DUP(0)
    mat2    DB 4 DUP(0)

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX

    LEA DX, msg1
    MOV AH, 09H
    INT 21H

    LEA SI, mat1
    MOV CX, 4
INPUT_LOOP1:
    CALL READ_HEX
    MOV [SI], AL
    INC SI
    
    LEA DX, space
    MOV AH, 09H
    INT 21H
    LOOP INPUT_LOOP1

    LEA DX, msg2
    MOV AH, 09H
    INT 21H

    LEA SI, mat2
    MOV CX, 4
INPUT_LOOP2:
    CALL READ_HEX
    MOV [SI], AL
    INC SI
    
    LEA DX, space
    MOV AH, 09H
    INT 21H
    LOOP INPUT_LOOP2

    LEA DX, msg3
    MOV AH, 09H
    INT 21H

    LEA SI, mat1
    LEA DI, mat2
    MOV CX, 4
    MOV BL, 0

ADD_LOOP:
    MOV AL, [SI]
    ADD AL, [DI]
    
    CALL PRINT_HEX

    LEA DX, space
    MOV AH, 09H
    INT 21H

    INC SI
    INC DI

    INC BL
    CMP BL, 2
    JNE CONTINUE_LOOP
    
    LEA DX, newline
    MOV AH, 09H
    INT 21H
    MOV BL, 0

CONTINUE_LOOP:
    DEC CX
    JNZ ADD_LOOP

    MOV AH, 4CH
    INT 21H
MAIN ENDP

READ_HEX PROC
    MOV AH, 01H
    INT 21H
    CALL ASCII_TO_HEX
    SHL AL, 4
    MOV BH, AL

    MOV AH, 01H
    INT 21H
    CALL ASCII_TO_HEX
    ADD AL, BH
    RET
READ_HEX ENDP

ASCII_TO_HEX PROC
    CMP AL, 'a'
    JB  CHECK_DIGIT
    SUB AL, 20H
    
CHECK_DIGIT:
    CMP AL, '9'
    JBE IS_DIGIT
    SUB AL, 37H
    JMP DONE_ASCII_CONV
    
IS_DIGIT:
    SUB AL, 30H
    
DONE_ASCII_CONV:
    RET
ASCII_TO_HEX ENDP

PRINT_HEX PROC
    MOV BH, AL
    
    SHR AL, 4
    CALL HEX_TO_ASCII
    MOV DL, AL
    MOV AH, 02H
    INT 21H

    MOV AL, BH
    AND AL, 0FH
    CALL HEX_TO_ASCII
    MOV DL, AL
    MOV AH, 02H
    INT 21H
    RET
PRINT_HEX ENDP

HEX_TO_ASCII PROC
    CMP AL, 09H
    JBE IS_HEX_DIGIT
    ADD AL, 37H
    JMP DONE_HEX_CONV
    
IS_HEX_DIGIT:
    ADD AL, 30H
    
DONE_HEX_CONV:
    RET
HEX_TO_ASCII ENDP

END MAIN