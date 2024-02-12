#include <stdio.h>

int main()
{
    int a, b, c;

    /* Input three numbers from user */
    printf("Enter three numbers: ");
    scanf("%d%d%d", &a, &b, &c);
    

    if(a > b)
    {
        if(a > c)
        {
            printf("Maximum among all three numbers = %d", a);
        }
        else
        {
            printf("Maximum among all three numbers = %d", c);
        }
    }
    else
    {
        if(b > c)
        {
            printf("Maximum among all three numbers = %d", b);
        }
        else
        {
            printf("Maximum among all three numbers = %d", c);
        }
    }

    return 0;
}
