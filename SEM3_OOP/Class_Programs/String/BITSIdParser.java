import java.util.Scanner;

public class BITSIdParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter BITS ID (e.g., 2024A7PS0080D): ");
        String bitsId = sc.nextLine().toUpperCase();

        if (bitsId.length() != 13) {
            System.out.println("Invalid BITS ID length.");
            return;
        }

        // Year of admission
        String year = bitsId.substring(0, 4);

        // Discipline Code (e.g., A7, A4)
        String disciplineCode = bitsId.substring(4, 6);

        // Program: PS, TS, or DL
        String program = bitsId.substring(6, 8);

        // Last 3 digits of student number
        String studentNumber = bitsId.substring(8, 12);
        String last3Digits = studentNumber.substring(1); // take last 3 digits

        // Campus code (last character)
        char campusCode = bitsId.charAt(12);
        String campus;

        switch (campusCode) {
            case 'P':
                campus = "Pilani";
                break;
            case 'G':
                campus = "Goa";
                break;
            case 'H':
                campus = "Hyderabad";
                break;
            case 'U':
                campus = "Dubai";
                break;
            default:
                campus = "Unknown";
        }

        // Map discipline code to actual branch
        String discipline;

        switch (disciplineCode) {
            case "A1":
                discipline = "Chemical Engineering";
                break;
            case "A2":
                discipline = "Civil Engineering";
                break;
            case "A3":
                discipline = "Electrical and Electronics Engineering";
                break;
            case "A4":
                discipline = "Mechanical Engineering";
                break;
            case "A5":
                discipline = "Manufacturing Engineering";
                break;
            case "A7":
                discipline = "Computer Science";
                break;
            case "A8":
                discipline = "Electronics and Instrumentation Engineering";
                break;
            case "B1":
                discipline = "Biological Sciences";
                break;
            case "B2":
                discipline = "Mathematics";
                break;
            case "B3":
                discipline = "Physics";
                break;
            case "B4":
                discipline = "Economics";
                break;
            case "B5":
                discipline = "Chemistry";
                break;
            case "AD":
                discipline = "Maths and Computing";
                break;
            default:
                discipline = "Unknown";
        }

        // Output the parsed information
        System.out.println("\n--- BITS ID Details ---");
        System.out.println("Year of Admission: " + year);
        System.out.println("Discipline: " + discipline + " (" + disciplineCode + ")");
        System.out.println("Program: " + program);
        System.out.println("Last 3 Digits of Student Number: " + last3Digits);
        System.out.println("Campus: " + campus + " (" + campusCode + ")");
    }
}
