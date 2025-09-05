module OR_2_behavioral(output reg Z, input E,F);
  always @(E or F)begin
    if (E==0 & F==0) begin
      #10 Z = 0;
    end 
    else
      #10 Z = 1;
  end 
endmodule