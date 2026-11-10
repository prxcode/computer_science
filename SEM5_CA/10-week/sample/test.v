timescale 1ns/1ps

module and_gate_tb();

reg a,b,c;
wire o;
integer i;

and_gate dut(.w(a), .x(a), .y(c), .z(o));

initial begin
$display("a b c | o");

for (i=0;i<8;i=i+1) begin
