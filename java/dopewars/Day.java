package dopewars;

import dopewars.Location;
import dopewars.location.LocationChoiceBuilder;
import dopewars.transactions.MarketChoiceBuilder;
import cli.Question;
import cli.Answer;

public class Day{

	private int num;
	private Location location;
	private LocationChoiceBuilder locationChoice;
	private MarketChoiceBuilder marketChoiceBuilder;

	public Day(int num, 
		Location location, 
		LocationChoiceBuilder locationChoice, 
		MarketChoiceBuilder marketChoiceBuilder){
		
		this.num = num;
		this.location = location;
		this.locationChoice = locationChoice;
		this.marketChoiceBuilder = marketChoiceBuilder;
	}

	public void start(){

		Question firstAction = new Question();
		Answer[] allAnswers = getAnswers();

		outputIntro();
		firstAction.ask("What would you like to do?", allAnswers);
	}

	private Answer[] getAnswers(){
		Answer[] marketChoices = marketChoiceBuilder.getAnswers(location.market);
		Answer[] allAnswers = new Answer[marketChoices.length + 1];

		for(int i = 0; i < marketChoices.length; i++){
			allAnswers[i] = marketChoices[i];
		}
		allAnswers[allAnswers.length - 1] = locationChoice.getLocationChoice(location);

		return allAnswers;
	}

	private void outputIntro(){
		String dayString = String.format("Day %d", num);
		String locationString = String.format("You are in %s.", location.name);
		System.out.println(dayString);
		System.out.println(locationString);

		outputMarket();

	}

	private void outputMarket(){
		for(int i = 0; i < location.market.length; i++){
			if(location.market[i].quantity > 0){
				String productInfo = String.format("%s \t£%d\t%d", location.market[i].name, location.market[i].price, location.market[i].quantity);
				System.out.println(productInfo);
			}
		}
	}
}