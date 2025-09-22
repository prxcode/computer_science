public class SecondLargestElement {
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found.");
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int[] numbers = {10, 5, 20, 8, 15};
        int secondLargest = findSecondLargest(numbers);
        System.out.println("The second-largest element is: " + secondLargest);
    }
}
