# quick notes
---

## **1. Class and Object**

* **Class** → Blueprint/template for creating objects.
* **Object** → Instance of a class (has data and behavior).

```java
class Car {
    String color;
    void drive() { System.out.println("Driving..."); }
}
Car c = new Car(); // object
```

---

## **2. Constructor**

* Used to **initialize objects**.
* Has **same name as class**, no return type.
* Types:

  * Default (by compiler)
  * Parameterized
  * Copy (manual)

```java
class Car {
    String color;
    Car(String c) { color = c; }
}
```

---

## **3. Interface**

* Contains **abstract methods** (no body).
* Supports **multiple inheritance**.
* Methods are **public and abstract** by default.
* Variables are **public static final**.

```java
interface Animal {
    void sound();
}
class Dog implements Animal {
    public void sound() { System.out.println("Bark"); }
}
```

---

## **4. Abstract Class**

* Can contain **abstract** and **non-abstract** methods.
* Used for **partial implementation**.

```java
abstract class Shape {
    abstract void draw();
    void info() { System.out.println("Shape info"); }
}
```

---

## **5. Comparable vs Comparator**

| Feature        | Comparable               | Comparator                           |
| -------------- | ------------------------ | ------------------------------------ |
| Package        | `java.lang`              | `java.util`                          |
| Method         | `compareTo()`            | `compare()`                          |
| Sorting Type   | Natural (default)        | Custom                               |
| Logic Location | Inside class             | Separate class                       |
| Sort Usage     | `Collections.sort(list)` | `Collections.sort(list, comparator)` |

---

## **6. Serializable**

* **Marker interface** (no methods) in `java.io`.
* Used to **convert object to byte stream** for file saving or transfer.

```java
class Student implements Serializable {
    int id; String name;
}
```

---

## **7. Throwable**

* **Superclass** of all exceptions and errors.
* Two main types:

  * **Exception** (recoverable)

    * Checked (IOException, SQLException)
    * Unchecked (RuntimeException, NullPointerException)
  * **Error** (serious system issue)

---

## **8. Threads**

* A **thread** is a unit of execution (for multitasking).
* Two ways to create a thread:

  1. Extend the `Thread` class.
  2. Implement the `Runnable` interface.

**Example 1: Extending Thread**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running thread...");
    }
}
new MyThread().start();
```

**Example 2: Implementing Runnable**

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task running...");
    }
}
Thread t = new Thread(new MyTask());
t.start();
```

---

## **9. Runnable Interface**

* Functional interface with **one method**:

  ```java
  public void run();
  ```
* Used to define the code executed by a thread.

```java
Thread t = new Thread(() -> System.out.println("Thread running"));
t.start();
```

---

## **10. Sorting in Java**

* **Purpose:** Arrange elements in ascending/descending order.
* **Methods:**

  * `Collections.sort(list)` → uses natural order (Comparable).
  * `Collections.sort(list, comparator)` → uses custom order.
  * `Arrays.sort(array)` → for arrays.

---

## **11. ArrayList**

* Dynamic array in `java.util`.
* Can store duplicate elements.
* Maintains insertion order.

**Common Methods:**

| Method     | Description         |
| ---------- | ------------------- |
| `add()`    | Add element         |
| `get()`    | Access element      |
| `set()`    | Replace element     |
| `remove()` | Remove element      |
| `size()`   | Get list size       |
| `clear()`  | Remove all elements |

**Example:**

```java
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
Collections.sort(list);
System.out.println(list);
```

---

## **12. sort() Method**

* Found in `Collections` and `Arrays` classes.
* Sorts elements in **natural** or **custom order**.

```java
Collections.sort(list); // natural
Collections.sort(list, comparator); // custom
Arrays.sort(array);
```

---

## **Summary Table**

