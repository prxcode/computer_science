/*Write a program to create a structure employee with the structure members: 
Name: String;  
Basic salary, house & rental allowance, special allowance, total salary: float. 
Use malloc function to assign memory, also print msg if memory is not assigned. 
Input details of N employee. Where N is a user input value. Calculate the total salary 
of each employee. 
total salary= basic salary+ house & rental allowance+ special allowance 
house & rental allowance= 40% of basic salary 
special allowance= 20% of basic salary 
Find the employee with the highest salary and print his/her details. 
Eg. 
Enter #employee :3 
Enter 1st Employee name : Shiv 
Enter 1st Employee basic salary : 5000 
1st Employee Total salary = 8000.000000 
  
Enter 2nd Employee name : Vishnu  
Enter 2nd Employee basic salary : 3000 
2nd Employee Total salary = 4800.000000 
  
Enter 3rd Employee name : Krishna 
Enter 3rd Employee basic salary : 9000 
3rd Employee Total salary = 14400.000000 
DETAILS OF EMPLOYEE WITH THE HIGHEST SALARY 
Name : Krishna 
Basic : 9000.000000 
HRA : 3600.000000 
Special allowance: 1800.000000 
TOTAL Salary 14400.000000 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NAME_LENGTH 50 // Maximum length for the employee name

// Structure to represent an employee
struct Employee {
    char name[NAME_LENGTH];
    float basic_salary;
    float house_rent_allowance;
    float special_allowance;
    float total_salary;
};

// Function to calculate allowances and total salary
void calculate_salary(struct Employee *emp) {
    emp->house_rent_allowance = 0.4 * emp->basic_salary; // 40% of basic salary
    emp->special_allowance = 0.2 * emp->basic_salary;   // 20% of basic salary
    emp->total_salary = emp->basic_salary + emp->house_rent_allowance + emp->special_allowance;
}

int main() {
    int N;
    
    // Prompt user for the number of employees
    printf("Enter #employees: ");
    scanf("%d", &N);
    
    // Dynamically allocate memory for N employees
    struct Employee *employees = (struct Employee *)malloc(N * sizeof(struct Employee));
    if (employees == NULL) {
        printf("Memory not allocated!\n");
        return 1; // Exit if memory allocation fails
    }

    // Input details of each employee
    for (int i = 0; i < N; i++) {
        printf("Enter %dth Employee name: ", i + 1);
        scanf("%s", employees[i].name);
        printf("Enter %dth Employee basic salary: ", i + 1);
        scanf("%f", &employees[i].basic_salary);

        // Calculate salary details
        calculate_salary(&employees[i]);
        printf("%dth Employee Total salary = %.6f\n\n", i + 1, employees[i].total_salary);
    }

    // Find the employee with the highest salary
    struct Employee *highest_paid = &employees[0];
    for (int i = 1; i < N; i++) {
        if (employees[i].total_salary > highest_paid->total_salary) {
            highest_paid = &employees[i];
        }
    }

    // Print details of the employee with the highest salary
    printf("DETAILS OF EMPLOYEE WITH THE HIGHEST SALARY\n");
    printf("Name: %s\n", highest_paid->name);
    printf("Basic: %.6f\n", highest_paid->basic_salary);
    printf("HRA: %.6f\n", highest_paid->house_rent_allowance);
    printf("Special allowance: %.6f\n", highest_paid->special_allowance);
    printf("TOTAL Salary: %.6f\n", highest_paid->total_salary);

    // Free allocated memory
    free(employees);

    return 0;
}
