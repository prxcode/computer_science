// Verilog code for the above circuit
module circuit(X,A,B,C);
  input A,B,C; // input port declarations by default wire
  output X; // output port declarations by default wire
  wire P,Q,R; // wire declaration by default wire
  and a1(P,A,B); //instance name is not compulsory output of gate is always mentioned first
  not(Q,B);
  and(R,Q,C);
  or(X,R,P); //Input 2 OR Gate
endmodule
