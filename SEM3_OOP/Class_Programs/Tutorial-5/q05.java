import java.util.ArrayList;
public class q05 {
    public static void main(String[] args) {
ArrayList<String> list = new ArrayList<>(); list.add("A");
list.add("B");
list.add(1, "C");
        list.remove("B");
        System.out.println(list);
    }
}
// Ans. A) [A, C]
