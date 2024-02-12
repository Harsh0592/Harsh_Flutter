/* wap to make mathematical operations addition, substraction, multiplication,
	Devision for two numbers using inline functions. */

#include<iostream>
using namespace std;

class Mathematical{
	int a,b;
	public : 
		
		void getdata(int c,int d){
			a=c;
			b=d;
		}
		
		inline int add(){
			return a+b;
		}
		
		inline int sub(){
			return a-b;
		}
		
		inline int mul(){
			return a*b;
		}
		
		inline int div(){
			return a/b;
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
	add1=M.add();
	cout<<"\nAddition Of two Numbers = "<<add1;
	sub1=M.sub();
	cout<<"\nSubstraction Of two Numbers = "<<sub1;
	mul1=M.mul();
	cout<<"\nMultiplication Of two Numbers = "<<mul1;
	div1=M.div();
	cout<<"\nDivison Of two Numbers = "<<div1;
}
