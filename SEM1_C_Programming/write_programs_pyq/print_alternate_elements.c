/*Write a C Program to print alternate elements of an array. Assume the array elements 
are 10,20,30,40,50,60,70,80,90,100.   
Output:  
Alternate elements of array:  
arr[0] is: 10 
arr[2] is: 30 
arr[4] is: 50 
arr[6] is: 70 
arr[8] is: 90*/

#include <stdio.h>

int main() {
    // Initialize the array with the given elements
    int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int size = sizeof(arr) / sizeof(arr[0]); // Calculate the size of the array

    printf("Alternate elements of array:\n");

    // Loop through the array and print alternate elements
    for (int i = 0; i < size; i += 2) {
        printf("arr[%d] is: %d\n", i, arr[i]);
    }

    return 0;
}
