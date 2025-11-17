#include <stdio.h>
#include <string.h>

struct Student {
    int roll_no;
    char name[50];
    float marks[5];
};

int main() {
    int n;
    printf("Enter number of students: ");
    scanf("%d", &n);

    struct Student students[n];

    // Input student details
    for (int i = 0; i < n; i++) {
        printf("Enter details for Student %d:\n", i + 1);
        printf("Roll No: ");
        scanf("%d", &students[i].roll_no);

        printf("Name: ");
        scanf("%s", students[i].name);  // Use %s for single-word names

        printf("Marks: ");
        for (int j = 0; j < 5; j++) {
            scanf("%f", &students[i].marks[j]);
        }
    }

    // Display students with average > 75
    printf("Students scoring above 75%%:\n");
    for (int i = 0; i < n; i++) {
        float total = 0;
        for (int j = 0; j < 5; j++) {
            total += students[i].marks[j];
        }
        float average = total / 5;

        if (average > 75.0) {
            printf("Roll No: %d\n", students[i].roll_no);
            printf("Name: %s\n", students[i].name);
            printf("Average Marks: %.2f\n", average);
        }
    }

    return 0;
}
