/*Write a C program to convert n bit user input octal number to binary. 
 
Required output: 
Enter the no of bits :4 
Enter 4 bits octal number : 1 5 3 6 
Decimal equivalent = 862*/

#include <stdio.h>

int main() {
    int n;

    // Get the number of bits (octal digits)
    printf("Enter the number of bits: ");
    scanf("%d", &n);

    // Declare an array to hold octal digits
    int octal[n];
    int decimal = 0;

    // Get the octal number from the user
    printf("Enter %d bits octal number: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &octal[i]);

        // Validate that each digit is between 0 and 7
        if (octal[i] < 0 || octal[i] > 7) {
            printf("Invalid octal digit: %d. Please enter digits between 0 and 7.\n", octal[i]);
            return 1;  // Exit with an error code
        }

        // Convert octal to decimal
        decimal = decimal * 8 + octal[i];
    }

    // Print the decimal equivalent
    printf("Decimal equivalent = %d\n", decimal);

    // Convert decimal to binary and print
    printf("Binary equivalent = ");
    for (int i = sizeof(decimal) * 8 - 1; i >= 0; i--) {
        int binaryBit = (decimal >> i) & 1;  // Get the i-th bit
        printf("%d", binaryBit);
    }
    printf("\n");

    return 0;  // Indicate successful termination
}
