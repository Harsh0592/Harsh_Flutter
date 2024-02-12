/*

To demonstrate inline function

Inline Function is used for one liner code to
reduce complexiy to indicate to the compiler.

This function can not include any conditional or looping statments.

*/
#include<iostream>

using namespace std;

class Math{
	int n;
	public :
		void getdata(int num){
			n=num;
		}
		inline int squre(){ //one liner function
			return n*n;
			//cout<<"\nSqure = "<<n*n; (we can use also this)
		}
		inline int cube(){ //one liner function
			return n*n*n;
		}
};

main(){
	Math M;
	int s,c,num;
	cout<<"Input a Number : ";
	cin>>num;
	M.getdata(num);
	s=M.squre();
	cout<<"\nSqure = "<<s;
	c=M.cube();
	cout<<"\nCube = "<<c;
	
}
