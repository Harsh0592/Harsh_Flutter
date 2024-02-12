/**Assume a class cricketer is declared. Declare a derived class batsman from
cricketer. Data member of batsman. Total runs, Average runs and best
performance. Member functions input data, calculate average runs, Display
data. (Single Inheritance)**/
#include <iostream>
#include <string>
using namespace std;
class Cricketer {
protected:
    string name;
    int age;

public:
    Cricketer(const string& cricketerName, int cricketerAge) : name(cricketerName), age(cricketerAge) {}

    // Member function to display basic cricketer information
    void displayCricketerInfo() {
        cout << "Cricketer Name: " << name <<endl;
        cout << "Cricketer Age: " << age << " years" <<endl;
    }
};

class Batsman : public Cricketer {
private:
    int totalRuns;
    double averageRuns;
    int bestPerformance;

public:
    Batsman(const string& batsmanName, int batsmanAge, int runs, int best) : Cricketer(batsmanName, batsmanAge) {
        totalRuns = runs;
        bestPerformance = best;
        averageRuns = 0; // Initialize average to 0
    }

    // Member function to input average runs
    void inputAverageRuns(double avg) {
        averageRuns = avg;
    }

    // Member function to calculate average runs
    void calculateAverageRuns() {
        if (totalRuns > 0) {
            averageRuns = static_cast<double>(totalRuns) / 50; // Assuming an average cricket season of 50 matches
        } else {
            cerr << "Error: Total runs must be greater than 0 to calculate the average." <<endl;
        }
    }

    // Member function to display batsman's data
    void displayBatsmanData() {
        displayCricketerInfo();
       cout << "Total Runs: " << totalRuns <<endl;
       cout << "Average Runs: " << averageRuns <<endl;
       cout << "Best Performance: " << bestPerformance << " runs" <<endl;
    }
};

int main() {
    Batsman b("Hardik", 25, 2500, 150);

    b.calculateAverageRuns();

    cout << "Enter the average runs for the batsman: ";
    double avg;
    cin >> avg;
    b.inputAverageRuns(avg);

    b.displayBatsmanData();
    return 0;
}

