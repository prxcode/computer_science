# **Java Topics Lab 1–11: Complete Guide with Code**

---

## **1️⃣ Classes and Objects**

**Concept:** Classes are blueprints; objects are instances.

```java
class Student {
    String name;
    int rollNo;

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }
}

public class Lab1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Alice";
        s1.rollNo = 101;
        s1.display();
    }
}
```

---

## **2️⃣ Arithmetic Operations**

```java
public class Arithmetic {
    public static void main(String[] args) {
        int a = 10, b = 3;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulo: " + (a % b));
    }
}
```

---

## **3️⃣ Method Overloading**

**Concept:** Multiple methods with same name but different parameters.

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(5, 3));       // int
        System.out.println(c.add(5.5, 3.2));   // double
    }
}
```

---

## **4️⃣ Arrays**

**Single-dimensional array:**

```java
public class ArrayExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

**Multi-dimensional array:**

```java
public class MultiArray {
    public static void main(String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## **5️⃣ Array of Objects**

```java
class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println(name + " - " + rollNo);
    }
}

public class ArrayOfObjects {
    public static void main(String[] args) {
        Student[] arr = {
            new Student("Alice", 101),
            new Student("Bob", 102)
        };
        for(Student s : arr) s.display();
    }
}
```

---

## **6️⃣ Strings, StringBuffer, StringTokenizer**

**String Example:**

```java
String str = "Hello World";
System.out.println(str.length());
System.out.println(str.toUpperCase());
```

**StringBuffer Example (mutable):**

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" Java");
System.out.println(sb);
```

**StringTokenizer Example:**

```java
import java.util.StringTokenizer;

StringTokenizer st = new StringTokenizer("Java is fun");
while(st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
```

---

## **7️⃣ Collection Classes**

**ArrayList Example:**

```java
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
list.add("Alice");
list.add("Bob");
System.out.println(list);
```

**LinkedList Example:**

```java
import java.util.LinkedList;

LinkedList<Integer> ll = new LinkedList<>();
ll.add(10);
ll.add(20);
System.out.println(ll);
```

**Vector Example:**

```java
import java.util.Vector;

Vector<String> v = new Vector<>();
v.add("A");
v.add("B");
System.out.println(v);
```

---

## **8️⃣ Inheritance**

```java
class Animal {
    void eat() { System.out.println("Animal eats"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}
```

---

## **9️⃣ Abstract Classes**

```java
abstract class Shape {
    abstract void area();
}

class Circle extends Shape {
    int r = 5;
    void area() {
        System.out.println("Area: " + (3.14 * r * r));
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.area();
    }
}
```

---

## **10️⃣ Interfaces**

```java
interface Printable {
    void print();
}

class Document implements Printable {
    public void print() {
        System.out.println("Printing document...");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Printable p = new Document();
        p.print();
    }
}
```

---

## **11️⃣ Exception Handling**

```java
public class ExceptionExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]); // causes exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        } finally {
            System.out.println("End of program.");
        }
    }
}
```

---
