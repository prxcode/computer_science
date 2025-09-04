#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_WORDS 100
#define MAX_LENGTH 1000

int main() {
    char paragraph[MAX_LENGTH];
    char words[MAX_WORDS][50];
    int count[MAX_WORDS] = {0};
    int i, j, k, wordCount = 0;

    printf("Enter paragraph:\n");
    fgets(paragraph, MAX_LENGTH, stdin);

    // Convert to lowercase and remove punctuation
    for(i = 0; paragraph[i]; i++) {
        if (isalpha(paragraph[i]) || isspace(paragraph[i]))
            paragraph[i] = tolower(paragraph[i]);
        else
            paragraph[i] = ' ';
    }

    // Split into words
    char *word = strtok(paragraph, " ");
    while (word != NULL) {
        // Check if word already exists
        int found = 0;
        for (i = 0; i < wordCount; i++) {
            if (strcmp(words[i], word) == 0) {
                count[i]++;
                found = 1;
                break;
            }
        }

        // If new word
        if (!found) {
            strcpy(words[wordCount], word);
            count[wordCount] = 1;
            wordCount++;
        }

        word = strtok(NULL, " ");
    }

    // Print result
    printf("\nWord Frequencies:\n");
    for (i = 0; i < wordCount; i++) {
        printf("%s - %d\n", words[i], count[i]);
    }

    return 0;
}
