import java.util.Scanner;

public class P1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements= ");
		int n = sc.nextInt();
		System.out.println("Enter " + n + " elements= ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		if (n<2) {
			System.out.println("Error");
		}
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			if(arr[i] > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = arr[i];
			}
			else if(arr[i] > secondLargest && arr[i] < firstLargest) {
				secondLargest = arr[i];
			}
		}
		System.out.println("Second largest element= " + secondLargest);
	}
}
