//Wap to demonstrate the Class & Object (string) 
//(using scop resolution operator - ::)
#include<iostream>
#include<string.h>
using namespace std;

class Employee{
	int eid;
	string ename;
	float salary;
	
	public :
		void setdata(int id,string name,float sal){
			id=eid;
			name=ename;
			sal=salary;
		}
		
		void printdata(); //declaration of scop resolution member function
};
void Employee :: printdata(){
			cout<<"\n\n Employe ID = "<<eid;
			cout<<"\n\n Employee Name = "<<ename;
			cout<<"\n\n Salary = "<<salary;
		}

main(){
	Employee E , E1;
	int id;
	string name;
	float sal;
	
	cout<<" Eneter the Emp id : ";
			cin>>id;
			cout<<"\n Enter the Employee Name : ";
			cin>>name;
			cout<<"\n Enter the salary : ";
			cin>>sal;
	E.setdata(id,name,sal);
	E.printdata();
	
	cout<<" Eneter the Emp id : ";
			cin>>id;
			cout<<"\n Enter the Employee Name : ";
			cin>>name;
			cout<<"\n Enter the salary : ";
			cin>>sal;
	E1.setdata(id,name,sal);
	E1.printdata();
}
