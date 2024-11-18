#include <stdio.h>
int main(){
    char s1[50],s2[50],ch;
    int i=0, count=0,j;
    printf("Enter the first string: ");
    gets(s1);
    printf("Enter the second string: ");
    gets(s2);
    while(s1[i]!='\n')
    {
            count++;
        i++;
    }
    printf("Count: %d\n", count);
    for(j=0, i=count; s2[j]!='\0';i++,j++);
    {
        s1[i]=s2[j];
    }
    puts(s1);
    puts(s2);
    return 0;
}