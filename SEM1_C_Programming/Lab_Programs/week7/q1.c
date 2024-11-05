//Q1. Write a program to store the total salary of N employees to an array. For each employee calculate the total salary. 


#include <stdio.h>

int main() {
    int i, n;
    
    printf("Enter the total number of employees: ");
    scanf("%d", &n);
    
    float a[n][3], basicSalary, houseAllowance, allowance, totalSalary;
    
    for(i = 0; i < n; i++) {
        printf("Enter the basic salary for employee %d: ", i + 1);
        scanf("%f", &basicSalary);
        
        houseAllowance = basicSalary * 0.4;
        allowance = basicSalary * 0.25;
        totalSalary = basicSalary + houseAllowance + allowance;
        
        a[i][0] = basicSalary;
        a[i][1] = houseAllowance;
        a[i][2] = totalSalary;
    }
    
    printf("\nSalaries details of employees:\n");
    for(i = 0; i < n; i++) {
        printf("Employee %d - Basic: %.2f, House Allowance: %.2f, Total Salary: %.2f\n", i + 1, a[i][0], a[i][1], a[i][2]);
    }
    
    return 0;
}


