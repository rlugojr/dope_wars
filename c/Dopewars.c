#include<stdio.h>

#define MAXIMUM_DAYS 30

void startDay();
void nextDay();
void mainChoice();
void moveChoice();


int currentDay = 1;
int currentLocation = 0;
char* locations[3] = { "Downtown", "Uptown", "Docks" };

int main()
{
	char name[] = "";
    printf("Dopewars in C\n");
    printf("Please enter your name : \n");
    scanf("%s", name);
    printf("Hello, %s\n", name);

    startDay();
    return 0;
}

void startDay()
{
	printf("Day #%d\n", currentDay);
	printf("You are in %s\n", locations[currentLocation]);

    mainChoice();
}

void nextDay()
{
    currentDay++;
    if(currentDay < MAXIMUM_DAYS)
    {
        startDay();    
    }
}

void mainChoice()
{
    char option;
    puts("What would you like to do?");
    puts("m - move");
    puts("q - quit");

    scanf(" %c", &option);

    switch(option){
        case 'm':
            moveChoice();
            break;
        case 'q':
            puts("OK, bye!");
            return;
        default:
            mainChoice();
            break;
    }
}

void moveChoice()
{
    int option;
    puts("Where would you like to move?");

    int length = sizeof(locations) / sizeof(locations[0]);
    for(int i = 0; i < length; i++){
        printf("%d - %s\n", i, locations[i]);
    }

    scanf(" %d", &option);

    if(option < length){
        currentLocation = option;
        nextDay();
    }else{
        moveChoice();
    }
}
