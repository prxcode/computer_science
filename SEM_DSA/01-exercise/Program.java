import java.util.*;
import java.io.*;

class Student {
    String id;
    String name;
    String dob;
    float cgpa;

    Student(String id, String name, String dob, float cgpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.cgpa = cgpa;
    }
}

class Stack {
    Student[] arr;
    int top;
    int size;

    Stack(int s) {
        size = s;
        arr = new Student[size];
        top = -1;
    }

    void push(Student s) {
        if (top == size - 1) {
            System.out.println("Stack Full");
            return;
        }
        top++;
        arr[top] = s;
    }

    Student pop() {
        if (top == -1) {
            return null;
        }
        Student s = arr[top];
        top--;
        return s;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class Program {
    public static void main(String[] args) throws IOException {
        Stack st = new Stack(100);
        Scanner sc = new Scanner(new File("studentin.dat"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("studentout.dat"));

        while (sc.hasNext()) {
            String id = sc.next();
            String name = sc.next();
            String dob = sc.next();
            float cgpa = sc.nextFloat();

            Student s = new Student(id, name, dob, cgpa);
            st.push(s);
        }

        while (!st.isEmpty()) {
            Student s = st.pop();
            String line = s.id + " " + s.name + " " + s.dob + " " + s.cgpa;
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }

        sc.close();
        bw.close();
    }
}
