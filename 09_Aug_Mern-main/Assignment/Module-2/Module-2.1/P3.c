//WAP to find area of circle, rectangle and triangle
#include<stdio.h>
#define PI 3.14
main(){
	float radius, areaC,areaR,len,wid,areaT,b,h;
     printf("Enter Radius of Circle(cm): ");
     scanf("%f",&radius);
     areaC = PI * radius * radius;
     printf("Area of Circle = %.2f cm\n",radius,areaC);
     printf("\nEnter length & width of Rectangle (cm): ");
     scanf("%f %f",&len,&wid);
     areaR = len * wid;
     printf("Area of Rectangle= %.3f cm\n",areaR);
     printf("\nEnter base and height (cm): ");
     scanf("%f %f", &b, &h);
     areaT = (0.5 * b * h);
     printf("Area of triangle= %.2f cm\n",areaT );
}
