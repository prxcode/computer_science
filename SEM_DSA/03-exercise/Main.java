import java.io.*;

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
    int front;
    int rear;
    int size;
    int capacity;

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
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = s;
        size++;
    }

    Student dequeue() {
        if (isEmpty()) {
            return null;
        }
        Student s = queue[front];
        front = (front + 1) % capacity;
        size--;
        return s;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        int capacity = 100;
        CircularQueue queue = new CircularQueue(capacity);

        BufferedReader br = new BufferedReader(new FileReader("studentin.dat"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length >= 4) {
                String id = parts[0];
                String name = parts[1];
                String dob = parts[2];
                double cgpa = Double.parseDouble(parts[3]);
                Student s = new Student(id, name, dob, cgpa);
                queue.enqueue(s);
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("studentout.dat"));

        while (!queue.isEmpty()) {
            Student s = queue.dequeue();
            String output = s.id + " " + s.name + " " + s.dob + " " + s.cgpa;
            System.out.println(output);
            bw.write(output);
            bw.newLine();
            if (s.cgpa < 9.0) {
                System.out.println("Name with CGPA < 9: " + s.name);
            }
        }

        bw.close();
    }
}
