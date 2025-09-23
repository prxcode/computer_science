class A { A() {
this(5);
        System.out.print("Default ");
    }
    A(int x) {
        System.out.print("Param ");
} }
public class q2 {
    public static void main(String[] args) {
new A(); }
}

// Ans. C) Param Default 
