package dopewars.transactions;

import dopewars.Player;
import dopewars.Day;
import cli.Effect;
import dopewars.Product;
import cli.ReadLine;

public class Sale implements Effect{

	private Product product;
	private Player player;
	private Day day;
	private Product[] market;

	public Sale(Product product, Player player, Day day, Product[] market){
		this.product = product;
		this.player = player;
		this.day = day;
		this.market = market;
	}

	
	public void execute(){
		System.out.println("How many?");
		executeSale();
		day.start();
	}

	private void executeSale(){
		ReadLine reader = new ReadLine();
		String answer = reader.read();

		if(isValidSale(answer)){
			player.cash += getPrice(answer);
			addToMarket(answer);
			product.quantity -= Integer.parseInt(answer);
		}
	}

	private void addToMarket(String answer){
		for(int i = 0; i < market.length; i++){
			if(market[i].name == product.name){
				market[i].quantity += Integer.parseInt(answer);
			}
		}
	}

	private boolean isValidSale(String answer){

		if(!checkQuantity(answer)){
			System.out.println("You don't have that many!");
			return false;	
		}

		return true;		
	}

	private int getPrice(String qty){
		int quantity = Integer.parseInt(qty);
		return quantity * product.price;
	}

	private boolean checkQuantity(String qty){
		int quantity = Integer.parseInt(qty);
		return quantity <= getInventoryQuantity();
	}

	private int getInventoryQuantity(){
		int qty = 0;
		for(int i = 0; i < player.inventory.length; i++){
			if(player.inventory[i].name == product.name){
				qty = player.inventory[i].quantity;
			}
		}

		return qty;
	}
}