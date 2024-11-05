// Write a c program to read two marks lists of equal size (10 size) and check whether they are identical or not.

#include <stdio.h>

int main() {
    int marks1[10], marks2[10], identical = 1;

    printf("Enter 10 marks for the first list:\n");
    for (int i = 0; i < 10; i++) {
        scanf("%d", &marks1[i]);
    }
    
    printf("Enter 10 marks for the second list:\n");
    for (int i = 0; i < 10; i++) {
        scanf("%d", &marks2[i]);
    }

    for (int i = 0; i < 10; i++) {
        if (marks1[i] != marks2[i]) {
            identical = 0; // Not identical
            break;
        }
    }

    if (identical) {
        printf("The two marks lists are identical.\n");
    } else {
        printf("The two marks lists are not identical.\n");
    }

    return 0;
}
