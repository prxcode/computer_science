/*Write a C Program to print Floyd’s Triangle (Number Pattern) 
 
Test case: 
Enter the number of rows: 4 
1 
2 3 
4 5 6 
7 8 9 10
*/
/*
#include <stdio.h>
int main(){
printf("1\n");
printf("2 3\n");
printf("4 5 6\n");
printf("7 8 9 10\n");
return 0;
}
*/

#include <stdio.h>
int main() {
    int num = 1; // Starting number

    for (int i = 1; i <= 4; i++) { // 4 rows
        for (int j = 1; j <= i; j++) { // Print numbers in the current row
            printf("%d ", num);
            num++; // Increment number
        }
        printf("\n"); // New line after each row
    }

    return 0;
}


//Output: 

/*1 
2 3 
4 5 6 
7 8 9 10
*/
