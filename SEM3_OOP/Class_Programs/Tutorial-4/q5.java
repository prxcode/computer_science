public class q5 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    for (int i = 0; i < nums.length; i++)
    nums[i] += nums[(i + 1) % nums.length];
    System.out.println(nums[0]);
  }
}

// Ans. A) 3
