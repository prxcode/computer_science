import java.util.*;
public class q11 {
    public static void main(String[] args) {
List<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three")); ListIterator<String> it = list.listIterator(list.size());
while (it.hasPrevious()) {
    System.out.print(it.previous() + " ");
}
}
}
// Ans. A) Three Two One
