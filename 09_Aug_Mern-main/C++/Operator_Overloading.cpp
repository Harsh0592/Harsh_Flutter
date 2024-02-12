//Operator Overloading
#include<iostream>
using namespace std;

class Image{
	int height,width;
	public :
		Image(int h=0, int w=0){
			height=h;
			width=w;
		}
		Image operator +(Image &obj){
			Image result;
			result.height=height + obj.height;
			result.width=width + obj.width;
			return result;
		}
		void print(){
			cout<<"\n"<<height<<" * "<<width;
		}
};
main(){
	Image I1(100, 50), I2(200, 15);
	Image I3 = I1 + I2;
	I3.print();
}
