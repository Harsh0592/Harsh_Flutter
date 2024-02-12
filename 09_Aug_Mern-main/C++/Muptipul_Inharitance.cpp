#include<iostream>
using namespace std;

class Trainer{
	string t_name;
	public : 
	Trainer(){
		t_name="Chinmayee";
	}
	void print_trainer(){
		cout<<"\nTrainer's Name : "<<t_name;
	}
};

class Course{
	string c_name;
	public : 
	Course(){
		c_name="SE";
	}
	void print_course(){
		cout<<"\nCourse's Name : "<<c_name;
	}
};
class TopsTech : public Trainer , public Course{
	int duration;
	public :
	TopsTech(){
		duration=1;
	}
	void print_duration(){
		cout<<"\nTotal Duration : "<<duration;
	}
};
main(){
	TopsTech T;
	T.print_trainer();
	T.print_course();
	T.print_duration();
}
