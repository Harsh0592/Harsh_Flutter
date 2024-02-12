/*WAP to make simple calculator (operation include Addition, Subtraction,
Multiplication, Division, modulo)*/
#include <stdio.h>

int main() {

  int op;
  float a,b;
  printf("Select tha Operations : \n");
  printf("1.Adition \n");
  printf("2.Subtraction \n");
  printf("3.Multiplication \n");
  printf("4.Division \n");
  printf("5.Modulo \n");
  printf("6.All");
  scanf("%d", &op);
  printf("Enter two Numbers : ");
  scanf("%f %f", &a, &b);
  if(op == 1) {
      printf("%.1f + %.1f = %.1f", a, b, a + b);
}else if(op == 2) {
      printf("%.1f - %.1f = %.1f", a, b, a - b);
}else if(op == 3){
      printf("%.1f * %.1f = %.1f", a, b, a * b);
  }else if(op == 4){
      printf("%.1f / %.1f = %.1f", a, b, a / b);
}else if(op == 5){
      printf("%f % %f = %f", a, b, a % b);
}else if(op == 6){
	printf("%.1f + %.1f = %.1f", a, b, a + b);
    printf("%.1f - %.1f = %.1f", a, b, a - b);
    printf("%.1f * %.1f = %.1f", a, b, a * b);
    printf("%.1f / %.1f = %.1f", a, b, a / b);
    printf("%f % %f = %f", a, b, a % b);
}else{
      printf("Error!Enter Number Between 1 to 6");
  }
}

