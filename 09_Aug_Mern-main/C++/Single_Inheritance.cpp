// To Demonstrate The Single Inheritance.(Public Derivation)

#include<iostream>
using namespace std;

class Base{
	int b; //private
	
	public:
		void get_base(){
			b=10;
			cout<<"\nBase = "<<b;
		}
};
class Derive : public Base{
	int d; //private
	public : 
	void get_derive(){
		d=60;
			cout<<"\nDerive = "<<d;
	}
};
main(){
	Derive Dobj;
	Dobj.get_base(); //public inherited mode
	Dobj.get_derive();
}
