//WAP to find the sum of all elements in an integer array.
#include <stdio.h>

int main() {
    int arr[10]; // Declare an array of size 10
    int sum = 0; // Variable to store the sum

    // Read elements into the array
    printf("Enter 10 integers:\n");
    for (int i = 0; i < 10; i++) {
        scanf("%d", &arr[i]);
    }

    // Calculate the sum of the elements
    for (int i = 0; i < 10; i++) {
        sum += arr[i]; // Add each element to the sum
    }

    // Print the result
    printf("The sum of all elements is: %d\n", sum);

    return 0;
}

