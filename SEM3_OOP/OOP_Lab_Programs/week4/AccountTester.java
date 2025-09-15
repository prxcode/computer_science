import java.util.Scanner;

public class AccountTester {

    static class Account {
        private String id;
        private String name;
        private double balance;

        public Account(String id, String name, double balance) {
            this.id = id;
            this.name = name;
            this.balance = balance;
        }

        public void credit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println(amount + " credited to " + name + "'s account.");
            } else {
                System.out.println("Invalid credit amount.");
            }
        }

        public void debit(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println(amount + " debited from " + name + "'s account.");
            } else {
                System.out.println("Debit amount exceeded balance or is invalid.");
            }
        }

        public void transferTo(Account another, double amount) {
            if (amount > 0 && amount <= balance) {
                this.debit(amount);
                another.credit(amount);
                System.out.println(amount + " transferred from " + this.name + " to " + another.name);
            } else {
                System.out.println("Transfer failed: amount invalid or insufficient balance.");
            }
        }

        public void display() {
            System.out.println("Account ID: " + id + ", Name: " + name + ", Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Account 1
        System.out.println("Create Account 1:");
        System.out.print("Enter Account ID: ");
        String id1 = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance1 = readPositiveDouble(scanner);

        Account acc1 = new Account(id1, name1, balance1);

        // Input for Account 2
        System.out.println("\nCreate Account 2:");
        System.out.print("Enter Account ID: ");
        String id2 = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance2 = readPositiveDouble(scanner);

        Account acc2 = new Account(id2, name2, balance2);

        System.out.println("\nAccounts created successfully!\n");

        boolean running = true;

        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1 - Credit Account 1");
            System.out.println("2 - Debit Account 1");
            System.out.println("3 - Credit Account 2");
            System.out.println("4 - Debit Account 2");
            System.out.println("5 - Transfer from Account 1 to Account 2");
            System.out.println("6 - Transfer from Account 2 to Account 1");
            System.out.println("7 - Show Account 1 Details");
            System.out.println("8 - Show Account 2 Details");
            System.out.println("0 - Exit");

            System.out.print("Enter your choice: ");
            int choice = readInt(scanner);

            double amount;

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to credit Account 1: ");
                    amount = readPositiveDouble(scanner);
                    acc1.credit(amount);
                    break;

                case 2:
                    System.out.print("Enter amount to debit Account 1: ");
                    amount = readPositiveDouble(scanner);
                    acc1.debit(amount);
                    break;

                case 3:
                    System.out.print("Enter amount to credit Account 2: ");
                    amount = readPositiveDouble(scanner);
                    acc2.credit(amount);
                    break;

                case 4:
                    System.out.print("Enter amount to debit Account 2: ");
                    amount = readPositiveDouble(scanner);
                    acc2.debit(amount);
                    break;

                case 5:
                    System.out.print("Enter amount to transfer from Account 1 to Account 2: ");
                    amount = readPositiveDouble(scanner);
                    acc1.transferTo(acc2, amount);
                    break;

                case 6:
                    System.out.print("Enter amount to transfer from Account 2 to Account 1: ");
                    amount = readPositiveDouble(scanner);
                    acc2.transferTo(acc1, amount);
                    break;

                case 7:
                    acc1.display();
                    break;

                case 8:
                    acc2.display();
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using the bank system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Utility method to safely read positive double values
    private static double readPositiveDouble(Scanner scanner) {
        while (true) {
            try {
                double val = Double.parseDouble(scanner.nextLine());
                if (val < 0) {
                    System.out.print("Please enter a positive number: ");
                } else {
                    return val;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a numeric value: ");
            }
        }
    }

    // Utility method to safely read int values
    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter an integer: ");
            }
        }
    }
}
