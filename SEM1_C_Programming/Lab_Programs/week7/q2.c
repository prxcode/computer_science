//Q2. Write a C program to find the sume of each row and each column of MxN matrix.

#include <stdio.h>

int main() {
    int i, j, m, n;
    
    printf("Enter number of rows and columns: ");
    scanf("%d %d", &m, &n);
    
    int matrix[m][n];
    
    printf("Enter elements of the matrix:\n");
    for(i = 0; i < m; i++) {
        for(j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
    
    printf("Row sums:\n");
    for(i = 0; i < m; i++) {
        int rowSum = 0;
        for(j = 0; j < n; j++) {
            rowSum += matrix[i][j];
        }
        printf("Sum of row %d: %d\n", i + 1, rowSum);
    }
    
    printf("Column sums:\n");
    for(j = 0; j < n; j++) {
        int colSum = 0;
        for(i = 0; i < m; i++) {
            colSum += matrix[i][j];
        }
        printf("Sum of column %d: %d\n", j + 1, colSum);
    }
    
    return 0;
}

