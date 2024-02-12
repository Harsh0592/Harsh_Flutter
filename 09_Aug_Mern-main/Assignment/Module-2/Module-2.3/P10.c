//Write a program of structure for five employee that provides the following
//information -print and display empno, empname, address and age
#include <stdio.h>
struct Employee {
    int empno;
    char empname[50];
    char address[100];
    int age;
};
void printEmployeeInfo(struct Employee emp) {
    printf("Employee Number: %d\n", emp.empno);
    printf("Employee Name: %s\n", emp.empname);
    printf("Address: %s\n", emp.address);
    printf("Age: %d\n", emp.age);
    printf("\n");
}
main(){
    // Create an array of structures for five employees
    struct Employee employees[5];
int i,j;
    for(i = 0; i < 5; i++) {
        printf("Enter information for Employee %d:\n", i + 1);
        printf("Employee Number: ");
        scanf("%d", &employees[i].empno);
        printf("Employee Name: ");
        scanf("%s", employees[i].empname);
        printf("Address: ");
        scanf("%s", employees[i].address);
        printf("Age: ");
        scanf("%d", &employees[i].age);
    }

    printf("\nEmployee Information:\n");

    // Print and display the information for all employees
    for(i = 0; i < 5; i++) {
        printf("Employee %d:\n", i + 1);
        printEmployeeInfo(employees[i]);
    }
}

