/*

To demonstrate friend function

It is not a mamber function of the class so can not be
invoke by "." operator.

You have to pass the object as an argument to access the private
mamber of the class.

*/
#include<iostream>

using namespace std;

class Math{
	int n; //private data mamber of the class
	friend void cube(Math M){
		cout<<"\nCube = "<<M.n*M.n*M.n;
	}
	public :
		void getdata(int num){ // member function/method
			n=num;
		}
		friend void squre(Math M){ //in public part(it is not a member function)
		cout<<"\nSqure = "<<M.n*M.n;
	}
};

main(){
	Math M;
	int n;
	cout<<"Input a Number : ";
	cin>>n;
	M.getdata(n);
	squre(M);
	cube(M);
}
