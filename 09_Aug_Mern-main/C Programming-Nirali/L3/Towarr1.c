#include<stdio.h>
main()
{
	int arr[3][3],arr1[3][3],i,j,arr2[3][3];
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("Enter the values[%d][%d] : ",i,j);
			scanf("%d",&arr[i][j]);
		}
	}
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("Enter the values for second[%d][%d] : ",i,j);
			scanf("%d",&arr1[i][j]);
		}
	}
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d",arr[i][j]);
		}
		printf("\n");
	}
	printf("\nSecond values \n");
	for(i=0;i< 3;i++){
		for(j=0;j<3;j++){
			printf("%d",arr1[i][j]);
		}
		printf("\n");
	}
		printf("\nSum of values \n");
	for(i=0;i< 3;i++){
		for(j=0;j<3;j++){
			arr2[i][j]=arr[i][j]+arr1[i][j];
			printf("%d",arr2[i][j]);
		}
		printf("\n");
	}
}
