//Method Overloading

#include<iostream>
using namespace std;

class Addition{
	int i1,i2;
	float f1,f2;
	double d1,d2;
	
	public : 
		int sum(int a, int b){
			i1=a;
			i2=b;
			return i1+i2;
		}
		float sum(float a, float b){
			f1=a;
			f2=b;
			return f1+f2;
		}
		double sum(double a, double b){
			d1=a;
			d2=b;
			return d1+d2;
		}
};

main(){
	Addition A;
	
	int add1;
	float add2;
	double add3; 
	add1=A.sum(100, 200);
	add2=A.sum(10.2, 20.6);
	add3=A.sum(100.60, 200.66);
	
	cout<<"\nInteger Addition = "<<add1;
	cout<<"\nFloat Addition = "<<add2;
	cout<<"\nDouble Addtion = "<<add3;
}
