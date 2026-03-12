import java.util.Scanner;

public class Main {

    // Linear Search function
    public static int linearSearch(float[] arr, float key) {
        int iterations = 0;
        for (int i = 0; i < arr.length; i++) {
            iterations++;
            System.out.println("LS checking index " + i + " value " + arr[i]);
            if (arr[i] == key) {
                System.out.println("Linear Search Iterations: " + iterations);
                return i;
            }
        }
        System.out.println("Linear Search Iterations: " + iterations);
        return -1;
    }

    // Binary Search function
    public static int binarySearch(float[] arr, float key) {
        int left = 0;
        int right = arr.length - 1;
        int iterations = 0;

        while (left <= right) {
            iterations++;
            int mid = (left + right) / 2;
            System.out.println("BS checking index " + mid + " value " + arr[mid]);

            if (arr[mid] == key) {
                System.out.println("Binary Search Iterations: " + iterations);
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Binary Search Iterations: " + iterations);
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize array of 10000 consecutive floats
        int size = 10000;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;  // ascending order
        }

        System.out.print("Enter the search key: ");
        float key = sc.nextFloat();

        // Linear Search
        long startLS = System.nanoTime();
        int posLS = linearSearch(arr, key);
        long endLS = System.nanoTime();
        System.out.println("Linear Search Position: " + posLS);
        System.out.println("Linear Search Time (microseconds): " + (endLS - startLS) / 1000);

        // Binary Search
        long startBS = System.nanoTime();
        int posBS = binarySearch(arr, key);
        long endBS = System.nanoTime();
        System.out.println("Binary Search Position: " + posBS);
        System.out.println("Binary Search Time (microseconds): " + (endBS - startBS) / 1000);

        sc.close();
    }
}
