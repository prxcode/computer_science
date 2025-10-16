import java.util.StringTokenizer;
public class q3 {
    public static void main(String[] args) {
StringTokenizer st = new StringTokenizer("Java,,Python, ,C++", ","); int count = 0;
while (st.hasMoreTokens()) {
System.out.println("Token: " + st.nextToken());
count++; }
System.out.println("Total: " + count); }
}

// Ans. B) 4
