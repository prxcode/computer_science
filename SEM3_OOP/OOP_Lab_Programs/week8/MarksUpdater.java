import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class MarksUpdater {
    private List<String> studentMarks = new ArrayList<>();
    private ListIterator<String> iterator;
    private boolean canRemoveOrSet = false; 


    public void initializeIterator() {
        iterator = studentMarks.listIterator();
        canRemoveOrSet = false;
    }


    public void nextEntry() {
        if (iterator.hasNext()) {
            System.out.println("Cursor at: " + iterator.next());
            canRemoveOrSet = true;
        } else {
            System.out.println("Already at the end of the list.");
            canRemoveOrSet = false;
        }
    }

    public void previousEntry() {
        if (iterator.hasPrevious()) {
            System.out.println("Cursor at: " + iterator.previous());
            canRemoveOrSet = true;
        } else {
            System.out.println("Already at the beginning of the list.");
            canRemoveOrSet = false;
        }
    }

    public void setEntry(String entry) {
        if (canRemoveOrSet) {
            iterator.set(entry);
            System.out.println("Updated current to: " + entry);
        } else {
            System.out.println("Cannot set. Move next or previous first.");
        }
    }

    public void addEntry(String entry) {
        iterator.add(entry);
        System.out.println("Added: " + entry);
        canRemoveOrSet = false; 
    }


    public void removeEntry() {
        if (canRemoveOrSet) {
            iterator.remove();
            System.out.println("Removed last returned entry.");
            canRemoveOrSet = false;
        } else {
            System.out.println("Cannot remove. Move next or previous first.");
        }
    }


    public void displayList() {
        if (studentMarks.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.print("List: ");
            for (String entry : studentMarks) {
                System.out.print(entry + " → ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MarksUpdater mu = new MarksUpdater();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter entries (Name:Marks):");
        for (int i = 0; i < n; i++) {
            mu.studentMarks.add(sc.nextLine());
        }

        mu.initializeIterator();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. next");
            System.out.println("2. previous");
            System.out.println("3. set <Name:Marks>");
            System.out.println("4. add <Name:Marks>");
            System.out.println("5. remove");
            System.out.println("6. display");
            System.out.println("7. exit");
            System.out.print("Action: ");

            String input = sc.nextLine();
            String[] parts = input.split(" ", 2);
            choice = Integer.parseInt(parts[0]);

            switch (choice) {
                case 1:
                    mu.nextEntry();
                    break;
                case 2:
                    mu.previousEntry();
                    break;
                case 3:
                    if (parts.length < 2) {
                        System.out.println("Provide entry to set. Example: 3 Name:Marks");
                    } else {
                        mu.setEntry(parts[1]);
                    }
                    break;
                case 4:
                    if (parts.length < 2) {
                        System.out.println("Provide entry to add. Example: 4 Name:Marks");
                    } else {
                        mu.addEntry(parts[1]);
                    }
                    break;
                case 5:
                    mu.removeEntry();
                    break;
                case 6:
                    mu.displayList();
                    break;
                case 7:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid action! Enter 1-7.");
            }

        } while (choice != 7);

        sc.close();
    }
}
