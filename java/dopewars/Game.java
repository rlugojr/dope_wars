package dopewars;

import dopewars.Day;
import dopewars.location.Mover;

public class Game {

	private String name;
	private Location[] allLocations;
	private Location currentLocation;
	private int currentDay;

	public Game(String playerName, Location[] locations){
		name = playerName;
		allLocations = locations;
		currentLocation = locations[0];

		currentDay = 0;
	}

	public void start(){
		String greeting = String.format("Hi, %s!", name);
		System.out.println(greeting);

		nextDay(currentLocation);

		
	}

	public void nextDay(Location newLocation){
		currentDay++;
		currentLocation = newLocation;

		Mover mover = new Mover(this);
		Day day = new Day(currentDay, currentLocation, mover, allLocations);
		day.start();
	}

}