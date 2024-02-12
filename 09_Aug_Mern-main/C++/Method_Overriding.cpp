//Method Overriding

#include<iostream>
using namespace std;

class Base{
	public :
		void print(){
			cout<<"\nBase Class Called......";
		}
};

class Derived : public Base{
	public :
		void print(){
			cout<<"\nDerived Class Called......";
		}
};

main(){
	Derived D;
	D.print();
	D.Base::print();
}
