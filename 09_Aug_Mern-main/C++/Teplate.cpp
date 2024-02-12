#include<iostream>
using namespace std;
template <typename T> T mymax(T x,T y){
	return(x>y)?x:y;
}
int main(){
	cout<<mymax<int>(12,24)<<endl;
	cout<<mymax<double>(12.4,24.6)<<endl;
	cout<<mymax<char>('g','e')<<endl;
	return 0;
}
