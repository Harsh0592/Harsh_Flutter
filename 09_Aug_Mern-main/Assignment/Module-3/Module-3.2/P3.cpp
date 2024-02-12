/**Write a program to find the multiplication values and the cubic values using
inline function**/
#include <iostream>
using namespace std;
// Inline function to calculate the multiplication of a number by a factor
inline int multiply(int number, int factor) {
    return number * factor;
}
// Inline function to calculate the cubic value of a number
inline int cube(int number) {
    return number * number * number;
}
int main() {
    int num;
    cout << "Enter a number: ";
    cin >> num;
    int multiplicationValue = multiply(num, 2.0); // Multiply by 2
    int cubicValue = cube(num);
    cout << "Multiplication by 2: " << multiplicationValue <<endl;
    cout << "Cubic value: " << cubicValue <<endl;
    return 0;
}

