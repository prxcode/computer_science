interface Machine { void start(); }
abstract class Robot implements Machine {
  abstract void compute();
  public void start() { System.out.println("Robot Started"); }
}
public class q10 {
    public static void main(String[] args) {
      Robot r = new Robot() {
        void compute() {
          class CPU {
            void process() { System.out.println("Processing..."); }
          }
          new CPU().process();
    }
};
r.start();
r.compute();
    }
}
// Ans. A) Robot Started -> Processing...
