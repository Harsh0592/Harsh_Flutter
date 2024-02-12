#include <iostream>
#include <string>

class ConcatenatedString {
private:
    std::string str;

public:
    ConcatenatedString(const std::string& s) : str(s) {}

    // Overloaded + operator for string concatenation
    ConcatenatedString operator+(const ConcatenatedString& other) {
        ConcatenatedString result = str + other.str;
        return result;
    }

    // Member function to display the concatenated string
    void display() {
        std::cout << "Concatenated String: " << str << std::endl;
    }
};

int main() {
    ConcatenatedString str1("Hello, ");
    ConcatenatedString str2("world!");

    ConcatenatedString concatenated = str1 + str2;

    concatenated.display();

    return 0;
}
