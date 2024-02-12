#include <stdio.h>

// Define a structure to store student information
struct Student {
    char name[50];
    int rollNumber;
    float marks;
};

int main() {
    // Declare an array of struct Student to store information for 5 students
    struct Student students[5];
	int i;
    // Input information for 5 students
    printf("Enter information for 5 students:\n");
    for(i = 0; i < 5; i++) {
        printf("Student %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", students[i].name);
        printf("Roll Number: ");
        scanf("%d", &students[i].rollNumber);
        printf("Marks: ");
        scanf("%f", &students[i].marks);
    }

    // Print the information in a table format
    printf("\nStudent Information Table:\n");
    printf("| %-15s | %-12s | %-8s |\n", "Name", "Roll Number", "Marks");
    printf("|-----------------|--------------|-----------|\n");
    for(i = 0; i < 5; i++) {
        printf("| %-15s | %-12d | %-8.2f |\n", students[i].name, students[i].rollNumber, students[i].marks);
    }

    return 0;
}

