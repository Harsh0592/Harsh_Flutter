#include<iostream>
using namespace std;

main(){
	int value = 100;
	int *ptr;
	ptr=&value;
	
	cout<<"\n Value = "<<value;
	cout<<"\n Ptr = "<<ptr;
	cout<<"\n *Ptr = "<<*ptr;
}
