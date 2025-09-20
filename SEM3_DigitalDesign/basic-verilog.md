# Verilog Basics

### 1. **What is Verilog?**
- Verilog is a **Hardware Description Language (HDL)**.  
- Unlike C or Python (which describe *software*), Verilog describes **hardware circuits**.  
- Used for:
  - **Designing** digital systems (logic gates → CPUs)  
  - **Simulating** before building hardware  
  - **Synthesizing** into real circuits (FPGA, ASIC)

---

### 2. **Typical Structure of a Verilog Program**

Every Verilog design is written inside a **module**.  
Here’s the skeleton:

```verilog
module module_name (port_list);
  // 1. Port Declarations
  input a, b;
  output y;

  // 2. Internal Signals
  wire w1;
  reg r1;

  // 3. Continuous Assignments (for combinational logic)
  assign y = a & b;

  // 4. Procedural Blocks (for sequential logic)
  always @(posedge clk) begin
    r1 <= a ^ b;
  end
endmodule
```

---

### 3. **Key Building Blocks**

#### (a) **Module**
- The **basic unit** of Verilog design.
- Defines inputs, outputs, and functionality.
```verilog
module and_gate (input a, input b, output y);
  assign y = a & b;
endmodule
```

#### (b) **Data Types**
- **wire** → represents a physical connection (used in combinational logic).  
- **reg** → stores a value (used in sequential logic, inside `always` blocks).  

#### (c) **Operators**
- **Bitwise**: `&` (AND), `|` (OR), `~` (NOT), `^` (XOR)  
- **Logical**: `&&`, `||`, `!`  
- **Relational**: `==`, `!=`, `<`, `>`  
- **Arithmetic**: `+`, `-`, `*`, `/`

#### (d) **Continuous Assignment**
- Uses `assign` keyword.  
- Drives values onto **wires**.  
```verilog
assign sum = a ^ b;
assign carry = a & b;
```

#### (e) **Procedural Blocks**
- **always**: Executes whenever a condition changes.  
- **initial**: Executes once at the start of simulation.  

Example:
```verilog
always @(posedge clk) begin
  q <= d;   // D flip-flop
end
```

---

### 4. **Modeling Styles in Verilog**
There are **3 abstraction levels** you must know:

1. **Gate-Level Modeling**  
   - Uses built-in gate primitives.  
   ```verilog
   module half_adder (input a, b, output sum, carry);
     xor x1 (sum, a, b);
     and a1 (carry, a, b);
   endmodule
   ```

2. **Dataflow Modeling**  
   - Uses `assign` and Boolean expressions.  
   ```verilog
   module half_adder (input a, b, output sum, carry);
     assign sum = a ^ b;
     assign carry = a & b;
   endmodule
   ```

3. **Behavioral Modeling**  
   - Uses `always` blocks, if-else, case statements.  
   ```verilog
   module half_adder (input a, b, output reg sum, carry);
     always @(*) begin
       sum = a ^ b;
       carry = a & b;
     end
   endmodule
   ```

---

### 5. **Testbench Basics**
- A **testbench** is a Verilog module that **tests your design**.  
- It has **no inputs/outputs**—just generates signals and observes results.  

Example:
```verilog
module tb;
  reg a, b;
  wire sum, carry;

  // Instantiate the design
  half_adder uut (.a(a), .b(b), .sum(sum), .carry(carry));

  initial begin
    a = 0; b = 0;
    #10 a = 0; b = 1;
    #10 a = 1; b = 0;
    #10 a = 1; b = 1;
  end
endmodule
```

---

### 6. **Common Exam-Ready Verilog Snippets**

- **AND Gate**
```verilog
module and_gate (input a, b, output y);
  assign y = a & b;
endmodule
```

- **2:1 Multiplexer**
```verilog
module mux2to1 (input a, b, sel, output y);
  assign y = sel ? b : a;
endmodule
```

- **D Flip-Flop**
```verilog
module dff (input d, clk, output reg q);
  always @(posedge clk)
    q <= d;
endmodule
```
