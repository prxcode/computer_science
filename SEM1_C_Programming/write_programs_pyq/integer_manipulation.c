/*Write a complete C program that accepts an integer from the user, adds 50 to it, and 
then multiplies the result with 100, and displays both the user input value and result. 
Use appropriate messages. 
Output: 
Enter a user integer: 5 
values are 5, 5500 */

#include <stdio.h>

int main() {
    int userInput;
    int result;

    // Prompt the user for input
    printf("Enter a user integer: ");
    scanf("%d", &userInput);

    // Perform the calculations
    result = (userInput + 50) * 100;

    // Display the results
    printf("Values are %d, %d\n", userInput, result);

    return 0;
}
