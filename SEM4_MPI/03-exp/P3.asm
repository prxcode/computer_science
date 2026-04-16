.MODEL SMALL
.STACK 20
.DATA ; Data segment start here
ORG 1200H ; Memory address one initialization as given in the program
ARRAY1 DB 05H, 15H, 25H, 35H, 45H,55H, 65H, 75H, 85H, 95H ; Inputs
ORG 1220H ; Memory address two initialization as given in the program
ARRAY2 DB 0A1H, 0A2H, 0A3H, 0A4H, 0A5H, 0A6H, 0A7H, 0A8H, 0A9H, 0AAH

; Inputs

COUNT DW 000AH ; Count Variable to store length of the array i.e 000A
.CODE ; Code start here
START:
MOV AX, @DATA ; Initializing DS: segment register
MOV DS, AX
MOV CX, COUNT ; Reg CX is initialising to COUNT
MOV SI, 0000H ; Initializing Source Index Register SI=0000
REPEAT: ; Loop start here
MOV AL, ARRAY1 [SI] ; Moving first element of array one to AL Register
XCHG AL, ARRAY2 [SI] ; Exchange Data. The XCHG exchange the contents of

; two operands.

MOV ARRAY1 [SI], AL ; Move the Content of AL to Array one address
INC SI ; Increment SI
LOOP REPEAT ; Loop Repeat
INT 3 ; Breakpoint interrupt
END START ; stopping the program
