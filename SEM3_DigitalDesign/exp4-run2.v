module half_subtractor(diff, barrow, a, b);
  input a,b;
  output diff, borrow;
  assign diff = a^b;
  assign y = ~a;
  assign borrow = y & b;
endmodule
  
