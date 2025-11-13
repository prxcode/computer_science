abstract class Base {
    Base() { print(); }
    abstract void print();
}
class Derived extends Base {
    int x = 10;
    void print() { System.out.println(x); }
}
public class q02 {
public static void main(String[] args) {
        new Derived();
} 
}

// Ans. B) 0
