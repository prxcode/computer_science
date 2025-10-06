# Quiz 1 Topics
- Writing a basic program in Java
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, CS F213!");
    }
}
``` 
  
- Primitive types and control flow statements
```java
int x = 5;
if (x > 0) {
    System.out.println("Positive");
} else {
    System.out.println("Non-positive");
}

```
- The minor differences between C and Java syntax
| Feature     | C                        | Java                          |
| ----------- | ------------------------ | ----------------------------- |
| Platform    | OS-dependent             | Platform-independent (JVM)    |
| Memory Mgmt | Manual (malloc/free)     | Automatic (Garbage Collector) |
| OOP Support | No                       | Yes                           |
| Pointers    | Yes                      | No (Restricted)               |
| Compilation | Compiled to machine code | Compiled to bytecode (JVM)    |

- Command line arguments.
```java
public class CommandLineExample {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("First argument: " + args[0]);
        } else {
            System.out.println("No arguments provided.");
        }
    }
}
```
- Classes
```java
class Student {
    String name;
    int age;
}
```
- Objects
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "John";
        s.age = 20;
        System.out.println(s.name + " is " + s.age + " years old.");
    }
}
```
- Constructors
```java
class Student {
    String name;
    int age;

    Student() {
        name = "Default";
        age = 18;
    }
}
```
- Constructor overloading
```java
class Student {
    String name;
    int age;

    Student() {
        name = "Default";
        age = 18;
    }

    Student(String n, int a) {
        name = n;
        age = a;
    }
}
```
- Methods
```java
class MathUtils {
    int square(int x) {
        return x * x;
    }
}
```
- Method overloading
```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```
- Variables of class type and null type
```java
class Car {
    String model;
}

public class Main {
    public static void main(String[] args) {
        Car myCar = null;
        System.out.println(myCar);  // prints: null
    }
}
```
- Accessors and Mutators
```java
class Book {
    private String title;

    public String getTitle() {      // accessor
        return title;
    }

    public void setTitle(String t) { // mutator
        title = t;
    }
}
```
- This keyword
```java
class Dog {
    String name;

    Dog(String name) {
        this.name = name; // distinguishes instance variable from parameter
    }
}
```
- Static keyword
```java
class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}
```
- Static fields
```java
class University {
    static String name = "BITS Pilani";
}
```
- Static methods Arrays- 1D, 2D
```java
class MathUtils {
    static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println(MathUtils.square(4)); // Output: 16
    }
}

int[] arr = {1, 2, 3}; // 1D array

int[][] matrix = {
    {1, 2},
    {3, 4}
}; // 2D array

```
- Array of objects
```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        students[0] = new Student("Alice");
        students[1] = new Student("Bob");

        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

```
- Passing an array as an argument
```java
class ArrayPrinter {
    void printArray(int[] arr) {
        for (int val : arr) {
            System.out.println(val);
        }
    }
}

```
- Returning an array to the main method
```java
class ArrayGenerator {
    int[] generateArray() {
        return new int[]{1, 2, 3};
    }
}

```
- String
```java
public class Main {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s.toUpperCase()); // Output: HELLO
    }
}

```
- String Buffer
```java
public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb); // Output: Hello World
    }
}

```
- String Tokenizer
```java
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("CS-F213-Java", "-");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

```
