// WAP to find the all the prime elements in an array.
#include <stdio.h>

// Function to check if a number is prime
int isPrime(int num) {
    if (num <= 1) return 0; // 0 and 1 are not prime numbers
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return 0; // Not prime if divisible
    }
    return 1; // Prime number
}

int main() {
    int arr[10]; // Declare an array of size 10
    int primeCount = 0; // Count of prime numbers

    // Read elements into the array
    printf("Enter 10 integers:\n");
    for (int i = 0; i < 10; i++) {
        scanf("%d", &arr[i]);
    }

    // Find and print prime numbers
    printf("Prime numbers in the array are: ");
    for (int i = 0; i < 10; i++) {
        if (isPrime(arr[i])) {
            printf("%d ", arr[i]);
            primeCount++;
        }
    }

    if (primeCount == 0) {
        printf("None");
    }
    
    printf("\n");
    return 0;
}

