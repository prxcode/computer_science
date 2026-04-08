.MODEL SMALL
.DATA
EXTRN MES: BYTE ; Use MES of previous module
.CODE
PUBLIC DISP ; DISP is now “visible” to other modules
DISP PROC FAR
LEA DX, MES
MOV AH, 9
INT 21H
RET
DISP ENDP
END