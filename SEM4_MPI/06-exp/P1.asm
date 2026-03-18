.MODEL SMALL
.STACK 20
PRINT MACRO MSG ;Macro Declaration as print
MOV AH, 09H 

LEA DX, MSG ;load effective address of MSG to DX
INT 21H
ENDM

READ MACRO STR ;Macro declaration as read
LEA DX, STR ;load the effective address of STR to DX
MOV AH, 0AH ;0AH = Reading a string from keyboard
INT 21H
ENDM

.DATA
MSG1 DB 0DH, 0AH, 'Enter a filename:$'
MSG2 DB 0DH, 0AH, 'File is created$'
MSG3 DB 0DH, 0AH, 'Error in File creation$'
MSG4 DB 0DH, 0AH, 'Enter a text:$'
MSG5 DB 0DH, 0AH, 'Error in File opening$'
MSG6 DB 0DH, 0AH, 'Error in writing$'
MSG7 DB 0DH, 0AH, 'Creating and writing successful$'
FNAME DB 80
DB ?
DB 80 DUP(0)
TEXT DB 80
DB ?
DB 80 DUP(?)

.CODE
START:
MOV AX,@DATA
MOV DS, AX
MOV ES, AX
PRINT MSG1
READ FNAME ;Reading a file name
LEA SI,FNAME+2 ;FNAME is add of file name,
;FNAME+1 is add of file length
MOV CL,FNAME+1 ;Getting the length of file name
MOV CH,00 ;clear the ch register
ADD SI,CX ;To move SI at next location
MOV BYTE PTR[SI],00 ;Terminating file name by Zero
LEA DX,FNAME+2 ;Starting address to write text in file
MOV AH,3CH ;Function code to create file
MOV CX,0000H ;File attributes of the new file
INT 21H
JNC SUCC1 ;If file creation is success CY=0
PRINT MSG3 ;Error msg, if file is not created
JMP EXIT
SUCC1:
PRINT MSG2 ;Success msg of file creation
PRINT MSG4 ;msg to write text in created file
READ TEXT ;Reading text to be written to file
MOV AH,3DH ;Function code to open file
MOV AL,02H ;To open file in read/write mode
LEA DX,FNAME+2
INT 21H
JNC SUCC2 ;If file open is success CY=0
PRINT MSG5 ;error msg in opening the file
JMP EXIT
SUCC2:
MOV BX,AX ;File handling returned during open
MOV AH,40H ;Function code to write text
MOV CH, 00H ;Number of characters to written into the file

MOV CL,TEXT+1
LEA DX,TEXT+2
INT 21H
JNC SUCC3 ; If file writing is success CY=0
PRINT MSG6
MOV AH,3EH ;Function code to close the file.
INT 21H
JMP EXIT
SUCC3:
PRINT MSG7 ;Disp msg, Creation and writing successful.
EXIT:
MOV AH,4CH ;To terminate the program
INT 21H
END START
