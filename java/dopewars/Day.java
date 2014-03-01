package dopewars;

import dopewars.Location;
import dopewars.location.LocationChoice;
import dopewars.location.Mover;
import cli.Question;
import cli.Answer;

public class Day{

	int num;
	Location location;
	Mover mover;
	Location[] allLocations;

	public Day(int dayNumber, Location loc, Mover mv, Location[] locations){
		num = dayNumber;
		location = loc;
		mover = mv;
		allLocations = locations;
	}

	public void start(){
		String dayString = String.format("Day %d", num);
		String locationString = String.format("You are in %s.", location.name);

		Location[] locations = new Location[allLocations.length-1];


		int j = 0;
		for(int i = 0; i < allLocations.length; i++){
			if(location != allLocations[i]){
				locations[j++] = allLocations[i];
			}
		}

		LocationChoice moveEffect = new LocationChoice(locations, mover);

		Question firstAction = new Question();
		Answer moveLocation = new Answer();
		moveLocation.code = "m";
		moveLocation.description = "Move Locations";
		moveLocation.effect = moveEffect;

		Answer[] allAnswers = new Answer[1];
		allAnswers[0] = moveLocation;

		System.out.println(dayString);
		System.out.println(locationString);

		firstAction.ask("What would you like to do?", allAnswers);
	}
}