import java.util.*;
public class q12{
    public static void main(String[] args) {
List<String> list = new LinkedList<>(Arrays.asList("A", "B")); ListIterator<String> it = list.listIterator();
it.next();
it.add("X");
        System.out.println(list);
    }
}

// Ans. A) [A,X,B]
