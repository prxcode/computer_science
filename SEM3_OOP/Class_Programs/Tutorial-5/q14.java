import java.util.*;
public class q14 {
    public static void main(String[] args) {
LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C")); Iterator<String> it = list.descendingIterator(); // Error?
while (it.hasNext()) {
    System.out.print(it.next() + " ");
}
}
}

// Ans. A) C B A
