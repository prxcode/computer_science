module tb_signed_subtractor;
    reg  signed [7:0] a, b;
    wire signed [8:0] diff;

    signed_subtractor uut (
        .a(a),
        .b(b),
        .diff(diff)
    );

    initial begin
        $display("a    | b    | diff");
        $monitor("%d | %d | %d", a, b, diff);

        a =  8'sd30;  b =  8'sd12;  #10; //  30 - 12   =  18
        a =  8'sd10;  b =  8'sd25;  #10; //  10 - 25   = -15
        a = -8'sd40;  b = -8'sd15;  #10; // -40 - (-15)= -25
        a = -8'sd128; b =  8'sd1;   #10; // -128 - 1  = -129
        $finish;
    end
endmodule
