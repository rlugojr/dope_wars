package dopewars.transactions;

import dopewars.Game;
import cli.Effect;
import dopewars.Product;
import cli.ReadLine;

public class Purchaser implements Effect{

	private Product product;
	private Game game;

	public Purchaser(Product product, Game game){
		this.product = product;
		this.game = game;
	}
	
	public void execute(){

		System.out.println("How many?");

		ReadLine reader = new ReadLine();
		String answer = reader.read();

		if(isValidPurchase()){
			
		}

	}

	private boolean isValidPurchase(){
		System.out.println("How many?");

		ReadLine reader = new ReadLine();
		String answer = reader.read();

		if(!checkQuantity(answer, product)){
			System.out.println("Not enough in stock!");
			return false;	
		}

		if(!checkPrice(answer, product)){
			System.out.println("Not enough cash!");
		}

		return true;		
	}

	private boolean checkQuantity(String qty, Product product){
		int quantity = Integer.parseInt(qty);
		return quantity <= product.quantity;
	}

	private boolean checkPrice(String qty, Product product){
		int quantity = Integer.parseInt(qty);
		int price = quantity * product.price;
		return price <= game.cash;
	}
}