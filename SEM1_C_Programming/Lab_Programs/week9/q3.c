#include <stdio.h>
#include <ctype.h>

int main() {
    // Declare a character array to store the input string
    char s[100];
    int vowel = 0, consonant = 0;

    // Get input string from the user
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);

    // Loop through the string and count vowels and consonants
    for (int i = 0; s[i] != '\0'; i++) {
        // Convert the character to lowercase for easier comparison
        char ch = tolower(s[i]);

        // Check if the character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            vowel++;
        }
        // Check if the character is a consonant (alphabetic character but not a vowel)
        else if (ch >= 'a' && ch <= 'z') {
            consonant++;
        }
    }

    // Output the count of vowels and consonants
    printf("Vowels: %d\n", vowel);
    printf("Consonants: %d\n", consonant);

    return 0;
}

