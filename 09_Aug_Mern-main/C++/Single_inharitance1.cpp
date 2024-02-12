#include<iostream>
using namespace std;

class Base{
	private : int a; //Accessible only for this class.
	
	protected : int b; //Accessible for derive class also
	
	public : int c;//Accesssible for derive class & main (out side the class)
	
	int get_pri(){
		a=10;
		return a;
	}
};
class Derive : protected Base{
	public :
		int get_pro(){
			b=20;
			return b;
		}
		int get_pub(){
			c=30;
			cout<<"\nPrivate Data Mammber a : "<<get_pri();
			return c;
		}
};
main(){
	Derive D;
	
	//cout<<"\nPrivate Data Mamber a = "<<D.get_pri();
	cout<<"\nProtected Data Mamber b = "<<D.get_pro();
	cout<<"\nPublic Data Mamber c = "<<D.get_pub();
}
