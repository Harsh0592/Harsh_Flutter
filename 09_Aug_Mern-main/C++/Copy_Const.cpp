/*Write a C++ program to create a class called Car that has private member variables for company,model and year.
Implement member function to get set these variables.(use copy constructor also to demonstrate)*/
#include <iostream>
#include <string>
using namespace std;

class Car {
  private: 
  		string company;
  		string model;
  		int year;

  public:
    // Constructor
    Car(){ //defult constructor
    	
	}
	Car(string com,string mod, int y)//perameterrized cons.
	{
		company=com;
		model=mod;
		year=y;
	}
	Car(Car &obj)//copy constructor. to copy one obj from another.
	{
		company=obj.company;
		model=obj.model;
		year=obj.year;
	}
		
		void setvalues()
		{
			cout<<"\n\n\t About Car ..................................";
			cout<<"\n\n\t Company Name : "<<company;
			cout<<"\n\n\t Model Name : "<<model;
			cout<<"\n\n\t Year : "<<year;
		}
};

int main() {
  // Create a car object
  Car car("AUDI", "A6", 2023);
  Car C1;
  C1=car;//copy con
	car.setvalues();
	C1.setvalues();
}
