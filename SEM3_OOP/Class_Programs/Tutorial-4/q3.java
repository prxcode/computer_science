public class q3 {
  int x;
    CopyTest(int i) { x = i; }
    CopyTest(CopyTest ct) { x = ct.x; }
    public static void main(String[] args) {
    CopyTest a = new CopyTest(5);
    CopyTest b = new CopyTest(a);
    b.x = 10;
    System.out.println(a.x);
  }
}

// Ans A) 5
