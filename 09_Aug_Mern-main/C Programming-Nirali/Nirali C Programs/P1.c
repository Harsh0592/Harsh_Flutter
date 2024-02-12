/**
 * C program to find maximum between two numbers
 */

#include <stdio.h>

int main()
{
    int a,b;

    
    printf("Enter two numbers: ");
    scanf("%d%d", &a, &b);

    if(a > b)
    {
        printf("%d is maximum", a);        
    }

    if(a > b)
    {
        printf("%d is maximum", b);
    }

    
    if(a == b)
    {
        printf("Both are equal");
    }

    return 0;
}
