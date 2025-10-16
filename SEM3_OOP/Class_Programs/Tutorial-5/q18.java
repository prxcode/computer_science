import java.util.*;

public class q18 {
    private LinkedList<String> history;
    private int capacity;

    public RecentHistory(int capacity) {
        this.capacity = capacity;
        this.history = new LinkedList<>();
    }

    public void access(String item) {
        history.remove(item);
        history.addFirst(item);
        if (history.size() > capacity) {
            history.removeLast();
        }
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public static void main(String[] args) {
        RecentHistory rh = new RecentHistory(3);
        rh.access("Page1");
        rh.access("Page2");
        rh.access("Page3");
        rh.access("Page2");
        rh.access("Page4");

        System.out.println(rh.getHistory());
    }
}
