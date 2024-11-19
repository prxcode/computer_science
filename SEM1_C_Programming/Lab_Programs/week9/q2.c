#include <stdio.h>
#include <string.h>

int main() {
    // Declare two character arrays to store the input strings
    char S1[100], S2[100];

    // Get input strings from the user
    printf("Enter first string: ");
    fgets(S1, sizeof(S1), stdin);
    // Remove newline character if present
    S1[strcspn(S1, "\n")] = '\0';

    printf("Enter second string: ");
    fgets(S2, sizeof(S2), stdin);
    // Remove newline character if present
    S2[strcspn(S2, "\n")] = '\0';

    // Compare the two strings using strcmp
    int difference = strcmp(S1, S2);

    // Check the result of the comparison
    if (difference == 0) {
        printf("Strings are same.\n");
    } else if (difference > 0) {
        printf("S1 is bigger than S2.\n");
    } else {
        printf("S2 is bigger than S1.\n");
    }

    return 0;
}

