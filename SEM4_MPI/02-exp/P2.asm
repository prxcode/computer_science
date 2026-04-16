.MODEL SMALL ; Type of the model declaration
.STACK 20 ; size of the stack declaration
.DATA ; Data segment declaration
Org 1000H ; Memory address initialization. Data start from memory location

; 1006 (it may vary, depends upon your processor)

NUM1 DB 89H,35H,45H,32H,56H,98H,76H,76H; These are array of 8 hex numbers
NUM2 DB 32H,56H,43H,75H,89H,10H,34H,22H; These are second array of numbers
ANS DB 9 DUP(0) ; size of the memory to store the results, it reserves 9

; duplicate no. with ‘0’ value.

COUNT DW 8H ; counter to store 8, since 8 times we need to subtract
.CODE ; code start here
START:
MOV AX, @DATA
MOV DS, AX ; Initializing DS: segment register
MOV CX, COUNT ; Reg CX is initialising to COUNT=8
MOV SI, 0H ; Initializing Source Index Register SI=0
CLC ; Clears the Carry Flag before subtraction
REPEAT: ; Initialising the loop
MOV AL, NUM1 [SI] ; Loading the 1st array value to AL register
SBB AL, NUM2 [SI] ; subtracting the 2nd array value to AL register value
MOV ANS [SI], AL ; moving the subtracted result to ANS variable
INC SI ; incrementing the Source Index for the next position
LOOP REPEAT ; loop repeat
INT 3 ; Breakpoint interrupt
END START ; stopping the program
