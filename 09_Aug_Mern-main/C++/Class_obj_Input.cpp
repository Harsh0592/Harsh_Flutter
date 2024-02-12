//Wap to demonstrate class and onject.

#include<iostream>
using namespace std;

class Employee{
	int eid;
	char ename[30];
	float salary;
	
	public:
		void setdata()
		{
			cout<<" Enter the Emp id : ";
			cin>>eid;
			cout<<"\n Enter Employee Name : ";
			cin>>ename;
			cout<<"\n Enter salary : ";
			cin>>salary;
		}
		
		void printdata(){
			cout<<"\n Employee Id = "<<eid;
			cout<<"\n Employee Name = "<<ename;
			cout<<"\n Salary = "<<salary;
		}
};

main(){
	Employee E;
	E.setdata();
	E.printdata();
}
