import java.util.Scanner;

public class DoubloonChecker {

    public static boolean isDoubloon(String word) {
        word = word.toLowerCase();
        int[] letterCounts = new int[26];


      
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                letterCounts[ch - 'a']++;
            }
        }
        for (int count : letterCounts) {
            if (count != 0 && count != 2) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = scanner.nextLine();

        if (isDoubloon(input)) {
            System.out.println(input + " is a doubloon!");
        } else {
            System.out.println(input + " is NOT a doubloon.");
        }

        scanner.close();
    }
}
