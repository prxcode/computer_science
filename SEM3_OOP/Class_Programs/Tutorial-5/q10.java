import java.util.*;
public class q10 {
    public static void main(String[] args) {
ArrayList<String> list = new ArrayList<>(Arrays.asList("X", "Y", "Z")); for (String s : list) {
            if (s.equals("Y")) {
                list.remove(s);
} }
        System.out.println(list);
    }
}

// Ans. A) [X,Z]
