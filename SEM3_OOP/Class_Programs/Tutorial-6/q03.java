class A {
int value = 100;
    A() {
value = 200; }
}
class B extends A {
    B() {
value = 300; }
}
public class q03 {
    public static void main(String[] args) {
        A obj = new B();
        System.out.println(obj.value);
    }
}

//Ans. C) 300
