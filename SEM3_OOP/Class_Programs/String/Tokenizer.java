import java.util.Scanner;
import java.util.StringTokenizer;

public class Tokenizer {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        StringTokenizer tokens = new StringTokenizer(sentence);
        System.out.printf("Number of elements: %d\nThe tokens are:\n", tokens.countTokens());

        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }

        scanner.close();
    }
}
