package dopewars.transactions;

import dopewars.Player;
import dopewars.Day;
import cli.Effect;
import dopewars.Product;
import cli.ReadLine;

public class Purchaser implements Effect{

	private Product product;
	private Player player;
	private Day day;

	public Purchaser(Product product, Player player, Day day){
		this.product = product;
		this.player = player;
		this.day = day;
	}

	
	public void execute(){

		System.out.println("How many?");



		executePurchase();

		day.start();

	}

	private void executePurchase(){
		ReadLine reader = new ReadLine();
		String answer = reader.read();
		if(isValidPurchase(answer)){
			player.cash -= getPrice(answer);
			addToInventory(answer);
			product.quantity -= Integer.parseInt(answer);
		}
	}

	private void addToInventory(String answer){
		for(int i = 0; i < player.inventory.length; i++){
			if(player.inventory[i].name == product.name){
				player.inventory[i].quantity += Integer.parseInt(answer);
			}
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
		return price <= player.cash;
	}
}