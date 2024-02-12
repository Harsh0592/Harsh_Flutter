#include <iostream>

class MaxFinder; // Forward declaration of the MaxFinder class

class NumberPair {
private:
    int num1;
    int num2;

public:
    NumberPair(int n1, int n2) : num1(n1), num2(n2) {}

    // Declare MaxFinder as a friend class
    friend class MaxFinder;
};

class MaxFinder {
public:
    static int findMax(const NumberPair& pair) {
        return (pair.num1 > pair.num2) ? pair.num1 : pair.num2;
    }
};

int main() {
    int num1, num2;
    std::cout << "Enter two numbers: ";
    std::cin >> num1 >> num2;

    NumberPair pair(num1, num2);

    int max = MaxFinder::findMax(pair);

    std::cout << "The maximum number is: " << max << std::endl;

    return 0;
}
