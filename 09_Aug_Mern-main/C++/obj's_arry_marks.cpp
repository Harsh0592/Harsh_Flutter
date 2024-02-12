/*wap to demonstarate the marksheet as score card of student.(using array within class)

rollno
student name
marks[5]
total
per
(using object's array)
*/

#include<iostream>
#include<string.h>
using namespace std;

class Student{
	int rollno;
	string sname;
	int marks[5];
	float per;
	
	public : 
		void getdata();
		void putdata();
};

void Student :: getdata(){
	cout<<" Enter the Rollno : ";
	cin>>rollno;
	cout<<"\n Enter the Student's Name : ";
	cin>>sname;
	for(int i=0;i<=5;i++){
		cout<<"\n Enetr ["<<i<<"] Marks : ";
		cin>>marks[i];
	}
	
}

void Student :: putdata(){
	int total;
	cout<<"\n-----------------------------------";
	cout<<"\n Student Rollno = "<<rollno;
	cout<<"\n Student's Name = "<<sname;
	for(int i=0;i<=5;i++){
		cout<<"\n Marks ["<<i<<"] = "<<marks[i];
		total=total+marks[i];	
	}
	per=total/5;
	cout<<"\n-----------------------------------";
	cout<<"\n Total = "<<total;
	cout<<"\n Percentage = "<<per;
	
}

main(){
	Student S[3];
	for(int i=0;i<=3;i++){
		S[i].getdata();
	}
	for(int i=0;i<=3;i++){
		S[i].putdata();
	}
}
