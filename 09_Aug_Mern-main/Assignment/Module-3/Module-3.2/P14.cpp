#include <iostream>

class NumberSwapper {
private:
    int a;
    int b;

public:
    NumberSwapper(int num1, int num2) : a(num1), b(num2) {}

    // Declaration of the friend function
    friend void swapNumbers(NumberSwapper& ns);
    
    // Function to display the numbers
    void displayNumbers() {
        std::cout << "Number 1: " << a << std::endl;
        std::cout << "Number 2: " << b << std::endl;
    }
};

// Definition of the friend function to swap numbers
void swapNumbers(NumberSwapper& ns) {
    ns.a = ns.a + ns.b;
    ns.b = ns.a - ns.b;
    ns.a = ns.a - ns.b;
}

int main() {
    int num1, num2;
    std::cout << "Enter two numbers: ";
    std::cin >> num1 >> num2;

    NumberSwapper ns(num1, num2);

    std::cout << "Before swapping:" << std::endl;
    ns.displayNumbers();

    // Call the friend function to swap the numbers
    swapNumbers(ns);

    std::cout << "After swapping:" << std::endl;
    ns.displayNumbers();

    return 0;
}
