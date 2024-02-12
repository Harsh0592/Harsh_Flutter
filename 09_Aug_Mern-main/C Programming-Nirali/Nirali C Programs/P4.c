/**
 * C program to check divisibility of any number
 */

#include <stdio.h>

int main()
{
    int num;

    
    printf("Enter any number: ");
    scanf("%d", &num);
    if((num % 3 == 0) && (num % 5 == 0)
    {
        printf("Number is divisible by 3 and 5");
    }
    else
    {
        printf("Number is not divisible by 3 and 5");
    }

    return 0;
}
