//Write a program to find out the max number from given array using function
#include <stdio.h>
int findMax(int arr[], int size) {
    int max = arr[0];
    int i;
    for(i = 1; i < size; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    return max;
}

int main() {
    int arr[] = {5, 2, 9, 1, 5, 6};
    int size = sizeof(arr) / sizeof(arr[0]);
    int max = findMax(arr, size);
	printf("%d %d %d %d %d\n",arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
    printf("The maximum number in the array is: %d\n", max);

    return 0;
}
  
