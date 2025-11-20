import java.util.Scanner;

public class StudentDemo {

    static class StudentException extends Exception {
        public StudentException(String msg) {
            super(msg);
        }
    }

    static class Student {
        private int roll;
        private String name;
        private int age;
        private String course;

        public Student(int roll, String name, int age, String course) throws StudentException {
            if (roll <= 0) throw new StudentException("Invalid Roll Number");
            if (name == null || name.trim().isEmpty()) throw new StudentException("Invalid Name");
            if (age < 18 || age > 60) throw new StudentException("Invalid Age");
            if (course == null || course.trim().isEmpty()) throw new StudentException("Invalid Course");

            this.roll = roll;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public void display() {
            System.out.println("Roll: " + roll);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Course: " + course);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Roll Number: ");
            int r = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String n = sc.nextLine();

            System.out.print("Enter Age: ");
            int a = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String c = sc.nextLine();

            Student s = new Student(r, n, a, c);
            System.out.println("\nStudent Details:");
            s.display();

        } catch (StudentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
