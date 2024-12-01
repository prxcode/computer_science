#include <stdio.h>

// Function prototype to calculate the sum
float calculateSum(float num[], int size);

int main() 
{
    float result;
    int size;

    // Take user input for the array size and elements
    printf("Enter the number of elements in the array: ");
    scanf("%d", &size);
    
    float num[size];  // Declare the array with the specified size

    printf("Enter the elements of the array: ");
    for (int i = 0; i < size; i++) {
        scanf("%f", &num[i]);  // Take input for each element
    }

    // Pass the array to calculateSum() function
    result = calculateSum(num, size); 
    
    printf("Result = %.2f\n", result);
    
    return 0;
}

// Function to calculate the sum of elements in the array
float calculateSum(float num[], int size) {
    float sum = 0.0;

    // Calculate the sum of all elements
    for (int i = 0; i < size; ++i) {
        sum += num[i];
    }

    return sum;  // Return the sum
}
