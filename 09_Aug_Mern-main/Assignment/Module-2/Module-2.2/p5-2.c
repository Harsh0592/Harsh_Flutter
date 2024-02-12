/*Looping programs:
2. WAP to take 10 no. Input from user and find out …
How many Even numbers are there
How many odd numbers are there
Sum of even numbers
Sum of odd numbers*/
#include<stdio.h>
main(){
	int i,even=0,odd=0,even_total,odd_total,arr[10];
	for(i=1;i<=10;i++){
			printf("Enter the value : ");
			scanf("%d",&arr[i]);}
		for(i=1;i<=10;i++){
			if(arr[i]%2==0)
			{
				even++;
				even_total+=arr[i];
				printf("\t \t \t The Even Number is : %d \n",arr[i]);
			}
		}for(i=1;i<=10;i++){
			if(arr[i]%2!=0){
				odd++;
				odd_total+=arr[i];
				printf("The Odd Number is : %d \n",arr[i]);
			}	
	}
	printf("The Total of even Numbers is %d \n",even_total);
	printf("The Total of odd Numbers is %d \n",odd_total);
	printf("You got this much of even Numbers %d \n",even);
	printf("You got this much of odd Numbers %d \n",odd);
}
