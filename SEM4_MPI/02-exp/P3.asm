.MODEL SMALL
.STACK 20
.DATA
ORG 1000H
N1 DB 35H ; Input Number one
N2 DB 82H ; Input Number two
Un_Sign_PROD DW ? ; This the variable to store Unsigned multiplication
Sign_PROD DW ? ; This the variable to store Signed multiplication
.CODE ; code segment start here
START:
MOV AX, @DATA ; Initialize DS
MOV DS, AX
MOV AL, N1 ; storing the first value (N1) to AL
MUL N2 ; Unsigned multiplication, multiplying the N2 with N1
MOV Un_Sign_PROD, AX ; moving the results of AX to Un_sign_Prod variable
MOV AL, N1 ; storing the first value (N1) to AL
IMUL N2 ; Signed multiplication, IMUL multiplies signed numbers
MOV Sign_PROD, AX ; moving the results from AX to sign_PROD variable memory
INT 3 ; Breakpoint interrupt
END START ; stopping the program
