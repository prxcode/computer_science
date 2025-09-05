module testbench_NOT;
  reg p;
  wire q;
  initial
    begin
      $dumpfile("dump.vcd");
      $dumpvars(1,testbench_NOT);
      #000 p = 0;
      #100 p = 1;
      #100 p = 0;
	  #100 p = 1;
      #100 $stop;
    end
  NOTgate U1(q,p);
endmodule