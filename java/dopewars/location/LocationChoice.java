package dopewars.location;

import dopewars.Location;
import dopewars.location.Mover;
import cli.Effect;
import cli.Question;
import cli.Answer;

public class LocationChoice implements Effect{


	private Location[] locations;
	private Mover mover;

	public LocationChoice(Location[] locs, Mover mv){
		locations = locs;
		mover = mv;
	}

	public void execute(){

		LocationMover moveEffect = new LocationMover();

		Question moveWhere = new Question();
		Answer[] answers = new Answer[locations.length];

		for(int i = 0; i < locations.length; i++){
			answers[i] = getAnswer(locations[i], i);
		}

		moveWhere.ask("Where would you like to move?", answers);

	}

	private Answer getAnswer(Location location, int index){
		Answer moveLocation = new Answer();
		moveLocation.code = Integer.toString(index);
		moveLocation.description = location.name;
		moveLocation.effect = new MoveTo(location, mover);
		return moveLocation;
	}

}