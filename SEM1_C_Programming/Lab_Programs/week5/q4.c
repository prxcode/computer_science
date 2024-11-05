#include <stdio.h>

int main() {
    int i, j, n;
    printf("Enter a number: ");
    scanf("%d", &n);

    for(i = 1; i <= n; i++) {
        printf("Factors of %d: ", i);
        for(j = 1; j <= i; j++) {
            if(i % j == 0) {
                printf("%d ", j);
            }
        }
        printf("\n");
    }

    return 0;
}

