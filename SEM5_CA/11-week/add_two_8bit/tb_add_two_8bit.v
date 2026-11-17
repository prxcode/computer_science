
module tb_signed_adder;
    reg  signed [7:0] a, b;
    wire signed [8:0] sum;

    signed_adder uut (
        .a(a),
        .b(b),
        .sum(sum)
    );

    initial begin
        $display("a    | b    | sum");
        $monitor("%d | %d | %d", a, b, sum);

        a =  8'sd25;  b =  8'sd15;  #10; //  25 + 15  =  40
        a = -8'sd20;  b =  8'sd10;  #10; // -20 + 10  = -10
        a = -8'sd50;  b = -8'sd40;  #10; // -50 + -40 = -90
        a =  8'sd127; b =  8'sd127; #10; // 127 + 127 = 254
        $finish;
    end
endmodule
