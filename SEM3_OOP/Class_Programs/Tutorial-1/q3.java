public class q3 {
  public static final int max = 100;
    public static void main(String[] args) {
    max++;
    System.out.println(max);
  }
}

// Ans. b) Compilation error because "final" is used as keyword so i can't be updated!
// If final is removed the answer is 101
