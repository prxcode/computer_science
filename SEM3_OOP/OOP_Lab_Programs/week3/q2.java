import java.util.Scanner;

class BankAccount {
    public static void details() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        int accountNumber = sc.nextInt();

        System.out.println("Account created with balance $0.00");
        double balance = 0.0;

        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();
        System.out.println("Deposit Successful.");
        balance += deposit;

        System.out.println("Account: " + accountNumber + ", Balance: " + balance);

        System.out.print("Enter withdrawal amount: ");
        double withdraw = sc.nextDouble();

        if (withdraw <= balance) {
            System.out.println("Withdrawal Successful.");
            balance -= withdraw;
        } else {
            System.out.println("No Money in Bank!");
        }

        sc.close();
    }
}

public class q2 {
    public static void main(String[] args) {
        BankAccount.details();
    }
}
