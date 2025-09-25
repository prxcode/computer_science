import java.util.Scanner;

public class ArrayAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();


        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] sum = new int[n];

        System.out.print("Enter elements for first array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter elements for second array:");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sum[i] = arr1[i] + arr2[i];
        }


        System.out.println("Sum of arrays:");
        for (int i = 0; i < n; i++) {
            System.out.print(sum[i] + " ");
        }

        sc.close();
    }
}
