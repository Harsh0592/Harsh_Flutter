//WAP to print number in reverse order e.g.: number = 64728 ---> reverse = 82746
#include<stdio.h>  
main()    
{    
int n, reverse=0, rem;    
printf("Enter a number: ");    
  scanf("%d", &n);    
  while(n!=0)    
  {    
     rem=n%10;    
     reverse=reverse*10+rem;    
     n/=10;    
  }    
  printf("Reversed Number: %d",reverse);  
}   
