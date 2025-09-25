import java.util.Scanner;

public class CountTheWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your message:");
        String message = sc.nextLine();

      
        String[] words = message.toLowerCase().split("\\W+"); 

        int count = 0;

  
        for (String word : words) {
            if (word.equals("the")) {
                count++;
            }
        }

        System.out.println("The word 'the' appears " + count + " times.");

        sc.close();
    }
}
