# JAVA OOP NOTES 

---

## 1. CLASS & OBJECT TEMPLATE

```java
class ClassName {
    // Fields / Attributes
    int id;
    String name;

    // Constructor
    ClassName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method
    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    // Main method to test
    public static void main(String[] args) {
        ClassName obj = new ClassName(1, "John");
        obj.display();
    }
}
```

---

## 2. CONSTRUCTORS

| Type          | Example                                      | Notes                 |
| ------------- | -------------------------------------------- | --------------------- |
| Default       | `ClassName() {}`                             | No parameters         |
| Parameterized | `ClassName(int a) {}`                        | Commonly used         |
| Copy          | `ClassName(ClassName c) { this.id = c.id; }` | Copies another object |

---

## 3. ENCAPSULATION

```java
class Student {
    private String name;
    private int age;

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

**Tip:** Always use `private` fields and `public` getters/setters.

---

## 4. INHERITANCE

```java
class Parent {
    void greet() { System.out.println("Hello from Parent"); }
}

class Child extends Parent {
    void greetChild() { System.out.println("Hello from Child"); }
}

public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        c.greet();       // From parent
        c.greetChild();  // From child
    }
}
```

**Types of Inheritance:**

* Single → `Child extends Parent`
* Multilevel → `GrandChild extends Child`
* Hierarchical → multiple children of one parent
* Multiple (not supported) → use **interfaces**

---

## 5. METHOD OVERRIDING & `super`

```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound(); // Optional: call parent
        System.out.println("Dog barks");
    }
}
```
 **Rules:**

* Same method name + parameters
* Happens in **different classes** (inheritance)

---

## 6. METHOD OVERLOADING

```java
class Calc {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

**Rules:**

* Same name, **different parameters**
* Happens in **same class**

---

## 7. ABSTRACTION

### ➤ Using Abstract Class

```java
abstract class Shape {
    abstract void draw(); // No body
    void info() { System.out.println("Shape info"); }
}

class Circle extends Shape {
    void draw() { System.out.println("Drawing Circle"); }
}
```

### ➤ Using Interface

```java
interface Vehicle {
    void start();
}

class Car implements Vehicle {
    public void start() { System.out.println("Car started"); }
}
```

**Difference:**

| Abstract Class            | Interface                                            |
| ------------------------- | ---------------------------------------------------- |
| Can have concrete methods | Only abstract methods (until Java 8 default methods) |
| Use `extends`             | Use `implements`                                     |

---

## 8. POLYMORPHISM

### ➤ Compile-Time (Overloading)

Handled by method signature.

### ➤ Run-Time (Overriding)

```java
class Animal { void sound() { System.out.println("Animal"); } }
class Dog extends Animal { void sound() { System.out.println("Dog"); } }

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog(); // Parent ref, child object
        a.sound(); // "Dog"
    }
}
```

---

## 9. STATIC

```java
class Counter {
    static int count = 0; // Shared among all
    Counter() { count++; }
    static void showCount() {
        System.out.println("Count: " + count);
    }
}
```

Access static stuff via class name:
`Counter.showCount();`

---

## 10. `this` & `super`

| Keyword | Meaning                         | Example                        |
| ------- | ------------------------------- | ------------------------------ |
| `this`  | Refers to current object        | `this.name = name;`            |
| `super` | Calls parent method/constructor | `super();` or `super.method()` |

---

## 11. COMPOSITION (HAS-A)

```java
class Engine {
    void start() { System.out.println("Engine starts"); }
}

class Car {
    private Engine engine = new Engine();
    void start() { engine.start(); }
}
```
 Use when **“has-a”** relationship exists.

---

## 12. FINAL, ABSTRACT, STATIC, etc.

| Keyword    | Used For                             | Example                 |
| ---------- | ------------------------------------ | ----------------------- |
| `final`    | Prevent inheritance or modification  | `final class X {}`      |
| `abstract` | Enforce implementation in subclasses | `abstract void show();` |
| `static`   | Shared member                        | `static int count;`     |
| `this`     | Current object reference             | `this.id = id;`         |
| `super`    | Parent reference                     | `super.method();`       |

---

## 13. PACKAGES & IMPORTS

```java
package mypack;
public class A {
    public void show() { System.out.println("Hello"); }
}
```

```java
import mypack.A;
class B {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();
    }
}
```

---

## 14. EXCEPTION HANDLING

```java
try {
    int a = 5 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Always executes");
}
```

**Custom Exception**

```java
class MyException extends Exception {
    MyException(String msg) { super(msg); }
}
```

---

## 15. INTERFACE + MULTIPLE INHERITANCE

```java
interface A { void show(); }
interface B { void display(); }

class C implements A, B {
    public void show() { System.out.println("A show"); }
    public void display() { System.out.println("B display"); }
}
```

**Allows multiple inheritance via interfaces**

---

## 16. INNER CLASSES

```java
class Outer {
    class Inner {
        void msg() { System.out.println("Inner class"); }
    }
}
```

```java
Outer.Inner obj = new Outer().new Inner();
obj.msg();
```

---

## 17. COMMON SHORTCUT PROGRAM STRUCTURES

| Task            | Snippet                                                |
| --------------- | ------------------------------------------------------ |
| Object array    | `Student[] arr = new Student[5];`                      |
| Type casting    | `Parent p = new Child(); ((Child)p).childMethod();`    |
| `toString()`    | `public String toString() { return name + " " + id; }` |
| Compare objects | `obj1.equals(obj2)` or `==` (for reference)            |

---

## QUICK DEBUG HACKS

* `System.out.println("Here");` → Trace flow.
* `Ctrl + F` → Quickly find keywords like `extends`, `implements`, `class`.

---

Would you like me to make this into a **printable PDF-style version (formatted for quick reference during exam)**?
I can include **page headers, syntax boxes, and color highlights** for quick scanning.