| Concept        | Type             | Purpose                        |
| -------------- | ---------------- | ------------------------------ |
| Class/Object   | Structure        | Define and create objects      |
| Constructor    | Method           | Initialize objects             |
| Interface      | Abstract type    | Define contract for classes    |
| Abstract Class | Base class       | Provide partial implementation |
| Comparable     | Interface        | Natural sorting                |
| Comparator     | Interface        | Custom sorting                 |
| Serializable   | Marker interface | Object serialization           |
| Throwable      | Class            | Base for errors/exceptions     |
| Thread         | Class            | Multitasking                   |
| Runnable       | Interface        | Defines thread logic           |
| ArrayList      | Class            | Dynamic list                   |
| sort()         | Method           | Sort elements                  |

---



## Inner Class

#### Type 2
```java
public class MethodLocalInnerClass {
    int num = 20;

    public void Demo() {
        class InnerClass {
            public void display() {
                System.out.println("Hello from inner class");
                System.out.println("Number: " + num);
            }
        }

        InnerClass inner = new InnerClass();
        inner.display();
    }

    public static void main(String[] args) {
        MethodLocalInnerClass obj = new MethodLocalInnerClass();
        obj.Demo();
    }
}
```

## Anonymous Class

```java
class AnonymousInner {
    public void my_method() {
        System.out.println("Inside AnonymousInner class method");
    }
}

public class TestAnonymousInner {
    public static void main(String[] args) {

        AnonymousInner a_inner = new AnonymousInner() {
            @Override
            public void my_method() {
                System.out.println("Inside anonymous class method");
            }
        }; // ENDS with a SEMICOLON

        a_inner.my_method();
    }
}
```

```java
abstract class AnonymousClassEx {
    public abstract void display();
}

public class OutClass {
    public static void main(String[] args) {
        AnonymousClassEx inclass = new AnonymousClassEx() {
            @Override
            public void display() {
                System.out.println("Hello");
            }
        }; // ENDS WITH SEMICOLON
        inclass.display();
    }
}

```
Static inner class is a nested classm it does not have access to outer class and instantaenous

```java
class MyOuter{
    Static class NestedDemo{
    }
}
```
| **Type of Inner Class**      | **Where It’s Defined**                     | **Can Have static members?** | **Can Access Outer Class Members?**  | **When to Use**                                          | **Example (Short)**                                                                                                                                                                                               |
| ---------------------------- | ------------------------------------------ | ---------------------------- | ------------------------------------ | -------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **1. Member Inner Class**    | Inside a class, but **outside methods**    | ❌ (only constants)           | ✅ Yes, even private ones             | When an inner class logically belongs to the outer class | `java\nclass Outer {\n  class Inner {\n    void msg() { System.out.println("Inner"); }\n  }\n}\n`                                                                                                                 |
| **2. Static Nested Class**   | Inside a class, declared with `static`     | ✅                            | ❌ Only static members of outer class | When you don’t need access to outer instance             | `java\nclass Outer {\n  static class Inner {\n    void msg() { System.out.println("Static Inner"); }\n  }\n}\n`                                                                                                   |
| **3. Local Inner Class**     | Inside a **method or block**               | ❌                            | ✅ Yes                                | When you need a helper class only within a single method | `java\nclass Outer {\n  void display() {\n    class Inner {\n      void msg() { System.out.println("Local Inner"); }\n    }\n    new Inner().msg();\n  }\n}\n`                                                    |
| **4. Anonymous Inner Class** | Inside a method or expression; **no name** | ❌                            | ✅ Yes                                | When you need to override or implement something quickly | `java\ninterface A { void show(); }\nclass Test {\n  public static void main(String[] a){\n    A obj = new A(){\n      public void show(){ System.out.println("Anonymous"); }\n    };\n    obj.show();\n  }\n}\n` |


## Lambda Expression (->)

```java
interface Phone {
    void show();
}

public class Main {
    public static void main(String[] args) {
        Phone p = () -> System.out.println("Hello!");  
        p.show();
    }
}
```
