//Pointer in C language 
#include <stdio.h>
int main() {
  int a = 5;
  int b = 20;
  int *ptr1;
  int *ptr2;
  
  ptr1 = &a;
  ptr2 = &b;

  printf("\nAdd of a=%u", ptr1);     // Prints address of a
  printf("\nAdd of b=%u", ptr2);     // Prints address of b
  printf("\nValue of a=%d, *ptr1", *ptr1); // Prints value of a through ptr1
  printf("\nValue of b=%d, *ptr2", *ptr2); // Prints value of b through ptr2
  printf("\nptr2-ptr1=%d", ptr2 - ptr1);  // Prints difference in memory locations

  return 0;
}
