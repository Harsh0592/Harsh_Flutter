//WAP to find number is even or odd using ternary operator
#include<stdio.h>
main(){
	int a;
	printf("Enetr The Number : ");
	scanf("%d",&a);
	(a%2==0)?printf("The Number (%d) is Even Number",a):
	printf("The Number (%d) is Odd Number",a);
}
