
import java.util.Scanner;

public class P1 {

public static void main(String args[]) {

Scanner sc = new Scanner(System.in);

"); System.out.print("Enter number of elements =

int n = sc.nextInt();

System.out.print("Enter " + n + " elements = "); int[] a = new int[n];

for (int i = 0; i < n; i++) { } a[i] = sc.nextInt();


if (n < 2) {

System.out.println("Cannot find second largest number. Array must have at least 2 elements.");

sc.close();

} return;



int firstLargest = Integer.MIN_VALUE;

int secondLargest = Integer.MIN_VALUE;


for (int i = 0; i < n; i++) {

if (a[i] > firstLargest) {

secondLargest = firstLargest;

firstLargest = a[i];

} else if (a[i] > secondLargest && a[i] <

firstLargest) {

secondLargest = a[i];

}

}

System.out.println("The second largest number is: " + secondLargest);

sc.close();

}

}
