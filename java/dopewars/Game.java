package dopewars;

import dopewars.Day;
import dopewars.location.Mover;
import dopewars.location.LocationChoiceBuilder;

public class Game {

	private String name;
	private Location[] allLocations;
	private Location currentLocation;
	private int currentDay;
	private Mover mover;
	private LocationChoiceBuilder locationChoiceBuilder;

	public Game(String playerName, Location[] locations){
		name = playerName;
		allLocations = locations;
		currentLocation = locations[0];

		currentDay = 0;
	}

	public void start(){
		String greeting = String.format("Hi, %s!", name);
		System.out.println(greeting);

		mover = new Mover(this);
		locationChoiceBuilder = new LocationChoiceBuilder(allLocations, mover);

		nextDay(currentLocation);
	}

	public void nextDay(Location newLocation){
		currentDay++;
		currentLocation = newLocation;

		Day day = new Day(currentDay, currentLocation, locationChoiceBuilder);
		day.start();
	}

}