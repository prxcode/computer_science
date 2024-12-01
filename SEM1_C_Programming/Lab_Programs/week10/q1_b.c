#include<stdio.h>  

// <Write a C program to demonstrate "Call by Reference". In "Call by Reference", the address of the actual parameter is passed into the function, allowing the function to modify the value at that address.>

int main() {    
    int x = 100; // Initialize x with 100
    
    // Function prototype
    void change(int *num);     
    
    // Print value before function call
    printf("Before function call x = %d \n", x);    
    
    // Pass the reference (address of x) to the change function
    change(&x); 
    
    // Print value after function call (x should be modified)
    printf("After function call x = %d \n", x);    

    return 0;  
}    

// Function to modify the value at the passed address
void change(int *num) {    
    printf("Before adding value inside function num = %d \n", *num);    
    (*num) += 100; // Modify the value at the address
    printf("After adding value inside function num = %d \n", *num);    
}
