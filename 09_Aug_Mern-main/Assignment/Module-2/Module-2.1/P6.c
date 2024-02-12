//WAP to convert years into days and days into years
#include <stdio.h>

main() {
    int choice;
    float years, days;

    printf("Choose an option:\n");
    printf("1. Convert years to days\n");
    printf("2. Convert days to years\n");
    scanf("%d", &choice);

    if(choice == 1) {
            printf("Enter the number of years: ");
            scanf("%f", &years);
            days = years * 365.0;
            printf("%.2f years is equal to %.2f days.\n", years, days);
}else if(choice == 2){
            printf("Enter the number of days: ");
            scanf("%f", &days);
            years = days / 365.0;
            printf("%.2f days is equal to %.2f years.\n", days, years);
}else{
            printf("Invalid choice. Please select 1 or 2.\n");
    }
}

