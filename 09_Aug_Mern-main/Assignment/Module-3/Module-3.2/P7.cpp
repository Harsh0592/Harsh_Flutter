/**Create a class person having members name and age. Derive a class student
having member percentage. Derive another class teacher having member
salary. Write necessary member function to initialize, read and write data.
Write also Main function (Multiple Inheritance)**/
#include <iostream>
#include <string>
using namespace std;
class Person {
protected:
    string name;
    int age;

public:
    Person() {} // Default constructor

    Person(const string& personName, int personAge) : name(personName), age(personAge) {}

    void readData() {
        cout << "Enter name: ";
        cin >> name;
        cout << "Enter age: ";
        cin >> age;
    }

    void displayData() {
        cout << "Name: " << name <<endl;
        cout << "Age: " << age << " years" <<endl;
    }
};

class Student : public Person {
private:
    float percentage;

public:
    Student() {} // Default constructor

    void readData() {
        Person::readData(); // Read data from the base class
        cout << "Enter percentage: ";
        cin >> percentage;
    }

    void displayData() {
        Person::displayData(); // Display data from the base class
        cout << "Percentage: " << percentage << "%" <<endl;
    }
};

class Teacher : public Person {
private:
    double salary;

public:
    Teacher() {} // Default constructor

    void readData() {
        Person::readData(); // Read data from the base class
        cout << "Enter salary: $";
        cin >> salary;
    }

    void displayData() {
        Person::displayData(); // Display data from the base class
        cout << "Salary: $" << salary <<endl;
    }
};

int main() {
    Student s;
    Teacher t;

    cout << "Enter student details:" <<endl;
    s.readData();

    cout << "\nEnter teacher details:" <<endl;
    t.readData();

    cout << "\nStudent details:" <<endl;
    s.displayData();

    cout << "\nTeacher details:" <<endl;
    t.displayData();
    return 0;
}
