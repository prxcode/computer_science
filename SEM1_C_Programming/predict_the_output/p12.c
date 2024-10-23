#include <stdio.h> 
int main(){
    int i; 
    for (i = 12; i > 0; i--){
        if (i == 9 || i == 7) continue; 
    else if (i==5) 
    break; 
    else{
        printf("%d ", i); 
        i--; 
        } 
    } 
return 0; 
} 


//Ouput: 12 10 8 6 4 2 