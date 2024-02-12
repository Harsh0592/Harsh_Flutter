/**Assume that the test results of a batch of students are stored in three different
classes. Class Students are storing the roll number. Class Test stores the marks
obtained in two subjects and class result contains the total marks obtained in
the test. The class result can inherit the details of the marks obtained in the
test and roll number of students. (Multilevel Inheritance)
**/
#include <iostream>
#include <string>
using namespace std;
class Students {
protected:
    int rollNumber;

public:
    Students() {}

    Students(int roll) : rollNumber(roll) {}

    void inputRoll() {
        cout << "Enter roll number: ";
        cin >> rollNumber;
    }

    void displayRoll() {
        cout << "Roll Number: " << rollNumber <<endl;
    }
};

class Test : public Students {
protected:
    int subject1Marks;
    int subject2Marks;

public:
    Test() {}

    Test(int roll, int subj1, int subj2) : Students(roll), subject1Marks(subj1), subject2Marks(subj2) {}

    void inputMarks() {
        inputRoll();
        cout << "Enter marks for Subject 1: ";
        cin >> subject1Marks;
        cout << "Enter marks for Subject 2: ";
        cin >> subject2Marks;
    }

    void displayMarks() {
        displayRoll();
        cout << "Marks for Subject 1: " << subject1Marks <<endl;
        cout << "Marks for Subject 2: " << subject2Marks <<endl;
    }
};

class Result : public Test {
private:
    int totalMarks;

public:
    Result() {}

    Result(int roll, int subj1, int subj2) : Test(roll, subj1, subj2) {}

    void calculateTotalMarks() {
        totalMarks = subject1Marks + subject2Marks;
    }

    void displayResult() {
        displayMarks();
        calculateTotalMarks();
        cout << "Total Marks Obtained: " << totalMarks <<endl;
    }
};

int main() {
    Result r;

    cout << "Enter test details:" <<endl;
    r.inputMarks();

    cout << "\nTest details and result:" <<endl;
    r.displayResult();
    return 0;
}
