#include <stdio.h>

// Function to sort the array using Selection Sort
void sort(int a[], int len) {
    int i, j, min_index, temp;
    
    // Loop over the array
    for (i = 0; i < len - 1; i++) {
        min_index = i;
        
        // Find the minimum element in the unsorted part of the array
        for (j = i + 1; j < len; j++) {
            if (a[j] < a[min_index]) {
                min_index = j;  // Update min_index if a smaller element is found
            }
        }

        // Swap the found minimum element with the element at index i
        temp = a[i];
        a[i] = a[min_index];
        a[min_index] = temp;
    }
}

int main() {
    int len;

    // Take the size of the array from the user
    printf("Enter the number of elements in the array: ");
    scanf("%d", &len);
    
    int a[len];  // Use a static array of size 'len'

    // Input the elements of the array
    printf("Enter the elements of the array: ");
    for (int i = 0; i < len; i++) {
        scanf("%d", &a[i]);
    }

    // Call the sort function to sort the array
    sort(a, len);

    // Print the sorted array
    printf("Sorted array: ");
    for (int i = 0; i < len; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
