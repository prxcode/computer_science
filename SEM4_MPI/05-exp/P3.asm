.MODEL SMALL
.STACK 20
DISP MACRO MSG ; Macro Declaration, DISP is the name of the Macro.
MOV AH, 09H ; To display message
MOV DX, OFFSET MSG ; Load the MSG offset address to DX
INT 21H ; DOS interrupt 21H
ENDM ; End Macro

.DATA ; Data segment start here
MSG1 DB 0DH, 0AH, 'Input a string:$' ; 0DH,0AH are carriage Return & Line Feed

; $ to terminate
SRC DB 80 ; Maximum size of the string
DB ? ; Actual size of the string
DB 30 DUP (?) ; To store actual string
MSG2 DB 0DH, 0AH, 'The reversed string is:' ; MSG2 to store the reversed string is
REV DB 30 DUP (?) ; To store the reversed string

.CODE ; code start here
START:
MOV AX, @DATA ; Data segment start here
MOV DS, AX
MOV ES, AX ; moving AX to ES
DISP MSG1 ; MSG1 is a parameter to MSG of macro DISP, it displays
; input a string:
MOV DX, OFFSET SRC ; move Source offset address to DX
MOV AH, 0AH ; Function code to read a string
INT 21H ; DOS interrupt 21H
MOV SI, OFFSET SRC+2 ; increment the source offset by 2 and store the address
; to SI
MOV DI, OFFSET REV-1 ; decrement the reverse offset address by 1 and store the
; results in DI
MOV CL, SRC+1 ; Length of the string, here SRC is size of the string, it is
; incremented by 1
MOV CH, 00 ; make CH=0
ADD DI, CX ; Add cout value to DI
MOV BYTE PTR [DI+1], '$'; End character for function 09H
CLD ; Clear Direction Flag
NEXT:
MOVSB ; move string of words depending on CLD, SI,DI
; automatically increase or decrease by 2

SUB DI, 0002 ; subtract 0002 with DI
LOOP NEXT
DISP MSG2 ; Display message 2
MOV AH, 4CH ; program termination
INT 21H ; DOS interrupt 21H
END START
