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
        // Create two accounts
        Account acc1 = new Account("A001", "Alice", 5000);
        Account acc2 = new Account("A002", "Bob", 2000);

        // Print initial details
        System.out.println("Initial Accounts:");
        System.out.println(acc1);
        System.out.println(acc2);

        // Test credit
        System.out.println("\nCrediting 1000 to Alice:");
        acc1.credit(1000);
        System.out.println(acc1);

        // Test debit
        System.out.println("\nDebiting 500 from Bob:");
        acc2.debit(500);
        System.out.println(acc2);

        // Test transfer
        System.out.println("\nAlice transfers 2000 to Bob:");
        acc1.transferTo(acc2, 2000);
        System.out.println(acc1);
        System.out.println(acc2);

        // Test invalid debit
        System.out.println("\nTrying to debit 10000 from Bob:");
        acc2.debit(10000);
        System.out.println(acc2);
    }
}
