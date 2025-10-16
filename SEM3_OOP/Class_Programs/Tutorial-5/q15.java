import java.util.*;
public class q15 {
    public static void main(String[] args) {
LinkedList<String> list = new LinkedList<>(Arrays.asList("1", "2", "3")); ListIterator<String> it = list.listIterator();
while (it.hasNext()) {
            String s = it.next();
            it.add(s + s);
        }
        System.out.println(list);
    }
}

// Ans. A) [1, 11, 2, 22, 3, 33]
