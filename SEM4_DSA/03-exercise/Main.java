import java.io.*;
import java.util.*;

class Student {
    String id;
    String name;
    String dob;
    double cgpa;

    Student(String id, String name, String dob, double cgpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.cgpa = cgpa;
    }
}

class CircularQueue {
    Student[] queue;
    int front, rear, size, capacity;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Student[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(Student s) {
        if (isFull()) return;
        rear = (rear + 1) % capacity;
        queue[rear] = s;
        size++;
    }

    Student dequeue() {
        if (isEmpty()) return null;
        Student s = queue[front];
        front = (front + 1) % capacity;
        size--;
        return s;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        CircularQueue queue = new CircularQueue(100);

        BufferedReader br = new BufferedReader(new FileReader("studentin.dat"));
        String line;

        // Read from file and enqueue
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+"); // handles extra spaces
            if (parts.length >= 4) {
                String id = parts[0];
                String name = parts[1];
                String dob = parts[2];
                double cgpa = Double.parseDouble(parts[3]);

                queue.enqueue(new Student(id, name, dob, cgpa));
            }
        }
        br.close();

        System.out.println("Records in FIFO order:\n");

        ArrayList<String> lowCgpa = new ArrayList<>();

        // Dequeue and display
        while (!queue.isEmpty()) {
            Student s = queue.dequeue();

            System.out.println(s.id + " " + s.name + " " + s.dob + " " + s.cgpa);

            if (s.cgpa < 9.0) {
                lowCgpa.add(s.name);
            }
        }

        System.out.println("\nStudents with CGPA less than 9:\n");
        System.out.println("NAME");

        for (String name : lowCgpa) {
            System.out.println(name);
        }
    }
}



/*
Studentin.dat file 

2021A7PS001 AAAA 1/1/2000 7.50
2021A7PS002 BBBB 2/1/2000 9.20
2021A7PS003 CCCC 3/1/2000 9.60
2021A7PS004 DDDD 4/1/2000 8.75
2021A7PS005 EEEE 5/1/2000 9.25
*/
