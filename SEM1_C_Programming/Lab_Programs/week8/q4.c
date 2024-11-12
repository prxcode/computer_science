//Write a C program to print no. of digits in a number using recurssion Eg: 123 = 3digits

#include <stdio.h>

// Function to count digits using recursion
int countDigits(int n) {
    // Base case: if the number is 0, return 0
    if (n == 0) {
        return 0;
    }
    // Recursive case: 1 + count of digits in the number after removing the last digit
    return 1 + countDigits(n / 10);
}

int main() {
    int number;

    // Ask user for input
    printf("Enter a number: ");
    scanf("%d", &number);

    // Handle the case for 0 separately, as it has exactly 1 digit
    if (number == 0) {
        printf("The number 0 has 1 digit.\n");
    } else {
        printf("The number %d has %d digits.\n", number, countDigits(number));
    }

    return 0;
}

