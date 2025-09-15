import java.util.Scanner;

class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            this.balance -= amount;
            another.balance += amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc1 = new Account("A001", "Alice", 5000);
        Account acc2 = new Account("A002", "Bob", 2000);

        int choice;

        do {
            System.out.println("1: Show Accounts\n2: Credit\n3: Debit\n4: Transfer\n5: Exit\nEnter your choice=  ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Accounts");
                    System.out.println(acc1);
                    System.out.println(acc2);
                    break;

                case 2:
                    System.out.print("Enter account ID (A001/A002)= ");
                    String cid = sc.next();
                    System.out.print("Enter amount to credit= ");
                    int camt = sc.nextInt();
                    if (cid == "A001") {   // using ==
                        acc1.credit(camt);
                    } else if (cid == "A002") {
                        acc2.credit(camt);
                    } else {
                        System.out.println("Invalid Account ID!");
                    }
                    break;

                case 3:
                    System.out.print("Enter account ID (A001/A002)= ");
                    String did = sc.next();
                    System.out.print("Enter amount to debit= ");
                    int damt = sc.nextInt();
                    if (did == "A001") {
                        acc1.debit(damt);
                    } else if (did == "A002") {
                        acc2.debit(damt);
                    } else {
                        System.out.println("Invalid Account ID!");
                    }
                    break;

                case 4:
                    System.out.print("Enter source account ID (A001/A002)= ");
                    String sid = sc.next();
                    System.out.print("Enter destination account ID (A001/A002)= ");
                    String did2 = sc.next();
                    System.out.print("Enter amount to transfer= ");
                    int tamt = sc.nextInt();
                    if (sid == "A001" && did2 == "A002") {
                        acc1.transferTo(acc2, tamt);
                    } else if (sid == "A002" && did2 == "A001") {
                        acc2.transferTo(acc1, tamt);
                    } else {
                        System.out.println("Invalid account IDs!");
                    }
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
