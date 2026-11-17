module signed_adder (
    input  signed [7:0] a,
    input  signed [7:0] b,
    output signed [8:0] sum
);

    assign sum = a + b;

endmodule
