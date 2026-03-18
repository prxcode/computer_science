.MODEL SMALL
.STACK 20

.CODE
START:
    CALL READKB        ; read character
    MOV AL, BL         ; move ASCII value to AL
    CALL DISP          ; display ASCII value
    MOV AH, 4CH        ; terminate program
    INT 21H



READKB PROC NEAR
    MOV AH, 01H        ; read character
    INT 21H            ; AL = ASCII
    MOV BL, AL         ; save ASCII
    RET
READKB ENDP



DISP PROC NEAR
    MOV AX, 0          ; clear AX
    MOV AL, BL         ; put ASCII value in AL

    ; divide by 100 to get hundreds digit
    MOV CX, 100
    DIV CL             ; AL = hundreds, AH = remainder
    CMP AL, 0
    JE SKIP_HUND

    ADD AL, 30H
    MOV DL, AL
    MOV AH, 02H
    INT 21H
SKIP_HUND:

    ; divide remainder by 10 to get tens
    MOV AL, AH         ; remainder
    MOV AH, 0
    MOV CL, 10
    DIV CL             ; AL = tens, AH = ones

    ADD AL, 30H
    MOV DL, AL
    MOV AH, 02H
    INT 21H

    ADD AH, 30H
    MOV DL, AH
    MOV AH, 02H
    INT 21H

    RET
DISP ENDP

END START
