#include<iostream>
#include<string.h>
using namespace std;

class ConcateString
{
	public :
		char str[100];
		ConcateString(){ }
		ConcateString(char str[]){
			strcpy(this->str,str);
		}
		ConcateString operator+(ConcateString &S){
			ConcateString obj;
			strcat(this->str,S.str);
			strcpy(obj.str,this->str);
			return obj;
		}
};

main(){
	char str1[]="HelloC ";
	char str2[]="World";
	
	ConcateString CS1(str1);
	ConcateString CS2(str2);
	
	ConcateString CS3;
	
	CS3 = CS1 + CS2;
	
	cout<<"\nAfter Concatenate : "<<CS3.str;
}
