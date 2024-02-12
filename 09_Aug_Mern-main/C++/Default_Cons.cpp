/*

Default constroctor is used to initialize the data mamber of the class.
It is invoked automatically when we are creating the object of class Student.

*/

#include<iostream>
#include<string.h>
using namespace std;

class Student{
	int rollno;
	string name;
	
	public :
		Student(){ //default constructor.
			rollno=10;
			name="Nirali";
		}
		
		void printdata(){
			cout<<"RollNo. = "<<rollno;
			cout<<"\nName = "<<name;
		}
};

main(){
	Student S; // Call default constructor auto.
	S.printdata();
}
