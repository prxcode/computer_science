
//Write a c program to check the matrix is square else print invalid. If its a square matric print the sume of the main and opposite diagonal elements of the MxM Matrix. 

#include <stdio.h>

int main() {
    int i, j, m, n;
    printf("Enter the number of rows and columns: ");
    scanf("%d %d", &m, &n);
    
    if (m != n) {
        printf("Invalid\n");
        return 0;
    }
    
    int matrix[m][n];
    
    printf("Enter elements of the matrix:\n");
    for(i = 0; i < m; i++) {
        for(j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
    
    int mainDiagonalSum = 0, oppositeDiagonalSum = 0;
    
    for(i = 0; i < m; i++) {
        mainDiagonalSum += matrix[i][i];
        oppositeDiagonalSum += matrix[i][m - i - 1];
    }
    
    printf("Main diagonal sum: %d\n", mainDiagonalSum);
    printf("Opposite diagonal sum: %d\n", oppositeDiagonalSum);
    
    return 0;
}

