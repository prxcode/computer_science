import java.util.*;
public class q13 {
    public static void main(String[] args) {
List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30)); ListIterator<Integer> it = list.listIterator();
while (it.hasNext()) {
            int val = it.next();
            if (val == 20) {
                it.set(200);
            }
}
        System.out.println(list);
    }
}

// Ans. A) [10, 200, 30]
