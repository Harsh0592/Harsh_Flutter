/**Write a program to Mathematic operation like Addition, Subtraction,
Multiplication, Division Of two number using different parameters and
Function Overloading**/
#include <iostream>
using namespace std;
// Function overloading for addition
int mathOperation(int a, int b) {
    return a + b;
}

double mathOperation(double a, double b) {
    return a + b;
}

// Function overloading for subtraction
int mathOperation(int a, int b, int c) {
    return a - b - c;
}

double mathOperation(double a, double b, double c) {
    return a - b - c;
}

// Function overloading for multiplication
int mathOperation(int a, int b, int c, int d) {
    return a * b * c * d;
}

double mathOperation(double a, double b, double c, double d) {
    return a * b * c * d;
}

// Function overloading for division
//double mathOperation(int a, int b) {
//    if (b != 0) {
//        return static_cast<double>(a) / b;
//    } else {
//        cerr << "Error: Division by zero is not allowed." <<endl;
//        return 0.0;
//    }
//}

//double mathOperation(double a, double b) {
//    if (b != 0.0) {
//        return a / b;
//    } else {
//        cerr << "Error: Division by zero is not allowed." <<endl;
//        return 0.0;
//    }
//}

int main() {
    int intResult1, intResult2, intResult3;
    double doubleResult1, doubleResult2, doubleResult3;

    intResult1 = mathOperation(10, 5);
    intResult2 = mathOperation(15, 6, 2);
    intResult3 = mathOperation(2, 3, 4, 5);

    doubleResult1 = mathOperation(12.5, 3.5);
    doubleResult2 = mathOperation(20.0, 5.0, 2.0);
    doubleResult3 = mathOperation(1.5, 2.5, 3.0, 4.0);

    cout << "Integer Results:" <<endl;
    cout << "Addition: " << intResult1 <<endl;
    cout << "Subtraction: " << intResult2 <<endl;
    cout << "Multiplication: " << intResult3 <<endl;

    cout << "Double Results:" <<endl;
    cout << "Addition: " << doubleResult1 <<endl;
    cout << "Subtraction: " << doubleResult2 <<endl;
    cout << "Multiplication: " << doubleResult3 <<endl;

//    double divisionResult1 = mathOperation(12, 4);
//    double divisionResult2 = mathOperation(5.0, 0.0);

//    cout << "Division (double): " << divisionResult1 <<endl;
//    cout << "Division (double) with division by zero: " << divisionResult2 <<endl;

    return 0;
}
