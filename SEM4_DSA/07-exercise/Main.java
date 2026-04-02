import java.util.Random;

class Student {
    String name;
    int id;
    double cgpa;

    public Student(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-8s | CGPA: %.2f", id, name, cgpa);
    }
}

public class Main {

    public static void main(String[] args) {
        int n = 10;
        Student[] students = generateRandomRecords(n);

        System.out.println(" ## Original Unsorted Records");
        displayRecords(students);

        long startTime = System.nanoTime();

        quickSort(students, 0, students.length - 1);

        long endTime = System.nanoTime();

        System.out.println("\n ## Final Sorted Records in Ascending CGPA");
        displayRecords(students);

        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("\nExecution Time: " + duration + " ms");
    }

    public static void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            System.out.println("After partitioning with pivot CGPA " + arr[pi].cgpa + ":");
            displayCGPAs(arr);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Student[] arr, int low, int high) {
        double pivot = arr[high].cgpa;
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (arr[j].cgpa <= pivot) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static Student[] generateRandomRecords(int count) {
        Student[] list = new Student[count];
        String[] names = {"Rahul", "Harry", "Sam", "Suraj", "Abdul", "Pratham", "Suryansh", "Pranav", "Suraj", "John"};
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            list[i] = new Student(
                names[rand.nextInt(names.length)], 
                100 + i, 
                1.0 + (9.0 * rand.nextDouble())
            );
        }
        return list;
    }

    public static void displayRecords(Student[] arr) {
        for (Student s : arr) System.out.println(s);
    }

    public static void displayCGPAs(Student[] arr) {
        for (Student s : arr) System.out.print(String.format("%.2f ", s.cgpa));
        System.out.println("\n");
    }
}
