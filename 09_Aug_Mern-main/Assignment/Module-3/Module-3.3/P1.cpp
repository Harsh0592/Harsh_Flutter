#include <iostream>

// Template function to swap two values
template <typename T>
void swapValues(T &a, T &b) {
    T temp = a;
    a = b;
    b = temp;
}

int main() {
    int num1 = 5, num2 = 10;
    double double1 = 3.14, double2 = 2.71;
    char char1 = 'A', char2 = 'B';

    std::cout << "Before swapping:" << std::endl;
    std::cout << "num1 = " << num1 << ", num2 = " << num2 << std::endl;
    std::cout << "double1 = " << double1 << ", double2 = " << double2 << std::endl;
    std::cout << "char1 = " << char1 << ", char2 = " << char2 << std::endl;

    // Swap integer values
    swapValues(num1, num2);

    // Swap double values
    swapValues(double1, double2);

    // Swap char values
    swapValues(char1, char2);

    std::cout << "After swapping:" << std::endl;
    std::cout << "num1 = " << num1 << ", num2 = " << num2 << std::endl;
    std::cout << "double1 = " << double1 << ", double2 = " << double2 << std::endl;
    std::cout << "char1 = " << char1 << ", char2 = " << char2 << std::endl;

    return 0;
}
