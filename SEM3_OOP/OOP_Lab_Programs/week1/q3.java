#include <stdio.h>
#include <string.h>

#define MAX_PATIENTS 100
#define MAX_NAME_LEN 100

// Define structure for Date
struct Date {
    int day;
    int month;
    int year;
};

// Define structure for Patient
struct Patient {
    int id;
    char name[MAX_NAME_LEN];
    char disease[MAX_NAME_LEN];
    struct Date admissionDate;
};

int main() {
    struct Patient patients[MAX_PATIENTS];
    int n, i;
    int searchMonth, searchYear;

    // Input number of patients
    printf("Enter number of patients: ");
    scanf("%d", &n);

    // Input details for each patient
    for(i = 0; i < n; i++) {
        printf("Patient %d:\n", i + 1);

        printf("ID: ");
        scanf("%d", &patients[i].id);

        // Clear input buffer before using fgets
        getchar(); // Consume newline left by scanf

        printf("Name: ");
        fgets(patients[i].name, MAX_NAME_LEN, stdin);
        patients[i].name[strcspn(patients[i].name, "\n")] = '\0'; // Remove newline

        printf("Disease: ");
        fgets(patients[i].disease, MAX_NAME_LEN, stdin);
        patients[i].disease[strcspn(patients[i].disease, "\n")] = '\0'; // Remove newline

        printf("Admission Date (dd mm yyyy): ");
        scanf("%d %d %d", 
              &patients[i].admissionDate.day, 
              &patients[i].admissionDate.month, 
              &patients[i].admissionDate.year);
    }

    // Input month and year to search
    printf("Enter month and year to search: ");
    scanf("%d %d", &searchMonth, &searchYear);

    // Display matching patients
    printf("Patients admitted in %02d/%d:\n", searchMonth, searchYear);
    int found = 0;
    for(i = 0; i < n; i++) {
        if(patients[i].admissionDate.month == searchMonth &&
           patients[i].admissionDate.year == searchYear) {
            printf("ID: %d, Name: %s, Disease: %s, Date: %02d-%02d-%04d\n",
                patients[i].id,
                patients[i].name,
                patients[i].disease,
                patients[i].admissionDate.day,
                patients[i].admissionDate.month,
                patients[i].admissionDate.year);
            found = 1;
        }
    }

    if(!found) {
        printf("No patients admitted in %02d/%d\n", searchMonth, searchYear);
    }

    return 0;
}
