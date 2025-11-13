abstract class Processor {
    abstract int process(int x);
    void info() { System.out.println("Processor Ready"); }
}
public class q05 {
    public static void main(String[] args) {
        Processor p = new Processor() {
            int process(int x) {
                return x * x; 
            }
    };
    p.info(); 
    System.out.println(p.process(5));
}
}

// Ans. A) Processor Ready -> 25
