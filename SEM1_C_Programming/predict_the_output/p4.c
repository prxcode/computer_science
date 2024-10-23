#include <stdio.h> 
int main(){
    int x=10, y=5, z=3; 
    int res = x+y*z>25 ? ( x<y? x+y : x-y ) : ( y>z ? z*z : y*y ); 
    printf("%d",res); 
    return 0; 
} 

//Output: 9