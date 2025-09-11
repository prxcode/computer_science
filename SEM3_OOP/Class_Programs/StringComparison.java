public class StringComparison {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        if (s1 == s2) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        // For demonstration, print the result of s1 == s2
        System.out.println("s1 == s2: " + (s1 == s2)); // true
    }
}
