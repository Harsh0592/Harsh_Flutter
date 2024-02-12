//WAP to show difference between Structure and Union
#include <stdio.h>

// Define a structure
struct StructExample {
    int x;
    double y;
};

// Define a union
union UnionExample {
    int a;
    double b;
};
main(){
    struct StructExample s;
    union UnionExample u;

    printf("Size of struct: %lu bytes\n", sizeof(s)); // Size of struct is sum of its members
    printf("Size of union: %lu bytes\n", sizeof(u));   // Size of union is determined by the largest member

    s.x = 10;
    s.y = 3.14;

    u.a = 10;
    u.b = 3.14;

    printf("Struct: x = %d\n        y = %lf\n\n", s.x, s.y); // Accessing members of a structure
    printf("Union:  a = %d\n        b = %lf\n", u.a, u.b);   // Accessing members of a union
}
 
