//To Demonstrate Copy Constructor
#include<iostream>
using namespace std;

class Sum{
	int n1,n2;
	
	public:
		Sum(){}//default constructor
		Sum(Sum &s)// Copy constructor
		{
			n1=s.n1;
			n2=s.n2;
		}
		void getdata(){
			cout<<"\nEnter the Number 1 : ";
			cin>>n1;
			cout<<"\nEnter the Number 2 : ";
			cin>>n2;
		}
		void display(){
			cout<<"\n----------------------------------";
			cout<<"\nNumber 1 = "<<n1;
			cout<<"\nNumber 2 = "<<n2;
		}
};

main(){
	Sum s;//call default constructor
	s.getdata();//s object initializ numbers
	s.display();//value print
	Sum s1; // call default constructor
	s1=s; //call copy constructor s will be copied
	s1.display();
}
