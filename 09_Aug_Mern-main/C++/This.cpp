#include<iostream>
using namespace std;

class Department{
	public :
		int dept_id;
		string dept_name;
		
		Department(int dep_id, string dept_name){
			this->dept_id=dept_id;
			this->dept_name=dept_name;
		}
};

class Employee{
	private :
		Department *dept; //associate - hase a relation with department class.(agreegate)
	public :
		int emp_id;
		string emp_name;
		Employee(int emp_id, string emp_name, Department *dept){
			this->emp_id = emp_id;
			this->emp_name = emp_name;
			this->dept = dept;  //initialize object with dept_id & dept_name
		}
		void display(){
			cout<<"\nEmp Id = "<<emp_id;
			cout<<"\nEmp Name = "<<emp_name;
			
			cout<<"\nDepat Id = "<<dept->dept_id; //linked
			cout<<"\nDepat Name = "<<dept->dept_name;
		}
};

main(){
	Department D(111, "Sales");
	Employee E(1,"Kohli", &D);
	E.display();
}
