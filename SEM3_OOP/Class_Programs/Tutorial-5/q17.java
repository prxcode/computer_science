import java.util.ArrayList;

public class q17 {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.addTask("Buy groceries");
        tm.addTask("Call mom");
        tm.addTask("Buy groceries");
        tm.displayTasks();
    }
}
