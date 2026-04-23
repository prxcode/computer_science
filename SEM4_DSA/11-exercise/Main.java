import java.util.Scanner;

class Student {
    String name;
    int id;
    double cgpa;

    Student(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }
}

public class Main {

    public static void heapSort(Student[] arr, String criteria) {
        int n = arr.length;

        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, criteria);
        }

        // extract elements
        for (int i = n - 1; i > 0; i--) {
            Student temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, criteria);
        }
    }

    public static void heapify(Student[] arr, int n, int i, String criteria) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && compare(arr[left], arr[largest], criteria) > 0)
            largest = left;

        if (right < n && compare(arr[right], arr[largest], criteria) > 0)
            largest = right;

        if (largest != i) {
            Student temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest, criteria);
        }
    }

    // compare based on criteria
    public static int compare(Student a, Student b, String criteria) {
        if (criteria.equals("cgpa")) {
            return Double.compare(a.cgpa, b.cgpa);
        } else if (criteria.equals("id")) {
            return a.id - b.id;
        } else {
            return a.name.compareTo(b.name);
        }
    }

    public static void printStudents(Student[] arr) {
        System.out.println("Name\tIdNo\tCGPA");
        for (Student s : arr) {
            System.out.printf("%s\t%d\t%.2f\n", s.name, s.id, s.cgpa);
        }
        System.out.println();
    }

    public static Student[] copyArray(Student[] arr) {
        Student[] copy = new Student[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = new Student(arr[i].name, arr[i].id, arr[i].cgpa);
        }
        return copy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("IdNo: ");
            int id = sc.nextInt();
            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(name, id, cgpa);
        }

        System.out.println("\nBefore sorting:");
        printStudents(students);

        Student[] byCgpa = copyArray(students);
        heapSort(byCgpa, "cgpa");
        System.out.println("After sorting by CGPA:");
        printStudents(byCgpa);

        Student[] byName = copyArray(students);
        heapSort(byName, "name");
        System.out.println("After sorting by Name:");
        printStudents(byName);

        Student[] byId = copyArray(students);
        heapSort(byId, "id");
        System.out.println("After sorting by IdNo:");
        printStudents(byId);

        sc.close();
    }
}
