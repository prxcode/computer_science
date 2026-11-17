module tb_full_subtractor;
    reg a, b, borrow_in;
    wire difference, borrow_out;

    full_subtractor uut (
        .a(a), .b(b), .borrow_in(borrow_in),
        .difference(difference), .borrow_out(borrow_out)
    );

    initial begin
        $display("a b bin | difference bout");
        $monitor("%b %b  %b  |     %b       %b", a, b, borrow_in, difference, borrow_out);

        a = 0; b = 0; borrow_in = 0; #10;
        a = 0; b = 0; borrow_in = 1; #10;
        a = 0; b = 1; borrow_in = 0; #10;
        a = 0; b = 1; borrow_in = 1; #10;
        a = 1; b = 0; borrow_in = 0; #10;
        a = 1; b = 0; borrow_in = 1; #10;
        a = 1; b = 1; borrow_in = 0; #10;
        a = 1; b = 1; borrow_in = 1; #10;
        $finish;
    end
endmodule
