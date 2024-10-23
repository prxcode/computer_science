/* It’s a square matrix 
 Enter 16 elements2 1 3 2 2 1 4 5 1 0 2 0 5 3 1 2 
 Sum of elements above the main diagonal =12 (1+3+2+4+5+0) 
 Sum of elements below the main diagonal =15 (2+1+0+5+3+1) 
 Sum of elements below the main diagonal is bigger */

 #include <stdio.h>

int main() {
    int M, N;

    // Get dimensions of the matrix
    printf("Enter number of rows: ");
    scanf("%d", &M);
    printf("Enter number of columns: ");
    scanf("%d", &N);

    // Check if the matrix is square
    if (M != N) {
        printf("It's not a square matrix.\n");
        return 0; // Exit the program
    } else {
        printf("It's a square matrix.\n");
    }

    // Declare the square matrix
    int matrix[M][N];
    int sumAbove = 0, sumBelow = 0;

    // Get elements of the matrix from the user
    printf("Enter %d elements:\n", M * N);
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    // Calculate sums above and below the main diagonal
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (i < j) {  // Above the main diagonal
                sumAbove += matrix[i][j];
            } else if (i > j) {  // Below the main diagonal
                sumBelow += matrix[i][j];
            }
        }
    }

    // Print the sums
    printf("Sum of elements above the main diagonal = %d\n", sumAbove);
    printf("Sum of elements below the main diagonal = %d\n", sumBelow);

    // Compare sums and print the result
    if (sumAbove > sumBelow) {
        printf("Sum of elements above the main diagonal is bigger.\n");
    } else if (sumBelow > sumAbove) {
        printf("Sum of elements below the main diagonal is bigger.\n");
    } else {
        printf("Both sums are equal.\n");
    }

    return 0;  // Indicate successful termination
}
