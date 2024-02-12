//to print even numbers using perameterized constructors

#include<iostream>
using namespace std;

class Even{
	int range,count;
	
	public: 
//	Even(){
//		count=0;
//	}
	Even(int r){
		range=r;
	}
	void diplayEven(){
		for(int i=2;i<range;i=i+2){
			cout<<"\nEven No. = "<<i;
			count++;
		}
		cout<<"\nTotal Even Numbers are = "<<count;
	}
};
main(){
	Even E(20);
	E.diplayEven();
}
