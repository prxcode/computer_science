interface Greeter { void greet(String name); }
class Service {
    void execute() {
        Greeter g = new Greeter() {
            public void greet(String name) {

System.out.println("Hello, " + name); }
};
        g.greet("Alice");
    }
}
public class q09 {
    public static void main(String[] args) {
        new Service().execute();
    }
}
// Ans. A) Hello, Alice
