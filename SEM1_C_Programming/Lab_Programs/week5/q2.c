#include <stdio.h>

int main() {
    int i, j, marks, sum;
    float avg;

    for(i = 1; i <= 3; i++) { 
        printf("\n");
        sum = 0; 
        avg = 0.0; 

        for(j = 1; j <= 5; j++) { 
            printf("Enter Marks for subject %d: ", j);
            scanf("%d", &marks);
            sum = sum + marks;
        }

        avg = sum / 5.0;
        printf("Average Marks for student %d: %.2f\n", i, avg);
    }

    return 0;
}

