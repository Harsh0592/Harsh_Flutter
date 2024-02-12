#include<stdio.h>
main(){
	int arr[10],i,arr5[10],a=0,arr10[10],b=0,arr2[10],c=0;
	for(i=0;i<10;i++){
		printf("Enete the values : ");
		scanf("%d",&arr[i]);
		if(arr[i]%2==0){
			arr2[c]=arr[i];
			c++;
		}if(arr[i]%5==0){
			arr5[a]=arr[i];
			a++;
		}if(arr[i]%10==0){
			arr10[b]=arr[i];
			b++;
		}
	}
	printf("\nThe Normal Array : \n");
	for(i=0;i<10;i++){
		printf("%d \t",arr[i]);
	}
	printf("\nValu of Div 2 : \n");
	for(i=0;i<c;i++){
		printf("%d \t",arr2[i]);
	}
	printf("\nValu of Div 5 : \n");
	for(i=0;i<a;i++){
		printf("%d \t",arr5[i]);
	}
	printf("\nValu of Div 10 : \n");
	for(i=0;i<b;i++){
		printf("%d \t",arr10[i]);
	}
}
