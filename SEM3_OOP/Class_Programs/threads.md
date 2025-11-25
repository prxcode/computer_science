# **Java Threads Notes**

## **1. Introduction to Threads**

* A **thread** is a lightweight subprocess, the smallest unit of execution in Java.
* Java supports **multithreading**, which allows concurrent execution of two or more threads.
* **Benefits of multithreading:**

  * Better CPU utilization
  * Faster program execution
  * Responsive UI in GUI applications

---

## **2. Thread States**

A thread in Java can be in one of these states:

1. **New** – Thread is created but not started.
2. **Runnable** – Thread is ready to run and waiting for CPU time.
3. **Running** – Thread is currently executing.
4. **Blocked/Waiting** – Thread is waiting for a resource or signal.
5. **Terminated/Dead** – Thread has finished execution.

---

## **3. Creating Threads in Java**

### **Method 1: Extending Thread Class**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // start() method calls run() internally
    }
}
```

* **Important:** Always use `start()` to begin execution, not `run()`.

---

### **Method 2: Implementing Runnable Interface**

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running using Runnable");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

* **Advantage:** Can extend another class, since Java supports only single inheritance.

---

## **4. Thread Lifecycle Methods**

| Method             | Description                                     |
| ------------------ | ----------------------------------------------- |
| `start()`          | Starts a new thread and calls `run()` method    |
| `run()`            | Contains the code executed by the thread        |
| `sleep(ms)`        | Pauses thread for given milliseconds            |
| `join()`           | Waits for a thread to finish execution          |
| `yield()`          | Suggests the thread scheduler to switch threads |
| `setPriority(int)` | Sets thread priority (1 to 10)                  |
| `getPriority()`    | Returns thread priority                         |
| `isAlive()`        | Checks if thread is alive                       |

---

## **5. Thread Priority**

* Priority ranges from **1 (MIN_PRIORITY)** to **10 (MAX_PRIORITY)**. Default is 5.
* Higher priority threads get preference but no guarantee of execution order.

```java
Thread t1 = new Thread();
t1.setPriority(Thread.MAX_PRIORITY);
System.out.println(t1.getPriority()); // 10
```

---

## **6. Thread Synchronization**

* Multiple threads accessing shared resources can lead to **data inconsistency**.
* **Synchronization** ensures only one thread accesses a resource at a time.

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count); // 2000
    }
}
```

* `synchronized` can be applied to:

  * **Methods**
  * **Blocks**: `synchronized(this) { ... }`

---

## **7. Inter-Thread Communication**

* Threads can communicate using:

  * `wait()` – Thread waits until notified
  * `notify()` – Wakes up one waiting thread
  * `notifyAll()` – Wakes up all waiting threads
* Must be called inside a synchronized context.

```java
class Shared {
    synchronized void produce() throws InterruptedException {
        System.out.println("Producing item...");
        wait();
        System.out.println("Resumed producing");
    }

    synchronized void consume() {
        System.out.println("Consuming item...");
        notify();
    }
}
```

---

## **8. Thread-safe Collections**

* Java provides thread-safe alternatives for collections:

  * `Vector` instead of `ArrayList`
  * `Hashtable` instead of `HashMap`
  * `Collections.synchronizedList(list)`
  * `ConcurrentHashMap`, `CopyOnWriteArrayList`

---

## **9. Daemon Threads**

* **Daemon threads** are background threads that terminate automatically when all user threads finish.
* Example: Garbage Collector is a daemon thread.

```java
Thread t = new Thread();
t.setDaemon(true);
```

---

## **10. Key Points**

* Always use `start()` to begin a thread.
* Use synchronization to prevent race conditions.
* Threads improve performance in CPU-intensive and I/O tasks.
* Avoid using `stop()`, `suspend()`, `resume()` methods (deprecated).
