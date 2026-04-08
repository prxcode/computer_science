.MODEL SMALL
.STACK 100H

.DATA
    ; Prompts
    M1 DB 0DH,0AH,'Enter A11 (HEX): $'
    M2 DB 0DH,0AH,'Enter A12 (HEX): $'
    M3 DB 0DH,0AH,'Enter A21 (HEX): $'
    M4 DB 0DH,0AH,'Enter A22 (HEX): $'
    
    ; Output formatting
    RES_MSG DB 0DH,0AH,0DH,0AH,'Resulting 2x2 Matrix:',0DH,0AH,'$'
    SPACE   DB '    $',   ; Large space between columns
    NEWLINE DB 0DH,0AH,'$'

    ; Storage for the 4 squared results (each result fits in 1 byte)
    MAT DB 4 DUP(0)
    
    ; Array of offsets for the input loop
    IN_MSGS DW OFFSET M1, OFFSET M2, OFFSET M3, OFFSET M4

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX

    ; --- PART 1: INPUT AND CALCULATION ---
    MOV CX, 4       ; 4 elements total
    MOV SI, 0       ; Index for prompts
    MOV DI, 0       ; Index for MAT array
    
INPUT_LOOP:
    ; Display input prompt
    MOV DX, IN_MSGS[SI]
    MOV AH, 09H
    INT 21H

    CALL ENTER_VAL  ; Get hex input in AL
    
    ; Square the value (Result in AL, max is 0E1H for 0FH^2)
    MOV BL, AL
    MUL BL          
    
    ; Store result in our matrix array
    MOV MAT[DI], AL

    ADD SI, 2       ; Next prompt (DW = 2 bytes)
    INC DI          ; Next storage slot (DB = 1 byte)
    LOOP INPUT_LOOP

    ; --- PART 2: DISPLAY AS A 2x2 MATRIX ---
    LEA DX, RES_MSG
    MOV AH, 09H
    INT 21H

    ; Row 1
    MOV AL, MAT[0]
    CALL DISP_HEX_BYTE
    LEA DX, SPACE
    INT 21H
    MOV AL, MAT[1]
    CALL DISP_HEX_BYTE

    ; New line
    LEA DX, NEWLINE
    MOV AH, 09H
    INT 21H

    ; Row 2
    MOV AL, MAT[2]
    CALL DISP_HEX_BYTE
    LEA DX, SPACE
    INT 21H
    MOV AL, MAT[3]
    CALL DISP_HEX_BYTE

    ; Exit
    MOV AH, 4CH
    INT 21H
MAIN ENDP

; --- SUBROUTINES ---

ENTER_VAL PROC
    MOV AH, 01H
    INT 21H
    CMP AL, '9'
    JBE IS_NUM
    SUB AL, 07H     ; Handle A-F
IS_NUM:
    SUB AL, 30H     ; Convert ASCII to numeric
    RET
ENTER_VAL ENDP

DISP_HEX_BYTE PROC
    PUSH AX         ; Save value
    MOV BL, AL      ; Copy for nibble processing
    
    ; High Nibble
    AND AL, 0F0H
    MOV CL, 4
    SHR AL, CL
    CALL DISP_DIGIT

    ; Low Nibble
    MOV AL, BL
    AND AL, 0FH
    CALL DISP_DIGIT
    
    POP AX
    RET
DISP_HEX_BYTE ENDP

DISP_DIGIT PROC
    CMP AL, 09
    JBE IS_DIG
    ADD AL, 07H
IS_DIG:
    ADD AL, 30H
    MOV DL, AL
    MOV AH, 02H
    INT 21H
    RET
DISP_DIGIT ENDP

END MAIN