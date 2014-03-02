package dopewars;

import dopewars.Location;
import dopewars.location.LocationChoiceBuilder;
import cli.Question;
import cli.Answer;

public class Day{

	int num;
	Location location;
	LocationChoiceBuilder locationChoice;

	public Day(int num, Location location, LocationChoiceBuilder locationChoice){
		this.num = num;
		this.location = location;
		this.locationChoice = locationChoice;
	}

	public void start(){
		String dayString = String.format("Day %d", num);
		String locationString = String.format("You are in %s.", location.name);

		Question firstAction = new Question();

		Answer[] allAnswers = getAnswers();
		System.out.println(dayString);
		System.out.println(locationString);

		firstAction.ask("What would you like to do?", allAnswers);
	}

	private Answer[] getAnswers(){
		Answer[] allAnswers = new Answer[1];
		allAnswers[0] = locationChoice.getLocationChoice(location);

		return allAnswers;
	}
}