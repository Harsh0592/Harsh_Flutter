#include<stdio.h>
main(){
	int arr[10],i,arr2[10],a=0,arr5[10],b=0,arr10[10],c=0;
	for(i=0;i<10;i++){
		printf("Enter the values : ");
		scanf("%d",&arr[i]);
	}
		printf("\nthe values of 2 : \n");
	for(i=0;i<10;i++){
		if(arr[i]%2==0){
			arr[a]=arr[i];
			printf("%d\t",arr[a]);
		}}printf("\nthe values of 5 : \n");
		for(i=0;i<10;i++){
		if(arr[i]%5==0){
			arr[b]=arr[i];
			printf("%d\t",arr[b]);
		}}printf("\nthe values of 10 : \n");
		for(i=0;i<10;i++){
		if(arr[i]%10==0){
			arr[c]=arr[i];
			printf("%d\t",arr[c]);
		}
	}	
}
