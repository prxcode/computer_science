import java.util.Scanner;
import java.util.ArrayList;

class q1 {
    static ArrayList<String> stud = new ArrayList<String>();
    static Scanner sc = new Scanner(System.in);

    static void insertstud() {
        System.out.println("Enter 5 Students name: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = sc.nextLine();
            stud.add(name);
        }
    }

    static void displaystud() {
        System.out.println("Initial Student List: " + stud);
    }

    static void removestud() {
        if (stud.size() >= 3) {
            stud.remove(2);
            System.out.println("After Removing 3rd Name: " + stud);
        } else {
            System.out.println("Less than 3 students.");
        }
    }

    static void updatestud() {
        System.out.print("Enter a new student name to add at 2nd place: ");
        String newstud = sc.nextLine();
        if (stud.size() >= 1) {
            stud.add(1, newstud);
        } else {
            stud.add(newstud);
        }
	System.out.println("After Adding "+newstud+" at 2nd Position: "+stud);

    }

    static void replacestud() {
        System.out.print("Enter a name to update at last: ");
        String newName = sc.nextLine();
        if (!stud.isEmpty()) {
            stud.set(stud.size() - 1, newName);
	System.out.println("After updating Last Name to "+newName+" :"+stud);
       
} else {
            System.out.println("Student list is empty!");
        }
	
    }

    static void findstud() {
        System.out.print("Enter a name to search: ");
        String searchName = sc.nextLine();
        if (stud.contains(searchName)) {
            System.out.println(searchName + " is present in the list.");
        } else {
            System.out.println(searchName + " does not exist");
        }
	System.out.println("Final List of Student names: "+stud);
    }

    static void revstud() {
        System.out.print("Final Student List (Reverse)");
        for (int i = stud.size() - 1; i >= 0; i--) {
            System.out.println(stud.get(i));
        }
    }

    public static void main(String args[]) {
        insertstud();
        displaystud();
        removestud();
        updatestud();
        replacestud();
        findstud();
        revstud();
        sc.close();
    }
}
