import java.util.StringTokenizer;
public class q4 {
    public static void main(String[] args) {
    StringTokenizer st = new StringTokenizer("Hello World from Java"); 
      while (st.hasMoreTokens()) {
    System.out.print(st.nextToken() + "-"); }

    }
}

// Ans. A) Hello-World-from-Java-
