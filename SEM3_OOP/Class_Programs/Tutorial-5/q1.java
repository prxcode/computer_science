public class q1 {
    public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("abc"); sb.reverse();
    sb.append("123");
    sb.insert(2, "XYZ");
            sb.delete(1, 4);
            System.out.println(sb);
    }
}

// Ans. cZa123
