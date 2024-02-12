//WAP to design class "Student" as Super class having Sub class called "Course"(privete).
/*Student: 
			Data members : stud_id,stud_name,city,age;
			Member function : get_stud_data(),print_stud_data()
  Course:
  			Data member : Course_name,fees
			Member function : get_course(),print_course()*/
#include<iostream>
using namespace std;

class Student{
	int stud_id;
	char stud_name[30];
	char city[30];
	int age;
	
	public:
		void get_stud_data(){
			cout<<"\nEnter the Student id : ";
			cin>>stud_id;
			cout<<"\nEnter the Student name : ";
			cin>>stud_name;
			cout<<"\nEnter the Student city : ";
			cin>>city;
			cout<<"\nEnter the Student age : ";
			cin>>age;			
		}
		
		void print_stud_data(){
			cout<<"\nStudent id = "<<stud_id;
			cout<<"\nStudent name = "<<stud_name;
			cout<<"\nStudent city = "<<city;
			cout<<"\nStudent age = "<<age;	
		}
};

class Course:private Student{
	char Course_name[30];
	int fees;
	
	public :
		void get_course(){
			get_stud_data();
			cout<<"\nEnter the Course Name : ";
			cin>>Course_name;
			cout<<"Enter the Fees : ";
			cin>>fees;
		}
		void print_course(){
			print_st
			ud_data();
			cout<<"\nCourse Name = "<<Course_name;
			cout<<"\nFees = "<<fees;
		}
};

main(){
	
	Course C;
	
	C.get_course();
	C.print_course();
	
}
