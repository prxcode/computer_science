module tb_logic_gates;
    reg a, b;
    wire and_out, or_out, not_a, nand_out, nor_out, xor_out, xnor_out;

    // Connect design module
    logic_gates uut (
        .a(a), .b(b),
        .and_out(and_out), .or_out(or_out), .not_a(not_a),
        .nand_out(nand_out), .nor_out(nor_out),
        .xor_out(xor_out), .xnor_out(xnor_out)
    );

    initial begin
        $display("a b | AND OR NOT_A NAND NOR XOR XNOR");
        $monitor("%b %b |  %b   %b    %b    %b    %b   %b   %b", 
                 a, b, and_out, or_out, not_a, nand_out, nor_out, xor_out, xnor_out);

        a = 0; b = 0; #10;
        a = 0; b = 1; #10;
        a = 1; b = 0; #10;
        a = 1; b = 1; #10;
        $finish;
    end
endmodule
