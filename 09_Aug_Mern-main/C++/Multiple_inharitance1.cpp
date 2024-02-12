//WAP to design class "Student" as Super class having Sub class called "Course"&"Personal"(public).
/*Student: 
			Data members : stud_id,stud_name,city,age;
			Member function : get_stud_data(),print_stud_data()
  Personal:
  			Data member : city,age
  			Mamber function : get_personal_data(),print_personal_data()
  Course:
  			Data member : Course_name,fees
			Member function : get_course(),print_course()*/
#include<iostream>
using namespace std;

class Student{
	int stud_id;
	char stud_name[30];
	
	public:
		void get_stud_data(){
			cout<<"\nEnter the Student id : ";
			cin>>stud_id;
			cout<<"\nEnter the Student name : ";
			cin>>stud_name;			
		}
		
		void print_stud_data(){
			cout<<"\nStudent id = "<<stud_id;
			cout<<"\nStudent name = "<<stud_name;
		}
};

class Personal:public Student{
	char city[30];
	int age;
	public:
		void get_personal_data(){
			cout<<"\nEnter the City Name : ";
			cin>>city;
			cout<<"\nEnter the Age : ";
			cin>>age;
		}
		void print_personal_data(){
			cout<<"\nCity Name = "<<city;
			cout<<"\nAge = "<<age;
		}
};

class Course:public Personal{
	char Course_name[30];
	int fees;
	
	public :
		void get_course(){
			cout<<"\nEnter the Course Name : ";
			cin>>Course_name;
			cout<<"\nEnter the Fees : ";
			cin>>fees;
		}
		void print_course(){
			cout<<"\nCourse Name = "<<Course_name;
			cout<<"\nFees = "<<fees;
		}
};

main(){
	
	Course C;
	C.get_stud_data();
	C.get_course();
	C.get_personal_data();
	C.print_personal_data();
	C.print_stud_data();
	C.print_course();
	
}
