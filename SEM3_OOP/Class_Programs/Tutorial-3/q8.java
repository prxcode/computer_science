class A {
    int x;
void set(int x) {
        this.x = x;
}
    int get() {
        return x;
} }
public class q8 {
    public static void main(String[] args) {
        A obj = new A();
        obj.set(25);
        A ref = obj;
        ref.set(50);
        System.out.println(obj.get());
} }

// Ans. B) 50
