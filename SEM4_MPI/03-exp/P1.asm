
.MODEL SMALL
.STACK 20
.DATA ; Data segment start here
ORG 1000H ; Memory address initialization
NUM DB 25H, 35H, 45H, 32H, 56H, 98H, 76H,76H ; eight 2-digit hex numbers input
SUM DW ? ; Variable to store Sum
COUNT DW 0008H ; Count Variable to store count 8
.CODE ; Code start here
START:
MOV AX, @DATA ; Initializing DS: segment register
MOV DS, AX
MOV CX, COUNT ; Reg CX is initialising to COUNT=8
MOV SI, 0000H ; Initializing Source Index Register SI=0000
MOV AX, 0000H ; move AX=0000
REPEAT: ; Loop start here
ADD AL, NUM[SI] ; Moving the 1st array value to AL register
JNC NEXT ; Jump If not Carry, here Next is 16bit address.
ADD AH, 01 ; Add 01 to AH
NEXT: ; Next address reference
INC SI ; Increment SI
LOOP REPEAT ; Repeat loop Reference
MOV SUM, AX ; Moving the AX value to Sum variable memory
INT 3 ; Breakpoint interrupt
END START ; stopping the program
