import java.util.Scanner;

public class StringConcatenation {
    public static String concatTrimmed(String a, String b) {
        int minLen = Math.min(a.length(), b.length());

        String aTrimmed = a.length() > minLen ? a.substring(a.length() - minLen) : a;
        String bTrimmed = b.length() > minLen ? b.substring(b.length() - minLen) : b;

        return aTrimmed + bTrimmed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = scanner.nextLine();

        System.out.print("Enter second string: ");
        String second = scanner.nextLine();

        String result = concatTrimmed(first, second);

        System.out.println("Result: " + result);

        scanner.close();
    }
}
