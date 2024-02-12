#include <iostream>
#include <cmath>

// Function to calculate the area of a rectangle
double calculateArea(double length, double breadth) {
    return length * breadth;
}

// Function to calculate the area of a triangle
double calculateArea(double base, double height, char shape) {
    if (shape == 'T' || shape == 't') {
        return 0.5 * base * height;
    } else {
        std::cerr << "Invalid shape for area calculation: " << shape << std::endl;
        return 0.0;
    }
}

// Function to calculate the area of a circle
double calculateArea(double radius, char shape) {
    if (shape == 'C' || shape == 'c') {
        return M_PI * radius * radius;
    } else {
        std::cerr << "Invalid shape for area calculation: " << shape << std::endl;
        return 0.0;
    }
}

int main() {
    char choice;
    std::cout << "Choose a shape (R for Rectangle, T for Triangle, C for Circle): ";
    std::cin >> choice;

    if (choice == 'R' || choice == 'r') {
        double length, breadth;
        std::cout << "Enter length and breadth of the rectangle: ";
        std::cin >> length >> breadth;
        double area = calculateArea(length, breadth);
        std::cout << "Area of the rectangle: " << area << std::endl;
    } else if (choice == 'T' || choice == 't') {
        double base, height;
        std::cout << "Enter base and height of the triangle: ";
        std::cin >> base >> height;
        double area = calculateArea(base, height, 'T');
        std::cout << "Area of the triangle: " << area << std::endl;
    } else if (choice == 'C' || choice == 'c') {
        double radius;
        std::cout << "Enter the radius of the circle: ";
        std::cin >> radius;
        double area = calculateArea(radius, 'C');
        std::cout << "Area of the circle: " << area << std::endl;
    } else {
        std::cerr << "Invalid choice." << std::endl;
    }

    return 0;
}
