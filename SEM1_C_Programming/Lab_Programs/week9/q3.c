#include <stdio.h>
#include <string.h> // For strlen function

void countVowelsAndConsonants(char str[], int *vowelCount, int *consonantCount) {
    *vowelCount = 0;      // Initialize vowel counter
    *consonantCount = 0;  // Initialize consonant counter

    for (int i = 0; str[i] != '\0'; i++) {
        char ch = str[i];

        // Convert uppercase letters to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = ch + ('a' - 'A'); // Convert to lowercase
        }

        // Check if the character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            (*vowelCount)++;
        }
        // Check if the character is a consonant (letters excluding vowels)
        else if (ch >= 'a' && ch <= 'z') {
            (*consonantCount)++;
        }
    }
}

int main() {
    char str[100];
    int vowels, consonants;

    // Accept input from the user
    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    // Remove the newline character from fgets if present
    size_t len = strlen(str);
    if (str[len - 1] == '\n') {
        str[len - 1] = '\0';
    }

    // Call function to count vowels and consonants
    countVowelsAndConsonants(str, &vowels, &consonants);

    // Display the result
    printf("Number of vowels: %d\n", vowels);
    printf("Number of consonants: %d\n", consonants);

    return 0;
}
