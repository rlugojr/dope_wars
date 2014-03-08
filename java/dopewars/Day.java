package dopewars;

import dopewars.Player;
import dopewars.Location;
import dopewars.Quit;
import dopewars.location.LocationChoiceBuilder;
import dopewars.transactions.MarketChoiceBuilder;
import cli.Question;
import cli.Answer;

public class Day{

	private Player player;
	private int num;
	private Location location;
	private LocationChoiceBuilder locationChoice;
	private MarketChoiceBuilder marketChoiceBuilder;

	public Day(int num, 
		Location location, 
		LocationChoiceBuilder locationChoice, 
		MarketChoiceBuilder marketChoiceBuilder,
		Player player){
		
		this.num = num;
		this.location = location;
		this.locationChoice = locationChoice;
		this.marketChoiceBuilder = marketChoiceBuilder;
		this.player = player;
	}

	public void start(){

		Question firstAction = new Question();
		Answer[] allAnswers = getAnswers();

		outputIntro();
		firstAction.ask("What would you like to do?", allAnswers);
	}

	private Answer[] getAnswers(){
		Answer[] marketChoices = marketChoiceBuilder.getAnswers(location.market, this);
		Answer[] allAnswers = new Answer[marketChoices.length + 2];

		for(int i = 0; i < marketChoices.length; i++){
			allAnswers[i] = marketChoices[i];
		}
		allAnswers[allAnswers.length - 2] = locationChoice.getLocationChoice(location);
		allAnswers[allAnswers.length - 1] = getExit();

		return allAnswers;
	}

	private void outputIntro(){
		String dayString = String.format("Day %d", num);
		String locationString = String.format("You are in %s.", location.name);
		String availableCash = String.format("You have £%d", player.cash);
		System.out.println(dayString);
		System.out.println(locationString);
		System.out.println(availableCash);

		outputInventory();
		outputMarket();
	}

	private void outputInventory(){
		System.out.println("Inventory:");
		for(int i = 0; i < player.inventory.length; i++){
			if(player.inventory[i].quantity > 0){
				String productInfo = String.format("%s \t%d", player.inventory[i].name, player.inventory[i].quantity);
				System.out.println(productInfo);
			}
		}
	}

	private void outputMarket(){
		System.out.println("Market:");
		for(int i = 0; i < location.market.length; i++){
			if(location.market[i].quantity > 0){
				String productInfo = String.format("%s \t£%d\t%d", location.market[i].name, location.market[i].price, location.market[i].quantity);
				System.out.println(productInfo);
			}
		}
	}

	private Answer getExit(){
		Answer exit = new Answer();
		exit.code = "q";
		exit.description = "quit";
		exit.effect = new Quit();

		return exit;
	}
}