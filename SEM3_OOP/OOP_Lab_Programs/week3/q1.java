import java.util.Scanner;

class Student {
    private String name;
    private double score1, score2, score3;

    // Procedure to enter student's name and scores
    public void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        name = sc.nextLine();

        System.out.print("Enter score for exam 1: ");
        score1 = sc.nextDouble();

        System.out.print("Enter score for exam 2: ");
        score2 = sc.nextDouble();

        System.out.print("Enter score for exam 3: ");
        score3 = sc.nextDouble();
    }

    // Procedure to compute mean score
    public double computeMean() {
        return (score1 + score2 + score3) / 3.0;
    }

    // Procedure to display student's name and mean score
    public void displayDetails() {
        System.out.println("\nStudent: " + name);
        System.out.printf("Average score: %.2f\n", computeMean());
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.inputDetails();
        s.displayDetails();
    }
}
