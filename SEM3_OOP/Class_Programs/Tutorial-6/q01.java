class A {
    int i = 10;
    void print() {
        System.out.print("A ");
} }
class B extends A {
    int i = 20;
    void print() {
        System.out.print("B ");
    }
    void show() {
        System.out.print(super.i + " ");
        super.print();
    }
}
public class q01 {
    public static void main(String[] args) {
B b = new B();
b.show(); }
}
// Ans. A) 10 A
