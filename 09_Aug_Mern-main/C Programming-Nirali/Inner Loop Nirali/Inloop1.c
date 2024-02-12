/*a
  ab
  abc
  abcd
  abcde*/
#include <stdio.h>
main() {
    int rows,i,j;

    printf("Enter the alphabet of rows: ");
    scanf("%d", &rows);

    for(i = 1; i <= rows; i++) {
        char ch = 'a';
        for(j = 1; j <= i; j++) {
            printf("%c ", ch++);
        }
        printf("\n");
    }
}
