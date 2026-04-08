.MODEL SMALL
.STACK 100H
.DATA
    ARRAY    DB 10 DUP(?)
    MAX_VAL  DB -128    ; Start at lowest signed value
    MIN_VAL  DB 127     ; Start at highest signed value
    MAX_POS  DB ?
    MIN_POS  DB ?
    PROMPT   DB 0DH, 0AH, 'Enter 10 signed numbers (-99 to 99): $'
    MAX_MSG  DB 0DH, 0AH, 0DH, 0AH, 'Largest: $'
    MIN_MSG  DB 0DH, 0AH, 'Smallest: $'
    POS_MSG  DB ' at position: $'

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX
    LEA DX, PROMPT
    MOV AH, 09H
    INT 21H
    MOV CX, 10
    MOV SI, 0
READ_LOOP:
    CALL READ_SIGNED_BYTE
    MOV ARRAY[SI], AL
    INC SI
    LOOP READ_LOOP
    MOV CX, 10
    MOV SI, 0
FIND_LOOP:
    MOV AL, ARRAY[SI]
    CMP AL, MAX_VAL ; Signed comparison
    JLE CHECK_MIN
    MOV MAX_VAL, AL
    MOV AX, SI
    INC AL ; Convert to 1-based position
    MOV MAX_POS, AL
CHECK_MIN:
    MOV AL, ARRAY[SI]
    CMP AL, MIN_VAL ; Signed comparison
    JGE NEXT_ITER
    MOV MIN_VAL, AL
    MOV AX, SI
    INC AL ; Convert to 1-based position
    MOV MIN_POS, AL
NEXT_ITER:
    INC SI
    LOOP FIND_LOOP
    LEA DX, MAX_MSG
    MOV AH, 09H
    INT 21H
    MOV AL, MAX_VAL
    CALL PRINT_SIGNED_BYTE
    LEA DX, POS_MSG
    MOV AH, 09H
    INT 21H
    MOV AL, MAX_POS
    CALL PRINT_UNSIGNED_BYTE
    LEA DX, MIN_MSG
    MOV AH, 09H
    INT 21H
    MOV AL, MIN_VAL
    CALL PRINT_SIGNED_BYTE
    LEA DX, POS_MSG
    MOV AH, 09H
    INT 21H
    MOV AL, MIN_POS
    CALL PRINT_UNSIGNED_BYTE
    MOV AH, 4CH
    INT 21H
MAIN ENDP

READ_SIGNED_BYTE PROC
    PUSH BX
    MOV BL, 0 ; 0 = Positive, 1 = Negative
SKIP_GARBAGE:
    MOV AH, 01H
    INT 21H
    CMP AL, '-'
    JE IS_NEGATIVE
    CMP AL, '0'
    JB SKIP_GARBAGE ; Ignore spaces, commas, enters
    CMP AL, '9'
    JA SKIP_GARBAGE ; Ignore other symbols
    JMP CALC_TENS   ; If it makes it here, it's a valid digit
IS_NEGATIVE:
    MOV BL, 1       ; Flag as negative
    MOV AH, 01H     ; Read the actual first digit
    INT 21H
CALC_TENS:
    SUB AL, '0'
    MOV CL, 10
    MUL CL
    MOV CH, AL      ; Store tens
    MOV AH, 01H     ; Read second digit
    INT 21H
    SUB AL, '0'
    ADD AL, CH      ; Combine tens and units
    CMP BL, 1
    JNE DONE_READ
    NEG AL          ; Two's complement for negative
DONE_READ:
    POP BX
    RET
READ_SIGNED_BYTE ENDP

PRINT_SIGNED_BYTE PROC
    CMP AL, 0
    JGE POSITIVE
    PUSH AX
    MOV DL, '-'
    MOV AH, 02H
    INT 21H
    POP AX
    NEG AL
POSITIVE:
    CALL PRINT_UNSIGNED_BYTE
    RET
PRINT_SIGNED_BYTE ENDP

PRINT_UNSIGNED_BYTE PROC
    AAM ; Split AL into Tens (AH) and Units (AL)
    ADD AX, 3030H
    MOV DX, AX
    PUSH DX
    MOV DL, DH
    MOV AH, 02H
    INT 21H
    POP DX
    MOV AH, 02H
    INT 21H
    RET
PRINT_UNSIGNED_BYTE ENDP
END MAIN