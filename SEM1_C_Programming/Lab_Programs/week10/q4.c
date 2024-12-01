#include <stdio.h>

void palindrome(char inputString[100]) {
    int leftIndex = 0, rightIndex, length = 0, flag = 1;
    
    // Find the length of the input string
    while (inputString[length] != '\0') {
        length++;  // Increment length to find the end of the string
    }
    
    rightIndex = length - 1;  // Set rightIndex to the last character of the string
    
    // Compare characters from left and right
    while (leftIndex < rightIndex) {
        if (inputString[leftIndex] != inputString[rightIndex]) {
            flag = 0;  // Set flag to 0 if characters don't match
            break;     // Exit the loop as it's not a palindrome
        }
        leftIndex++;      // Move leftIndex forward
        rightIndex--;     // Move rightIndex backward
    }
    
    // Check the flag and print the result
    if (flag == 1) {
        printf("%s is a palindrome\n", inputString);
    } else {
        printf("%s is not a palindrome\n", inputString);
    }
}

int main() {
    char inputString[100]; // Declare a string to store the input
    
    printf("Enter a string for palindrome check: ");
    scanf("%s", inputString);  // Input the string
    
    // Call the palindrome function to check
    palindrome(inputString);
    
    return 0;
}
