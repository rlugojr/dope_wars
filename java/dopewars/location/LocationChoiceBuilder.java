package dopewars.location;

import dopewars.Location;
import dopewars.location.LocationChoice;
import dopewars.location.Mover;
import cli.Question;
import cli.Answer;

public class LocationChoiceBuilder{

	private Location[] allLocations;
	private Mover mover;

	public LocationChoiceBuilder(Location[] locs, Mover mov){
		allLocations = locs;
		mover = mov;
	}

	public Answer getLocationChoice(Location location){

		Location[] locations = new Location[allLocations.length-1];

		int j = 0;
		for(int i = 0; i < allLocations.length; i++){
			if(location != allLocations[i]){
				locations[j++] = allLocations[i];
			}
		}

		LocationChoice moveEffect = new LocationChoice(locations, mover);

		Answer moveLocation = new Answer();
		moveLocation.code = "m";
		moveLocation.description = "Move Locations";
		moveLocation.effect = moveEffect;

		return moveLocation;	

	}
}