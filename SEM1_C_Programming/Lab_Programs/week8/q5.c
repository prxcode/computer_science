#include <stdio.h>

int Sum(int n) {
    if (n == 0)
        return 0;
    return (n % 10) + Sum(n / 10);
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    int result = Sum(num);
    printf("Sum of digits: %d\n", result);

    return 0;
}
