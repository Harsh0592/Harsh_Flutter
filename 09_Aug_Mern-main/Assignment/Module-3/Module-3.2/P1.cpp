//WAP to create simple calculator using class
#include <iostream>
using namespace std;

class Calculator {
public:
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            cerr << "Error: Division by zero is not allowed." <<endl;
            return 0;
        }
    }
};

int main() {
    Calculator c;
    int num1, num2;
    char op;

    cout << "Enter two numbers: ";
    cin >> num1 >> num2;

    cout << "Enter an operator (+, -, *, /): ";
    cin >> op;

    switch (op) {
        case '+':
            cout << "Result: " << c.add(num1, num2) <<endl;
            break;
        case '-':
            std::cout << "Result: " << c.subtract(num1, num2) <<endl;
            break;
        case '*':
            cout << "Result: " << c.multiply(num1, num2) <<endl;
            break;
        case '/':
            cout << "Result: " << c.divide(num1, num2) <<endl;
            break;
        default:
            cerr << "Error: Invalid operator." <<endl;
            break;
    }

    return 0;
}

