//To Demonstrate Method Overloading
#include<iostream>
using namespace std;

class Sum{
	int n, n1;
	double n2, n3;
	float n4, n5, n6;
	
	public:
		void add(int a, int b){
			n=a;
			n1=b;
		}
		void add(double c, double d){
			n2=c;
			n3=d;
		}
		void add(float e, float f, float g){
			n4=e;
			n5=f;
			n6=g;
		}
		void printdata(){
			cout<<"\nInteger = "<<n+n1;
			cout<<"\nDouble = "<<n2+n3;
			cout<<"\nFloat = "<<n4+n5+n6;
		}
};
main(){
	int a, b;
	double c, d;
	float e, f, g;
	
	a=10;
	b=20;
	
	c=30.5;
	d=40.5;
	
	e=0.8;
	f=50.8;
	g=60.8;
	
	Sum S;
	S.add(a, b);//calculate integer values.
	S.add(c, d);//calculate double values.
	S.add(e, f, g);//calculate float values.
	
	S.printdata();
}
