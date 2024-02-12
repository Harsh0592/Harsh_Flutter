#include <iostream>

template <typename T>
void bubbleSort(T arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                T temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int intArray[] = {5, 2, 9, 1, 5, 6};
    double doubleArray[] = {3.14, 1.618, 2.71, 0.577, 1.414};
    char charArray[] = {'z', 'a', 'd', 'c', 'b'};

    int intSize = sizeof(intArray) / sizeof(intArray[0]);
    int doubleSize = sizeof(doubleArray) / sizeof(doubleArray[0]);
    int charSize = sizeof(charArray) / sizeof(charArray[0]);

    std::cout << "Original Integer Array: ";
    for (int i = 0; i < intSize; i++) {
        std::cout << intArray[i] << " ";
    }
    std::cout << std::endl;

    std::cout << "Original Double Array: ";
    for (int i = 0; i < doubleSize; i++) {
        std::cout << doubleArray[i] << " ";
    }
    std::cout << std::endl;

    std::cout << "Original Char Array: ";
    for (int i = 0; i < charSize; i++) {
        std::cout << charArray[i] << " ";
    }
    std::cout << std::endl;

    bubbleSort(intArray, intSize);
    bubbleSort(doubleArray, doubleSize);
    bubbleSort(charArray, charSize);

    std::cout << "Sorted Integer Array: ";
    for (int i = 0; i < intSize; i++) {
        std::cout << intArray[i] << " ";
    }
    std::cout << std::endl;

    std::cout << "Sorted Double Array: ";
    for (int i = 0; i < doubleSize; i++) {
        std::cout << doubleArray[i] << " ";
    }
    std::cout << std::endl;

    std::cout << "Sorted Char Array: ";
    for (int i = 0; i < charSize; i++) {
        std::cout << charArray[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}
