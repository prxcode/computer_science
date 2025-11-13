interface X { void m1(); }
interface Y { void m2(); }
class Z implements X, Y {
public void m1() { System.out.println("m1 in Z"); } public void m2() { System.out.println("m2 in Z"); }
}
public class q07 {
    public static void main(String[] args) {
        X obj = new Z();
        ((Y)obj).m2();
    }
}

// Ans. A) m2 in Z
