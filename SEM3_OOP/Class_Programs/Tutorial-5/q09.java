import java.util.*;
public class q09 {
    public static void main(String[] args) {
ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D")); Iterator<String> it = list.iterator();
while (it.hasNext()) {
            String val = it.next();
            if (val.equals("C")) it.remove();
        }
        System.out.println(list);
    }
}

// Ans. B) [A,B,D]
