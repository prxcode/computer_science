import java.util.LinkedList;
public class q07 {
    public static void main(String[] args) {
LinkedList<String> list = new LinkedList<>(); list.add("First");
list.add("Second");
list.addFirst("Zeroth");
        list.removeLast();
        System.out.println(list);
    }
}
// Ans. B) [Zeroth, First]
