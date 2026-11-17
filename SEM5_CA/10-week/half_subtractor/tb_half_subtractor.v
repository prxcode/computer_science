module tb_half_subtractor;
    reg a, b;
    wire difference, borrow;

    half_subtractor uut (
        .a(a), .b(b),
        .difference(difference), .borrow(borrow)
    );

    initial begin
        $display("a b | difference borrow");
        $monitor("%b %b |     %b        %b", a, b, difference, borrow);

        a = 0; b = 0; #10;
        a = 0; b = 1; #10;
        a = 1; b = 0; #10;
        a = 1; b = 1; #10;
        $finish;
    end
endmodule
