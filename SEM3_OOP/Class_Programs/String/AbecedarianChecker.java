import java.util.Scanner;

public class AbecedarianChecker {

    public static boolean isAbecedarian(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isAbecedarian(input)) {
            System.out.println("The string is abecedarian.");
        } else {
            System.out.println("The string is NOT abecedarian.");
        }

        scanner.close();
    }
}
