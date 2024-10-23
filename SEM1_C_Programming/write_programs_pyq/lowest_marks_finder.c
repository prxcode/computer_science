//Finding the Lowest Marks Among Student Inputs in a Given Array

#include <stdio.h>

int main()  
{ 
    int i, n; 
    printf("\nEnter the no of students: "); 
    scanf("%d", &n); 

    int marks[n];  // a. Declare an array to hold the marks

    int lowest; 
    printf("\nEnter marks for %d students: ", n); 
    for(i = 0; i < n; i++) 
    { 
        scanf("%d", &marks[i]);  // b. Read marks for each student
    } 

    lowest = marks[0];  // c. Initialize lowest with the first student's marks

    for(i = 0; i < n; i++) 
    { 
        if(marks[i] < lowest)  // d. Check if the current mark is less than the lowest
            lowest = marks[i]; 
    } 

    printf("\nLowest marks is = %d", lowest); 
    return 0; 
}
