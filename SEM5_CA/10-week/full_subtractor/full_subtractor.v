module full_subtractor (
    input a, b, borrow_in,
    output difference, borrow_out
);

    assign difference = a ^ b ^ borrow_in;
    assign borrow_out = ((~a) & b) | ((~(a ^ b)) & borrow_in);

endmodule
