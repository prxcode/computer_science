import java.util.Scanner;

public class GradeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of grades: ");
        int n = scanner.nextInt();

        int[] grades = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            sum += grades[i];
        }

        double average = (double) sum / n;

        System.out.println("Grades entered:");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }

        System.out.println("\nAverage grade: " + average);
    }
}
