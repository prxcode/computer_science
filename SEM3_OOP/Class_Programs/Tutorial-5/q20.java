import java.util.LinkedList;
import java.util.ListIterator;

public class q20 {
    public void transformList(LinkedList<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 2 == 0) {
                iterator.set(0);
            } else {
                iterator.add(-1);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        ListTransformer transformer = new ListTransformer();
        transformer.transformList(numbers);

        System.out.println(numbers);
    }
}
