interface A { default void show() { System.out.println("A"); } } interface B { default void show() { System.out.println("B"); } }
abstract class C implements A, B {
    public void show() { B.super.show(); }
}
class D extends C {
    public void display() { super.show(); }
}
public class q03 {
    public static void main(String[] args) {
        new D().display();
    }
}

// Ans. B) B
