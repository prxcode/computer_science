# Files you need
```
-> half_adder.v       # the design
-> half_adder_tb.v    # the testbench that drives it
```
# How to run it (using free tools)
Icarus Verilog (most common for coursework, Linux-friendly):
```
sudo apt install iverilog
iverilog -o half_adder_sim half_adder.v half_adder_tb.v
vvp half_adder_sim
```
Output will print the truth table as it simulates each input combination.

> Alternative — EDA Playground (zero install, browser-based): paste both files into edaplayground.com, pick Icarus Verilog as the simulator, hit Run.
