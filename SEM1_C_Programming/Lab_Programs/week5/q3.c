#include <stdio.h>

int main() {
    int c = 0, n, i, j;
    printf("Enter a number: ");
    scanf("%d", &n);

    for(i = 2; i <= n / 2; i++) {
        if(n % i == 0) {
            c = 1;
            break;
        }
    }

    if(c == 0 && n > 1) {
        printf("Prime number: %d\n", n);
    } else {
        printf("Not a prime number: %d\n", n);
    }

    return 0;
}

