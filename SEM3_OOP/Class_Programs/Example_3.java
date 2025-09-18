class Example_3 {
  public static void main(String args[]) {
    int arr[] = {3, 1, 2, 5, 4};
    sum(arr);
  }

  // Correct method definition
  public static void sum(int arr[]) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    System.out.println("SUM OF ARRAY VALUE: " + sum);
  }
}
