/*Reverse a user input integer number using recursion. 
Eg. Enter a number = 123 
Output: Reverse of number = 321 */


#include <stdio.h>

int reverseNumber(int num) {
    // Base case: if the number is 0, return 0
    if (num == 0) {
        return 0;
    }
    // Recursive case: take the last digit and append it to the reversed number
    printf("%d", num % 10);  // Print the last digit
    return reverseNumber(num / 10);  // Call the function with the remaining number
}

int main() {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);
    
    printf("Reverse of number = ");
    reverseNumber(number);
    printf("\n");

    return 0;
}
