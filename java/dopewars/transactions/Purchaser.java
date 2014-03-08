package dopewars.transactions;

import dopewars.Game;
import dopewars.Day;
import cli.Effect;
import dopewars.Product;
import cli.ReadLine;

public class Purchaser implements Effect{

	private Product product;
	private Game game;
	private Day day;

	public Purchaser(Product product, Game game, Day day){
		this.product = product;
		this.game = game;
		this.day = day;
	}

	
	public void execute(){

		System.out.println("How many?");

		ReadLine reader = new ReadLine();
		String answer = reader.read();

		if(isValidPurchase(answer)){
			game.cash -= getPrice(answer);
		}

	}

	private boolean isValidPurchase(String answer){

		if(!checkQuantity(answer)){
			System.out.println("Not enough in stock!");
			return false;	
		}

		if(!checkPrice(answer)){
			System.out.println("Not enough cash!");
		}

		return true;		
	}

	private int getPrice(String qty){
		int quantity = Integer.parseInt(qty);
		return quantity * product.price;
	}

	private boolean checkQuantity(String qty){
		int quantity = Integer.parseInt(qty);
		return quantity <= product.quantity;
	}

	private boolean checkPrice(String qty){
		int price = getPrice(qty);
		return price <= game.cash;
	}
}