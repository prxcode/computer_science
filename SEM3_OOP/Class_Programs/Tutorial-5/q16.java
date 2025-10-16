import java.util.*;

public class StudentNameProcessor {

    public static List<String> processStudentNames(String input) {
        Set<String> nameSet = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");

        while (tokenizer.hasMoreTokens()) {
            String name = tokenizer.nextToken().trim();
            if (!name.isEmpty()) {
                nameSet.add(name);
            }
        }

        List<String> sortedNames = new ArrayList<>(nameSet);
        Collections.sort(sortedNames);

        return sortedNames;
    }

    public static void main(String[] args) {
        String input = " Alice,  ,Bob,Charlie,,   ,alice,  Bob ,David";
        List<String> result = processStudentNames(input);
        System.out.println(result);
    }
}
