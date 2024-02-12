#include<iostream>
using namespace std;

class Car{
	string company;
	string model;
	int year;
	
	public:
		Car(){//default constructor
			
		}
		Car(string com,string mod,int y){ // parameterized constructor
			company=com;
			model=mod;
			year=y;
		}
		Car(Car &obj){ // (copy constructor)To copy on object(obj)
			company=obj.company;
			model=obj.model;
			year=obj.year;
		}
		void setvalues(){
			cout<<"\nAbout Car -----------------------";
			cout<<"\nCompany Name : "<<company;
			cout<<"\nCar Name : "<<model;
			cout<<"\nYear : "<<year;
		}
};
main(){
	Car C("Mahindra","TUV_T10",2022);//call perameterized constructor
	C.setvalues();
	Car C1;
	C1=C;//Copy Constructor
	C1.setvalues();
}
