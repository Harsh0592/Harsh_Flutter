//To Demonstrate Default Constructor
#include<iostream>
using namespace std;

class Sum{
	int n1,n2;
	
	public:
		Sum(int a,int b)//perameterized constructor
		{
			n1=a;
			n2=b;
		}
		void display(){
			cout<<"Number 1 = "<<n1;
			cout<<"\nNumber 2 = "<<n2;
		}
};

main(){
	Sum s(10,20); //call passing perameter constroctor
	s.display();
}
