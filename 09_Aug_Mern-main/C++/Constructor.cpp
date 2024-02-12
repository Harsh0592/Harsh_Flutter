//write a program of addition,Substraction,division,Multiplication using constructor.
#include <iostream>
using namespace std;

class Calculator {
private:
    double num1, num2;

public:
    // Constructor
    Calculator(double a, double b) {
        num1 = a;
        num2 = b;
    }

    // Addition method
    double add() {
        return num1 + num2;
    }

    // Subtraction method
    double subtract() {
        return num1 - num2;
    }

    // Multiplication method
    double multiply() {
        return num1 * num2;
    }

    // Division method
    double divide() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            cerr << "Error: Division by zero." <<endl;
            return 0;
        }
    }
};

int main() {
    // Create an instance of the Calculator class
    Calculator calculator(10, 5);

    // Perform operations and display results
    cout << "Addition: " << calculator.add() << endl;
    cout << "Subtraction: " << calculator.subtract() << endl;
    cout << "Multiplication: " << calculator.multiply() <<endl;
    cout << "Division: " << calculator.divide() << endl;

    return 0;
}

