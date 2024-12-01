#include<stdio.h>  

// <Write a C program to demonstrate "Call by Value". In "Call by Value", the value of the actual parameter is copied to the formal parameter, and any modification inside the function does not affect the original variable.>

void change(int num); // Function prototype

void main() {    
    int x = 100; // Initialize x with 100
    
    // Print value before function call
    printf("Before function call x = %d \n", x);    
    
    // Pass value of x to change function
    change(x);    
    
    // Print value after function call (x should remain unchanged)
    printf("After function call x = %d \n", x);    
}    

// Function to modify the passed value (does not affect original x)
void change(int num) {    
    printf("Before adding value inside function num = %d \n", num);    
    num = num + 100; // Modify num inside function (local copy)
    printf("After adding value inside function num = %d \n", num);    
}
