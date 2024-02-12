//To demonstrate Template
#include<iostream>
using namespace std;

template<class X> void fun(X a){
	cout<<"\nValue of a = "<<a;
}
template<class X, class Y>void fun(X b, Y c){
	cout<<"\nValue of b = "<<b;
	cout<<"\nValue of c = "<<c;
}
main(){
	fun(10);
	fun(20, 30.8);
}
