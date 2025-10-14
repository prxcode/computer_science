import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Choose 1 for Rock, 2 for Paper, 3 for Scissors.");

        for (int round = 1; round <= 10; round++) {
            System.out.println("\nRound " + round + ":");
            System.out.print("Enter your choice (1-Rock, 2-Paper, 3-Scissors): ");
            int playerChoice = scanner.nextInt();

            int computerChoice = (int)(Math.random() * 3) + 1;

            System.out.println("Computer chose: " + choiceToString(computerChoice));

            if (playerChoice == computerChoice) {
                System.out.println("It's a draw!");
            } else if (
                (playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)
            ) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }
        }

        System.out.println("\n--- Game Over ---");
        System.out.println("Your score: " + playerScore);
        System.out.println("Computer's score: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("You are the winner!");
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static String choiceToString(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Invalid";
        }
    }
}
