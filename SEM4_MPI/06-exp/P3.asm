.MODEL SMALL
.STACK 20

PRINT MACRO MSG
MOV AH,09H
MOV DX,OFFSET MSG
INT 21H
ENDM

.DATA
DAY DB ?, ?, '-'
MONTH DB ?, ?, '-'
YEAR DB ?, ?, ?, ?, '$'
.CODE
START:
MOV AX,@DATA
MOV DS,AX
MOV ES,AX
MOV AH,2AH ; Function code to get Date
INT 21H ; Call DOS service
PUSH CX ; Saving year
PUSH DX ; Saving Day and Month
MOV AL,DL ; move DL to AL
LEA SI,DAY ; load effective address of Day to SI
MOV AH,00H ; Move 00H to AH
CALL CONV ; To call CONV subroutine
POP DX ; Putting ASCII value in memory
MOV AL,DH ; move DH to AL
LEA SI,MONTH ; Load the effective address of Month to SI
MOV AH,00H ; move 00H to AL
CALL CONV ; To convert month to ASCII
POP AX ; Putting ASCII value in memory
LEA SI,YEAR ; Load effective address of YEAR to SI

CALL CONV ; To convert year to ASCII
PRINT DAY ; To display Date
MOV AH,4CH ; Exit program
INT 21H

CONV PROC NEAR ; Procedure convert Hexadecimal
MOV CX,0000H ; Day, Month and Year to BCD
MOV BX,000AH ; and ASCII for display
NEXT:
MOV DX,0000 ; move 0000 to DX
DIV BX ; Separating the digits
ADD DL,30H ; Converting BCD to ASCII
PUSH DX
INC CX ; increment CX
CMP AX,000AH
JGE NEXT
ADD AL,30H
MOV [SI],AL
UP:
POP AX ; Putting ASCII value in memory
INC SI ; increment SI
MOV [SI],AL
LOOP UP
RET ; return
CONV ENDP ; end of the procedure conv
END START
