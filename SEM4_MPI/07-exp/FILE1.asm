.MODEL SMALL
.STACK 20
.DATA
MES DB 'CONGRATS! YOU HAVE SUCCEEDED $'
PUBLIC MES ; MES is now “visible” to other modules
.CODE
EXTRN DISP: FAR ; Procedure DISP is in different module
START: MOV AX, @DATA
MOV DS, AX
CALL DISP ; Calling procdure defined in other module
MOV AH, 4CH
INT 21H
END START