#include <stdio.h>

int main() {
    int i, j, m, n, key, found = 0;
    
    // Input matrix dimensions
    printf("Enter the number of rows and columns: ");
    scanf("%d %d", &m, &n);
    
    int matrix[m][n];
    
    // Input matrix elements
    printf("Enter the elements of the matrix:\n");
    for(i = 0; i < m; i++) {
        for(j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
    
    // Input key to search
    printf("Enter the key element to search for: ");
    scanf("%d", &key);
    
    // Perform linear search to find all occurrences
    for(i = 0; i < m; i++) {
        for(j = 0; j < n; j++) {
            if(matrix[i][j] == key) {
                printf("Found %d at position (%d, %d)\n", key, i, j);
                found = 1;
            }
        }
    }
    
    if(!found) {
        printf("Element %d not found in the matrix.\n", key);
    }

    return 0;
}

