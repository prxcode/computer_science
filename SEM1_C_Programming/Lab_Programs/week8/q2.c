#include <stdio.h>


void factor(int n) {
    int i, j;
    for (i = 1; i <= n; i++) {
        printf("Factors of %d: ", i); 
        for (j = 1; j <= i; j++) {   
            if (i % j == 0) {         
                printf("%d ", j);
            }
        }
        printf("\n");
    }
}

int main() {
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    factor(n);

    return 0;
}

