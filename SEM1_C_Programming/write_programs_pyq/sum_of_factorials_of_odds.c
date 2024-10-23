/*Write a program to pass an array to a function that prints the sum of the factorial of 
odd numbers in the array. 
Eg. 
Enter size of the array: 5 
Enter the elements: 3 4 6 7 8 
Factorial of odd no 3 is 6 
Factorial of odd no 7 is 5040 
Sum of factorial of odd elements in array =5046*/

#include <stdio.h>

// Function to calculate the factorial of a number
long long factorial(int num) {
    long long result = 1;
    for (int i = 1; i <= num; i++) {
        result *= i;
    }
    return result;
}

// Function to calculate and print the sum of the factorials of odd numbers
void sumOfOddFactorials(int arr[], int size) {
    long long sum = 0;

    for (int i = 0; i < size; i++) {
        if (arr[i] % 2 != 0) { // Check if the number is odd
            long long fact = factorial(arr[i]);
            printf("Factorial of odd no %d is %lld\n", arr[i], fact);
            sum += fact; // Add factorial to sum
        }
    }
    printf("Sum of factorial of odd elements in array = %lld\n", sum);
}

int main() {
    int size;

    // Prompt user for the size of the array
    printf("Enter size of the array: ");
    scanf("%d", &size);

    int arr[size]; // Declare the array

    // Prompt user for the elements of the array
    printf("Enter the elements: ");
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    // Call the function to calculate and print the sum of odd factorials
    sumOfOddFactorials(arr, size);

    return 0;
}
