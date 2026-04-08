.MODEL SMALL
.STACK 100H

.DATA
    ARRAY DB 10 DUP(?)
    POS   DB 10 DUP(?)
    N     DB ?
    MSG1  DB 0DH, 0AH, 'Enter ten 2-digit numbers (e.g. 05, 12, 99): $'
    MSG2  DB 0DH, 0AH, 'Enter N (1-9): $'
    MSG3  DB 0DH, 0AH, 'Nth largest: $'
    MSG4  DB ' at original position: $'

.CODE
START:
    MOV AX, @DATA
    MOV DS, AX

    ; --- PART 1: READ 10 NUMBERS ---
    LEA DX, MSG1
    MOV AH, 09H
    INT 21H
    
    MOV CX, 10
    MOV SI, 0

READ_LOOP:
    ; Read 1st digit (Tens place)
    MOV AH, 01H
FIND_1ST:
    INT 21H
    CMP AL, '0'
    JB FIND_1ST    ; Skip any non-numeric characters (like spaces)
    CMP AL, '9'
    JA FIND_1ST
    
    SUB AL, '0'
    MOV BL, 10
    MUL BL          ; AL = AL * 10
    MOV BH, AL      ; Temporarily store tens in BH

    ; Read 2nd digit (Units place)
    MOV AH, 01H
    INT 21H
    SUB AL, '0'
    ADD AL, BH      ; AL = (Tens * 10) + Units
    
    MOV ARRAY[SI], AL
    MOV POS[SI], AL ; This is just a placeholder, we will overwrite with index
    
    ; Store original 0-indexed position (0-9)
    MOV AX, SI
    MOV POS[SI], AL 
    
    INC SI
    LOOP READ_LOOP

    ; --- PART 2: READ N ---
    LEA DX, MSG2
    MOV AH, 09H
    INT 21H
GET_N:
    MOV AH, 01H
    INT 21H
    CMP AL, '1'
    JB GET_N
    CMP AL, '9'
    JA GET_N
    SUB AL, '0'
    MOV N, AL

    ; --- PART 3: BUBBLE SORT (DESCENDING) ---
    ; To find the Nth largest, we sort from Highest to Lowest.
    MOV CX, 10
OUTER:
    PUSH CX
    MOV CX, 9
    MOV SI, 0
INNER:
    MOV AL, ARRAY[SI]
    CMP AL, ARRAY[SI+1]
    JAE SKIP_SWAP      ; If Current >= Next, they are in order (Descending)
    
    ; Swap Values in ARRAY
    XCHG AL, ARRAY[SI+1]
    MOV ARRAY[SI], AL
    
    ; Swap corresponding Values in POS array to track the number
    MOV AL, POS[SI]
    XCHG AL, POS[SI+1]
    MOV POS[SI], AL

SKIP_SWAP:
    INC SI
    LOOP INNER
    POP CX
    LOOP OUTER

    ; --- PART 4: OUTPUT RESULT ---
    LEA DX, MSG3
    MOV AH, 09H
    INT 21H

    ; Access Nth element (Index = N-1)
    XOR BX, BX
    MOV BL, N
    DEC BL

    ; Display the Nth Largest Number
    MOV AL, ARRAY[BX]
    AAM                 ; AH = Tens, AL = Units
    ADD AX, 3030H
    MOV DX, AX
    PUSH DX
    MOV DL, DH          ; Display Tens
    MOV AH, 02H
    INT 21H
    POP DX
    MOV AH, 02H         ; Display Units
    INT 21H

    ; Display "at original position"
    LEA DX, MSG4
    MOV AH, 09H
    INT 21H

    ; Display Position (Converted to 1-based for the user)
    MOV AL, POS[BX]
    INC AL              ; Change 0-9 to 1-10
    AAM
    ADD AX, 3030H
    MOV DX, AX
    
    ; Skip leading zero for position if it's less than 10
    CMP DH, '0'
    JE PRINT_UNIT_POS
    PUSH DX
    MOV DL, DH
    MOV AH, 02H
    INT 21H
    POP DX
PRINT_UNIT_POS:
    MOV AH, 02H
    INT 21H

    ; Exit
    MOV AH, 4CH
    INT 21H
END START