#include<stdio.h> 
int main(){
    int date=10; 
    if(date!=10) 
        printf("today "); 
        printf("is "); 
    else 
        printf("good "); 
        printf("luck "); 
return 0; 
} 


//Output: Error message


/*Corrected CODE

#include <stdio.h> 

int main() {
    int date = 10; 
    if (date != 10) { 
        printf("today "); 
    } else { 
        printf("good "); 
    }
    printf("luck "); 
    return 0; 
}

*/