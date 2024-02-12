//To Demonstrate Student Info using Copy constructor
#include<iostream>
using namespace std;

class Student{
	int sid;
	string sname;
	string course;
	
	public:
		Student(){
			
		}
		Student(Student &S1){
			sid=S1.sid;
			sname=S1.sname;
			course=S1.course;
		}
		void getdata(){
			cout<<"\nEnter Student I'd : ";
			cin>>sid;
			cout<<"\nEnter Student Name : ";
			cin>>sname;
			cout<<"\nEnter the Course : ";
			cin>>course;
		}
		void printdata(){
			cout<<"\n--------------------------------------------";
			cout<<"\nStudent I'd = "<<sid;
			cout<<"\nStudent Name = "<<sname;
			cout<<"\nCourse = "<<course;
		}
};

main(){
	Student S1,S2;
	S1.getdata();
	S1.printdata();
	S2=S1;
	S2.printdata();
}
