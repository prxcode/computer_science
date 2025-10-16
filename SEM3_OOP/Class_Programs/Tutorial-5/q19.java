import java.util.ArrayList;
import java.util.Iterator;

public class q19 {
    public void removeShortStrings(ArrayList<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() < 5) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hi");
        strings.add("World");
        strings.add("Java");
        strings.add("Swing");
        strings.add("OOP");

        StringFilter filter = new StringFilter();
        filter.removeShortStrings(strings);

        System.out.println(strings);
    }
}
