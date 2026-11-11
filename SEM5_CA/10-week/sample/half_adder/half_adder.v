module half_adder(
    input  a,
    input  b,
    output sum,
    output carry
);

    // sum is XOR of inputs
    assign sum = a ^ b;

    // carry is AND of inputs
    assign carry = a & b;

endmodule
