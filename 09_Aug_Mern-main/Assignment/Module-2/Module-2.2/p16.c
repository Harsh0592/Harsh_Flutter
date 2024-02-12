/* *
   * *
   * * *
   * * * *
   * * * * *
   * * * * * *
   * * * * *
   * * * *
   * * *
   * *
   *           */
#include <stdio.h>

int main() {
    int i, j;
    // Print the top half of the pattern
    for (i = 1; i <= 6; i++) {
        for (j = 1; j <= i; j++) {
            printf("* ");
        }
        printf("\n");
    }
    // Print the bottom half of the pattern
    for (i = 6 - 1; i >= 1; i--) {
        for (j = 1; j <= i; j++) {
            printf("* ");
        }
        printf("\n");
    }
}

