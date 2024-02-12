/* wap to make mathematical operations addition, substraction, multiplication,
	Devision for two numbers using friend functions. */

#include<iostream>
using namespace std;

class Mathematical{
	int a,b;
	
	friend void add(Mathematical M){
			cout<<"\nAddition Of two Numbers = "<<M.a+M.b;
		}
		
		friend void sub(Mathematical M){
			cout<<"\nSubstraction Of two Numbers = "<<M.a-M.b;
		}
		
		friend void mul(Mathematical M){
			cout<<"\nMultiplication Of two Numbers = "<<M.a*M.b;
		}
		
		friend void div(Mathematical M){
			cout<<"\nDivison Of two Numbers = "<<M.a/M.b;
		}
	public : 
		
		void getdata(int c,int d){
			a=c;
			b=d;
		}
};

main(){
	Mathematical M;
	int c,d;
	int add1,sub1,mul1,div1;
	cout<<"Enter first value : ";
	cin>>c;
	cout<<"\nEnter second value : ";
	cin>>d;
	M.getdata(c,d);
	add(M);
	sub(M);
	mul(M);
	div(M);
}
