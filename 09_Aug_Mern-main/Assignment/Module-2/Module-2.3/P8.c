//WAP to reverse a string and check that the string is palindrome or not
#include <stdio.h>
#include <string.h>
void reverseString(char *str) {
    int length = strlen(str);
    int start = 0;
    int end = length - 1;

    while (start < end) {
        // Swap characters at start and end positions
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;

        start++;
        end--;
    }
}

// Function to check if a string is a palindrome
int isPalindrome(char *str) {
    int length = strlen(str);
    int start = 0;
    int end = length - 1;

    while (start < end) {
        // If characters at start and end positions are different, it's not a palindrome
        if (str[start] != str[end]) {
            return 0; // Not a palindrome
        }

        start++;
        end--;
    }

    return 1; // It's a palindrome
}

main() {
    char input[100];

    printf("Enter a string: ");
    scanf("%s", input);

    // Reverse the string
    reverseString(input);

    // Check if it's a palindrome
    if (isPalindrome(input)) {
        printf("The reversed string is a palindrome.\n");
    } else {
        printf("The reversed string is not a palindrome.\n");
    }
}

