//To Demonstrate Default Constructor
#include<iostream>
using namespace std;

class Sum{
	int n1,n2;
	
	public:
		Sum()//default constructor
		{
			n1=10;
			n2=20;
		}
		void display(){
			cout<<"Number 1 = "<<n1;
			cout<<"\nNumber 2 = "<<n2;
		}
};

main(){
	Sum s1; //call defult constroctor automatically
	s1.display();
}
