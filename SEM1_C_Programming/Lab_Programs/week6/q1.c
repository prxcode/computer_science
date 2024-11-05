#include <stdio.h>

int main() {
    int marks[5], total = 0;
    float p;
    char grade;

    for (int i = 0; i < 5; i++) {
       printf("\n Enter marks: ");
	scanf("%d", &marks[i]);
        total += marks[i];
    }

    p = total / 5.0; // Ensure that division is done as a float
    if (p >= 90) grade = 'A';
    else if (p >= 80) grade = 'B';
    else if (p >= 70) grade = 'C';
    else if (p >= 60) grade = 'D';
    else if (p >= 40) grade = 'E';
    else grade = 'F';

    printf("Total: %d\nPercentage: %.2f\nGrade: %c\n", total, p, grade);

    return 0;
}

