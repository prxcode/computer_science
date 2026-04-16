.MODEL SMALL
.STACK 20
.DATA ; Data segment start here
ORG 1200H ; Memory address initialization as given in the program
ARRAY DB 25H, 35H, 45H, 32H, 56H, 25H, 76H, 76H, 28H, 56H, 05H, 35H, 25H, 00H,
98H, 21H ; Inputs
ORG 1220H ; Memory address initialization to store results
RES DB ? ; Variable to store Number of occurrences
COUNT DW 0010H ; Count Variable to store length of the array i.e 10
.CODE ; Code start here
START:
MOV AX, @DATA ; Initializing DS: segment register
MOV DS, AX
MOV CX, COUNT ; Reg CX is initializing to COUNT
MOV SI, 0000H ; Initializing Source Index Register SI=0000
MOV AL, 25H ; move AL=25H, We need to find out number of

; occurrences of 25H
REPEAT: ; Loop start here
CMP AL, ARRAY[SI] ; The CMP instruction compares two operands.
JNE NEXT ; Jump if Not Equal, if SI and AL data not equal it jumps

; to INC SI

INC RES ; if SI and AL equal the RES is incremented
NEXT:
INC SI ; Increment SI
LOOP REPEAT ; Loop Repeat
INT 3 ; Breakpoint interrupt
END START ; stopping the program
