// To create package

//File name: A.java
package p1;
public class A {
    protected void display() {
        System.out.println("Hello World!");
    }
}



// To call


//File name: MainClass.jav
package p2;
import p1.A;
public class MainClass extends A {
    public static void main(String[] args) {
        MainClass obj = new MainClass();
        obj.display();  // Accessing protected method via subclass instance
    }
}
