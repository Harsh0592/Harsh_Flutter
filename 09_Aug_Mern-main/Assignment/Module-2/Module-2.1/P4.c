//WAP to find simple interest
#include<stdio.h>
int main()
{
int p,r,t,si;
printf("Input principle, Rate of interest & time to find simple interest: \n");
scanf("%d %d %d",&p,&r,&t);
si=(p*r*t)/100;
printf("\nSimple interest = %d",si);
return 0;
}
