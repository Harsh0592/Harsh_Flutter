#include<stdio.h>
main(){
	int a;
	printf("Enter the value : ");
	scanf("%d",&a);
	star(a);
}
int star(int a){
	int i,j;
	for(i=1;i<=a;i++){
		for(j=1;j<=i;j++){
			printf(" * ");
		}
		printf("\n");
	}
}
