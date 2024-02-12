//To demonstrat Destructor
#include<iostream>
using namespace std;

class Sample{
	public :
		Sample(){
			cout<<"\nConstructor is called......";
		}
		~Sample(){ // destructor
			cout<<"\nDestructor is called......";
		}
};
main(){
	Sample S;
}
