#include <stdio.h>

int main() {
    int size;
    printf("Enter the pattern size: ");
    scanf("%d", &size);
    
    for (int i = 1; i <= size; i++) {
        for (int j = i; j >= 1; j--) {
            if (j == i) {
                printf("%d", j);
            } else {
                printf(" %d", j);
            }
        }
        printf("\n");
    }
    return 0;
}

