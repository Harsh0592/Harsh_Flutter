//Multilevel Inharitance

#include<iostream>
using namespace std;

class A{
	int a;
	public : void printdata_A(){
		a=10;
		cout<<"\nA = "<<a;
	}
};
class B : public A{
	int b;
	public : void printdata_B(){
		b=20;
		cout<<"\nB = "<<b;
	}
};
class C : public B{
	int c;
	public : void printdata_C(){
		c=30;
		cout<<"\nC = "<<c;
	}
};
main(){
	C obj;
	obj.printdata_A();
	obj.printdata_B();
	obj.printdata_C();
}
