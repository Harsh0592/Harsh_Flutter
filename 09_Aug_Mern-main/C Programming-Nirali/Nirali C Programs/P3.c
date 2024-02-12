/**
 * C program to check positive negative or zero using simple if statement
 */

#include <stdio.h>

int main()
{
    int a;
    printf("Enter any number: ");
    scanf("%d", &a);
    

    if(a > 0)
    {
        printf("Number is POSITIVE");
    }
    if(a < 0)
    {
        printf("Number is NEGATIVE");
    }
    if(a == 0)
    {
        printf("Number is ZERO");
    }

    return 0;
}
