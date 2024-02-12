//Write a program of structure employee that provides the following
//information -print and display empno, empname, address and age
/*C program to read and print employee's record using structure*/
 
#include <stdio.h>
struct employee{
    char    name[30];
    char    address[30];
    int     empId;
    int     age;
};
main(){
    /*declare structure variable*/
    struct employee emp;
     
    printf("\nEnter details :\n");
    printf("Name ?:");          gets(emp.name);
    printf("Address ?:");       gets(emp.address);
    printf("ID ?:");            scanf("%d",&emp.empId);
    printf("Age ?:");           scanf("%d",&emp.age);
     
    /*print employee details*/
    printf("\nEntered detail is:");
    printf("Name: %s\n"   ,emp.name);
    printf("Address: %s\n",emp.address);
    printf("Id: %d\n"     ,emp.empId);
    printf("Age: %d\n"  ,emp.age);
}

