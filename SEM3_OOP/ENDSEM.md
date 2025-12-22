Got it — **panic-mode Java OOPS crash course**, focused on **writing programs on paper**.
I’ll keep it **simple, exam-oriented, and example-heavy**. You don’t need IDE knowledge, just logic + syntax.

Save this and revise 🔥

---

# 1️⃣ Basics

## Data Types

```java
int a = 10;
float b = 2.5f;
double d = 10.5;
char c = 'A';
boolean flag = true;
```

## Flow Control

### if–else

```java
if (a > 0) {
    System.out.println("Positive");
} else {
    System.out.println("Negative");
}
```

### for loop

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

### while

```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}
```

---

# 2️⃣ Classes & Objects

## Class

```java
class Student {
    int id;
    String name;
}
```

## Object

```java
Student s = new Student();
s.id = 1;
s.name = "Ram";
```

---

# 3️⃣ Constructors

```java
class Student {
    int id;
    Student(int i) {
        id = i;
    }
}
```

### Constructor Overloading

```java
Student() {}
Student(int i) { id = i; }
```

---

# 4️⃣ Methods

```java
int add(int a, int b) {
    return a + b;
}
```

### Method Overloading

```java
int add(int a, int b) {}
double add(double a, double b) {}
```

---

# 5️⃣ `this` Keyword

Used to refer current object

```java
class Student {
    int id;
    Student(int id) {
        this.id = id;
    }
}
```

---

# 6️⃣ `static`

Belongs to class, not object

```java
class Test {
    static int x = 10;
    static void show() {
        System.out.println(x);
    }
}
```

---

# 7️⃣ `final`

```java
final int x = 10;      // constant
final class A {}       // cannot inherit
final void show() {}   // cannot override
```

---

# 8️⃣ Access Modifiers

| Modifier  | Scope                   |
| --------- | ----------------------- |
| public    | everywhere              |
| private   | same class              |
| protected | same package + subclass |
| default   | same package            |

---

# 9️⃣ Package

```java
package mypack;
```

---

# 🔟 Arrays

## 1D Array

```java
int a[] = {1,2,3};
```

## 2D Array

```java
int a[][] = {{1,2},{3,4}};
```

---

# 1️⃣1️⃣ String Classes

## String (immutable)

```java
String s = "Hello";
```

## StringBuffer (mutable)

```java
StringBuffer sb = new StringBuffer("Hi");
sb.append(" Java");
```

## StringTokenizer

```java
StringTokenizer st = new StringTokenizer("Java is fun");
while(st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
```

---

# 1️⃣2️⃣ Collections

## ArrayList

```java
ArrayList<Integer> a = new ArrayList<>();
a.add(10);
```

## Vector

```java
Vector<Integer> v = new Vector<>();
v.add(1);
```

## LinkedList

```java
LinkedList<Integer> l = new LinkedList<>();
l.add(5);
```

## Iterator

```java
Iterator it = a.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}
```

---

# 1️⃣3️⃣ Inheritance

```java
class A {
    void show() {}
}

class B extends A {
    void display() {}
}
```

---

# 1️⃣4️⃣ Polymorphism

### Method Overriding

```java
class A {
    void show() {}
}

class B extends A {
    void show() {}
}
```

---

# 1️⃣5️⃣ Abstraction

## Abstract Class

```java
abstract class Shape {
    abstract void draw();
}
```

---

# 1️⃣6️⃣ Interface

```java
interface A {
    void show();
}

class B implements A {
    public void show() {}
}
```

---

# 1️⃣7️⃣ Exception Handling

```java
try {
    int a = 10/0;
} catch(Exception e) {
    System.out.println(e);
} finally {
    System.out.println("Done");
}
```

---

# 1️⃣8️⃣ Multithreading

## Thread class

```java
class A extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
```

## Runnable

```java
class A implements Runnable {
    public void run() {}
}
```

---

# 1️⃣9️⃣ Inner Classes

```java
class Outer {
    class Inner {
        void show() {}
    }
}
```

### Anonymous Class

```java
Runnable r = new Runnable() {
    public void run() {}
};
```

---

# 2️⃣0️⃣ Shallow vs Deep Copy

* **Shallow copy** → references copied
* **Deep copy** → actual data copied

```java
Obj o2 = o1;   // shallow
```

---

# 2️⃣1️⃣ GUI (AWT)

```java
Frame f = new Frame("My App");
Button b = new Button("Click");
f.add(b);
f.setSize(300,300);
f.setVisible(true);
```

---

# 2️⃣2️⃣ UML Diagrams (VERY IMPORTANT)

## Class Diagram

* Class name
* Variables
* Methods

```
Student
---------
id
name
---------
getData()
```

## Use Case

* Actor → Use case (oval)

## Sequence

* Object interaction order

## State

* States + transitions

---

# 2️⃣3️⃣ Design Patterns (basic answers)

* **Singleton** → only one object
* **Factory** → object creation
* **Observer** → notify changes

---

## 🔥 EXAM STRATEGY

* Write **syntax correctly**
* Add **comments**
* Even partial programs get marks
* UML & theory = easy marks
