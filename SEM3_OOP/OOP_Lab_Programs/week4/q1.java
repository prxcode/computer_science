import java.util.Scanner;

class Account {
    // Attributes
    private String id;
    private String name;
    private int balance = 0; // default balance = 0

    // Constructor with id and name
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with id, name, and balance
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // Credit: add amount
    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    // Debit: subtract if balance available
    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    // Transfer: move money to another account
    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            this.balance -= amount;
            another.balance += amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    // toString
    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create accounts
        Account acc1 = new Account("A001", "Alice", 5000);
        Account acc2 = new Account("A002", "Bob", 2000);

        int choice;
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Show Accounts");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Account Details ---");
                    System.out.println(acc1);
                    System.out.println(acc2);
                    break;

                case 2:
                    System.out.print("\nEnter account ID (A001/A002): ");
                    String cid = sc.next();
                    System.out.print("Enter amount to credit: ");
                    int camt = sc.nextInt();
                    if (cid.equals("A001")) acc1.credit(camt);
                    else if (cid.equals("A002")) acc2.credit(camt);
                    else System.out.println("Invalid Account ID!");
                    break;

                case 3:
                    System.out.print("\nEnter account ID (A001/A002): ");
                    String did = sc.next();
                    System.out.print("Enter amount to debit: ");
                    int damt = sc.nextInt();
                    if (did.equals("A001")) acc1.debit(damt);
                    else if (did.equals("A002")) acc2.debit(damt);
                    else System.out.println("Invalid Account ID!");
                    break;

                case 4:
                    System.out.print("\nEnter source account ID (A001/A002): ");
                    String sid = sc.next();
                    System.out.print("Enter destination account ID (A001/A002): ");
                    String did2 = sc.next();
                    System.out.print("Enter amount to transfer: ");
                    int tamt = sc.nextInt();
                    if (sid.equals("A001") && did2.equals("A002")) acc1.transferTo(acc2, tamt);
                    else if (sid.equals("A002") && did2.equals("A001")) acc2.transferTo(acc1, tamt);
                    else System.out.println("Invalid account IDs!");
                    break;

                case 5:
                    System.out.println("\nExiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
