//Write a program to find out the max from given number 
//(E.g., No: -1562 Max number is 6)
#include <stdio.h>
main() {
        int num, large = 0, rem = 0;
        printf("Enter your input value:");
        scanf("%d", &num);
        while (num > 0) {
                rem = num % 10;
                if (rem > large) {
                        large = rem;
                }
                num = num / 10;
        }
        printf("Largest digit of the number is %d\n", large);
  }
