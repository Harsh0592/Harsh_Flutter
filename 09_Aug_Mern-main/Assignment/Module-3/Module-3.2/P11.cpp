#include <iostream>

class Matrix {
public:
    int size;
    int* elements;

public:
    Matrix(int n) : size(n), elements(new int[n]) {}

    // Overloaded addition operator (+) to add two matrices
    Matrix operator+(const Matrix& other) {
        if (size != other.size) {
            std::cerr << "Error: Matrices must have the same size for addition." << std::endl;
            return *this; // Return the original matrix if sizes don't match
        }

        Matrix result(size);

        for (int i = 0; i < size; ++i) {
            result.elements[i] = elements[i] + other.elements[i];
        }

        return result;
    }

    // Member function to display the matrix
    void display() {
        for (int i = 0; i < size; ++i) {
            std::cout << elements[i] << " ";
        }
        std::cout << std::endl;
    }

    ~Matrix() {
        delete[] elements;
    }
};

int main() {
    int n;

    std::cout << "Enter the size of the matrices: ";
    std::cin >> n;

    Matrix matrix1(n);
    Matrix matrix2(n);

    std::cout << "Enter elements of the first matrix:" << std::endl;
    for (int i = 0; i < n; ++i) {
        std::cin >> matrix1.elements[i];
    }

    std::cout << "Enter elements of the second matrix:" << std::endl;
    for (int i = 0; i < n; ++i) {
        std::cin >> matrix2.elements[i];
    }

    Matrix result = matrix1 + matrix2;

    std::cout << "Result of matrix addition:" << std::endl;
    result.display();

    return 0;
}
