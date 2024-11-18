

#include <stdio.h>

int main() {
    char s[50];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);  // Read input safely
    
    // Print the string
    printf("You entered: %s", s);
    
    return 0;
}
