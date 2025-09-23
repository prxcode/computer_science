class A {
    int x = 10;
    A() {
      x = 20;
} }
public class Test {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.x);
    }
}


// Ans. D. Compilation Error
