/*a
  bb
  ccc
  dddd
  eeeee*/
#include<stdio.h>
main(){
	int i,j;
	char alpha = 'a';
	for(i=1;i<=('e' - 'a'+1);i++){
		for(j=1;j<=i;j++){
			printf("%c ",alpha);
		}
		alpha++;
		printf("\n");
	}
}
