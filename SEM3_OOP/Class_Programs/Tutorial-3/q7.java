class A {
    int value = 100;
}
public class q7 {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A();
        obj2 = obj1;
        obj1.value = 500;
        System.out.println(obj2.value);
} }


// Ans. B) 500
