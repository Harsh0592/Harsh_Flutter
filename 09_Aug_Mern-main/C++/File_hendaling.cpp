/* 

fstrem : for file oprations.
ofstream : to write data into file.
ifstream : to read data from file.

 */
#include<iostream>
#include<fstream>
using namespace std;

main(){
	ofstream fout;
	fout.open("FirstFile.txt",ios::app);
	fout<<"Hello C++ Programming!!\n";
	fout.close();
	ifstream fin;
	string line;
	fin.open("FirstFile.txt");
	while(getline(fin, line)) {
		cout<<line;
	}
	fin.close();
	
}
