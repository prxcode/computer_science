module not_chain(o1,o7);
  output o7;
  input o1;
  wire o2, o3, o4, o5, o6;
  notgate_gatelevel G1(o2,o1);
  notgate_gatelevel G2(o3,o2);
  notgate_gatelevel G3(o4,o3);
  notgate_gatelevel G4(o5,o4);
  notgate_gatelevel G5(o6,o5);
  notgate_gatelevel G6(o7,o6);
endmodule

module notgate_gatelevel(z,a);
  input a;
  output z;
  not #1 (z,a);
endmodule