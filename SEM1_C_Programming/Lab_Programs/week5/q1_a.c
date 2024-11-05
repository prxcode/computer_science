#include <stdio.h>

int main() {
    int size;
    printf("Enter the pattern size: ");
    scanf("%d", &size);
    
    for (int i = 1; i <= size; i++) {
        for (int j = 1; j <= i; j++) {
            if (j == 1) {
                printf("%d", i);
            } else {
                printf(" %d", i);
            }
        }
        printf("\n");
    }
    return 0;
}

