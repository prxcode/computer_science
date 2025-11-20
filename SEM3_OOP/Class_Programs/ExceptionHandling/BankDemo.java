import java.util.Scanner;

public class BankDemo {

    static class NegativeBalanceException extends Exception {
        public NegativeBalanceException(String msg) {
            super(msg);
        }
    }

    static class CheckingAccount {
        private double balance;

        public CheckingAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public void withdraw(double amount) throws NegativeBalanceException {
            if (balance - amount < 0) {
                throw new NegativeBalanceException("Balance cannot go negative");
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial amount in bank: ");
        double initial = sc.nextDouble();

        CheckingAccount acc = new CheckingAccount(initial);

        System.out.print("Enter amount to withdraw: ");
        double w = sc.nextDouble();

        try {
            acc.withdraw(w);
            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + acc.getBalance());
        } catch (NegativeBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
