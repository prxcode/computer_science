#include <stdio.h>
#include <string.h>

int main() {
    // Declare character arrays to store the first, middle, and last names
    char first[20], middle[20], last[20];

    // Prompt the user to input their first name, middle name, and last name
    printf("Enter first name: ");
    fgets(first, sizeof(first), stdin);
    // Remove trailing newline character from first name if any
    first[strcspn(first, "\n")] = '\0';

    printf("Enter middle name: ");
    fgets(middle, sizeof(middle), stdin);
    // Remove trailing newline character from middle name if any
    middle[strcspn(middle, "\n")] = '\0';

    printf("Enter last name: ");
    fgets(last, sizeof(last), stdin);
    // Remove trailing newline character from last name if any
    last[strcspn(last, "\n")] = '\0';

    // Concatenate the names
    strcat(first, " ");  // Add a space between first and middle name
    strcat(first, middle);
    strcat(first, " ");  // Add a space between middle and last name
    strcat(first, last);

    // Print the full name
    printf("Full name: %s\n", first);

    return 0;
}

