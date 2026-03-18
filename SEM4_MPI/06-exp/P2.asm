.MODEL SMALL
STACK 20
.DATA
MS DB "PRESENT TIME IS: $"
.CODE
START:
MOV AX,@DATA
MOV DS,AX
MOV AH,00 ; Function code to clear screen
MOV AL,03H ; text video mode
INT 10H ; Calling BIOS interrupts
MOV AH,02 ; Function code to set Cursor position.
MOV BH,0 ; video page number
MOV DH,12 ; Row number
MOV DL,30 ; Column number
INT 10H ; Calling BIOS interrupts
LEA DX,MS ; Display the msg
MOV AH,09
INT 21H

MOV AH,2CH ; Function code to read the system time, Hour in CH,

; Minute in CL, Second in DH

INT 21H
MOV AL,CH ; To display Hour
CALL DISP ; Calling DISP procedure for displaying Hour
MOV DL,':' ; to display ‘:’ after Hour
MOV AH,02 ; display the content of DL
INT 21H
MOV AL,CL ; To display Minute
CALL DISP ; Calling DISP procedure for displaying Minute
MOV DL,':' ; to display ‘:’ after Minute
MOV AH,02 ; WRITE CHARACTER TO STANDARD OUTPUT
INT 21H
MOV AL,DH ; To display Second
CALL DISP ; Calling DISP procedure for displaying second
MOV AH,02 ; WRITE CHARACTER TO STANDARD OUTPUT
MOV BH,0 ; video page number
MOV DH,24 ; ROW
MOV DL,00 ; COLUMN
INT 10H ; Calling BIOS interrupts
MOV AH,4CH ; Exit the program to OS
INT 21H
DISP PROC NEAR
AAM ; ASCII Adjust for Multiplication or BCD Adjust after Multiply
ADD AX,3030H
MOV BX,AX ; move AX to BX
MOV DL,BH ; move BH to DL
MOV AH,02 ; WRITE CHARACTER TO STANDARD OUTPUT
INT 21H
MOV DL,BL ; move BL to DL
MOV AH,02 ; WRITE CHARACTER TO STANDARD OUTPUT
INT 21H
RET ; Return
ENDP ; end procedure
END START
