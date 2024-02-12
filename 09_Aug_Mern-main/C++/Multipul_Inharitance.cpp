//Multipul Inharitance
#include<iostream>
using namespace std;

class A{
	public :
		A(){
			cout<<"\nConstructor Called From A......";
		}
};
class B{
	public : 
		B(){
			cout<<"\nConstructor Called From B......";
		}
};
class C : public B, public A{
	public : 
	C(){
		cout<<"\nConstructor Called From C......";
	}
};
main(){
	C obj;
}
