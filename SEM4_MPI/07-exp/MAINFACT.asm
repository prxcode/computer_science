.MODEL SMALL
.STACK 20
.DATA
N DB ?
RES DW 1
MSG DB 0DH, 0AH, 'Enter number between 1 to 8: $'
MES DB 0DH, 0AH, 'Factorial of number is:'
ASCII DB 4 DUP(0), 'H', '$'
PUBLIC N, RES, ASCII ; Making variables public
.CODE
EXTRN FACT:FAR, DISP:FAR ; To tell about the procedure
START: MOV AX, @DATA ; defined in different modules
MOV DS, AX
GO: LEA DX, MSG
MOV AH, 09
INT 21H
MOV AH, 01 ; Reading a single digit
INT 21H
SUB AL, 30H
CMP AL, 09
JNC GO
MOV N, AL
MOV AH, 00
CALL FACT ; Calling Recursive procedure
CALL DISP ; Calling DISP procedure
LEA DX, MES
MOV AH, 9
INT 21H
MOV AH, 4CH
INT 21H
END START