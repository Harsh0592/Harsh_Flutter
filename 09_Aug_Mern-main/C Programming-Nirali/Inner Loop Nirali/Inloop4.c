/*
****$
***$*
**$**
*$***
$****
*/
#include <stdio.h>

main() {
    int n = 5,i,j; // Number of lines
    for(i = 1; i <= n; i++) {
        for(j = 1; j <= n; j++) {
            if (j == n - i + 1) {
                printf("$");
            } else {
                printf("*");
            }
        }
        printf("\n");
    }
}
