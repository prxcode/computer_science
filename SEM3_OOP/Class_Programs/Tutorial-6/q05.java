class Parent {
    static void display() {
        System.out.println("Parent");
    }
}
class Child extends Parent {
    static void display() {
        System.out.println("Child");
    }
}
public class q05 {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display();
    }
}

// Ans A) Parent
