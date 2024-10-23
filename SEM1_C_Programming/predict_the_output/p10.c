#include<stdio.h> 
void main(){
    int a=0 || 1;  
    while(a=a+2, a<=5){
    printf("%d ",a);  
    }  
    printf("%d ", a); 
} 

//Output: 3 5 7