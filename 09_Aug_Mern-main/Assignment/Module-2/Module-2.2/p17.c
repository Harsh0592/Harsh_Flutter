/* 1
   2 3
   4 5 6
   7 8 9 10
   1112131415 */
#include <stdio.h>  
main(){  
   int i, j, number = 1;    
   for (i = 1; i <= 5; i++)   
   {  
         for (j = 1; j <= i; ++j)  
            {  
                      printf("%d\t", number);  
                      ++number;  
         }  
      printf("\n");  
   }    
}  
