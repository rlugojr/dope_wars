#include<stdio.h>
#include "setup.h"


void startGame();
void setup();

int currentDay = 1;
int currentLocation = 0;
Location locations[2];


int main()
{
	char name[] = "";
    printf("Dopewars in C\n");
    printf("Please enter your name : \n");
    scanf("%s", name);
    printf("Hello, %s\n", name);
    setup();
    startGame();
    return 0;
}

void setup()
{
	Location locations[2];
	getLocations(locations);

}

void startGame()
{
	printf("Day #%d\n", currentDay);
	printf("You are in %s\n", locations[0].name);
}