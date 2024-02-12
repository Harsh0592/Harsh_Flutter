#include <stdio.h>
main() {
    int num[20],i,j,a;
    printf("Enter number of table :\n");
    scanf("%d",&a);
    for (i = 1; i <= a; i++) {
        printf("Enetr %d Number: ", i);
        scanf("%d", &num[i]);
    }
    for (i = 1; i <= a; i++) {
        printf("\nTable of %d:\n", num[i]);
        for (j = 1; j <= 10; j++){
            printf("%d x %d = %d\n", num[i], j, num[i] * j);
        }
    }
}
