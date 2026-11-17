module signed_subtractor (
    input  signed [7:0] a,
    input  signed [7:0] b,
    output signed [8:0] diff
);

    assign diff = a - b;

endmodule
