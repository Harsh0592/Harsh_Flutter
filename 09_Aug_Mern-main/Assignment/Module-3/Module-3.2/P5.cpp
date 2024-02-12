/**Write a program of Addition, Subtraction, Division, Multiplication using
constructor.**/
#include <iostream>
using namespace std;
class Calculator {
private:
    int num1;
    int num2;

public:
    // Constructor to initialize the numbers
    Calculator(int a, int b) {
        num1 = a;
        num2 = b;
    }

    // Member function to perform addition
    add() {
        return num1 + num2;
    }

    // Member function to perform subtraction
    subtract() {
        return num1 - num2;
    }

    // Member function to perform multiplication
    multiply() {
        return num1 * num2;
    }

    // Member function to perform division
   divide() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
           cerr << "Error: Division by zero is not allowed." <<endl;
            return 0; // You can choose to handle the error differently if needed.
        }
    }
};

int main() {
   int num1, num2;

    cout << "Enter two numbers: ";
	cin >> num1 >> num2;

    Calculator c(num1, num2);

   cout << "Result of addition: " << c.add() <<endl;
    cout << "Result of subtraction: " << c.subtract() <<endl;
    cout << "Result of multiplication: " << c.multiply() <<endl;
    cout << "Result of division: " << c.divide() <<endl;

    return 0;
}
