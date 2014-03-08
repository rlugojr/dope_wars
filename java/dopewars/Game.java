package dopewars;

import dopewars.Day;
import dopewars.Product;
import dopewars.Player;
import dopewars.location.Mover;
import dopewars.location.LocationChoiceBuilder;
import dopewars.transactions.PurchaseBuilder;
import dopewars.transactions.MarketChoiceBuilder;

public class Game {

	public Player player;

	private String name;
	private Location[] allLocations;
	private Location currentLocation;
	private int currentDay;
	private Mover mover;
	private LocationChoiceBuilder locationChoiceBuilder;
	private PurchaseBuilder purchaseBuilder;
	private MarketChoiceBuilder marketChoiceBuilder;

	public Game(String playerName, Location[] locations, Player player){
		name = playerName;
		allLocations = locations;
		currentLocation = locations[0];
		this.player = player;
	}

	public void start(){
		currentDay = 0;
		mover = new Mover(this);
		locationChoiceBuilder = new LocationChoiceBuilder(allLocations, mover);

		purchaseBuilder = new PurchaseBuilder(player);
		marketChoiceBuilder = new MarketChoiceBuilder(purchaseBuilder, player);
		
		String greeting = String.format("Hi, %s!", name);
		System.out.println(greeting);

		nextDay(currentLocation);
	}

	public void nextDay(Location newLocation){
		currentDay++;
		currentLocation = newLocation;

		Day day = new Day(currentDay, currentLocation, locationChoiceBuilder, marketChoiceBuilder, player);
		day.start();
	}

}