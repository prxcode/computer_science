public class q1 {
  public static void main(String[] args) {
    int[] arr = {10, 20, 30};
    int[] ref = arr;
    ref[1] = 99;
    System.out.println(arr[1]);
  }
}

// Ans B) 99
