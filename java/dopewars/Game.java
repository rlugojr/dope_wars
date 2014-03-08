package dopewars;

import dopewars.Day;
import dopewars.Product;
import dopewars.location.Mover;
import dopewars.location.LocationChoiceBuilder;
import dopewars.transactions.PurchaseBuilder;
import dopewars.transactions.MarketChoiceBuilder;

public class Game {

	public int cash;
	public Product[] inventory;

	private String name;
	private Location[] allLocations;
	private Location currentLocation;
	private int currentDay;
	private Mover mover;
	private LocationChoiceBuilder locationChoiceBuilder;
	private PurchaseBuilder purchaseBuilder;
	private MarketChoiceBuilder marketChoiceBuilder;

	public Game(String playerName, Location[] locations, int cash, Product[] inventory){
		name = playerName;
		allLocations = locations;
		currentLocation = locations[0];
		this.cash = cash;
		this.inventory = inventory;
	}

	public void start(){
		currentDay = 0;
		mover = new Mover(this);
		locationChoiceBuilder = new LocationChoiceBuilder(allLocations, mover);

		purchaseBuilder = new PurchaseBuilder(this);
		marketChoiceBuilder = new MarketChoiceBuilder(purchaseBuilder);
		
		String greeting = String.format("Hi, %s!", name);
		System.out.println(greeting);

		nextDay(currentLocation);
	}

	public void nextDay(Location newLocation){
		currentDay++;
		currentLocation = newLocation;

		Day day = new Day(currentDay, currentLocation, locationChoiceBuilder, marketChoiceBuilder);
		day.start();
	}

}