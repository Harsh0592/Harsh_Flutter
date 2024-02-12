/*    Wap to demonstrate the class & object.
      Class : Student
  
      Data Members : s_id
  				 s_name
				 marks
				 
      Member Function : getvalue()
  					setvalue()   */

#include<iostream>
#include<string.h>
using namespace std;

class Student{
	int s_id;
	char s_name[30];
	int marks;
	
	public:
	void getvalue()//To initioalize the data member of the class.
	{
		s_id=110;
		strcpy(s_name,"Nirali");
		marks=99;
	}
	void setvalue()
	{
		cout<<" Student id = "<<s_id;
		cout<<"\n Student's Name = "<<s_name;
		cout<<"\n Student Marks  = "<<marks;
	}
};
main(){
	Student sobj;
	sobj.getvalue();
	sobj.setvalue();
	
}
