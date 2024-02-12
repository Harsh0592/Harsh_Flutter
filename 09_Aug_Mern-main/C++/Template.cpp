#include<iostream>
using namespace std;

template<class X> void fun(X a, X b){
	X c;
	cout<<"\nBefor Swaping of a = "<<a;
	cout<<"\nBefor swaping of b = "<<b;
	c=a;
	a=b;
	b=c;
	cout<<"\nAfter Swaping of a = "<<a;
	cout<<"\nAfter swaping of b = "<<b;
}
main(){
	fun(10,20);
}
