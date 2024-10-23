#include <stdio.h> 
int main() 
{ 
    int x=358, y=3;
    int z = x%10 + x/10%10 - x/100%10; 
    printf("%d", z); 
    return 0; 
}

//Output: 10