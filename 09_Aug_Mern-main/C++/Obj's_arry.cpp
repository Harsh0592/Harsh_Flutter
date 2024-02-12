/*

Wap to demonstrate array of object.
Employee :
		empid, ename

*/

#include<iostream>
#include<string.h>
using namespace std;

class Employee{
	int empid;
	string ename;
	
	public :
		void getdata();
		void putdata();
};

void Employee :: getdata(){
	cout<<"\n Enter the Employee Id : ";
	cin>>empid;
	cout<<"\n Enter the Employee's  Name : ";
	cin>>ename;
}

void Employee :: putdata(){
	cout<<"\n -----------------------------------------------------";
	cout<<"\n Employee Id = "<<empid;
	cout<<"\n Employee's Name = "<<ename;
}

main(){
	Employee E[3];
	for(int i=0;i<=3;i++){
	E[i].getdata();}
	for(int i=0;i<=3;i++){
	E[i].putdata();}
}
