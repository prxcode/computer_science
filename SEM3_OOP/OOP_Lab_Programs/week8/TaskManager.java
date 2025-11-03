import java.util.Scanner;
import java.util.LinkedList;

class TaskManager {
    private LinkedList<String> tasks = new LinkedList<>();


    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(String task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    public void updateTask(String oldTask, String newTask) {
        int index = tasks.indexOf(oldTask);
        if (index != -1) {
            tasks.set(index, newTask);
            System.out.println("Task updated: " + oldTask + " → " + newTask);
        } else {
            System.out.println("Task not found: " + oldTask);
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks to complete:");
            for (String task : tasks) {
                System.out.print(task + " → ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();

        System.out.print("Enter number of initial tasks: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            tm.addTask(sc.nextLine());
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Update task");
            System.out.println("4. Display all tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter new task: ");
                    tm.addTask(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter task name to remove: ");
                    tm.removeTask(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter task name to update: ");
                    String oldTask = sc.nextLine();
                    System.out.print("Enter new task name: ");
                    String newTask = sc.nextLine();
                    tm.updateTask(oldTask, newTask);
                    break;
                case 4:
                    tm.displayTasks();
                    break;
                case 5:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice! Try entering 1-5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
