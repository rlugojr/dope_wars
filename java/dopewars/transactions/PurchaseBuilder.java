package dopewars.transactions;

import dopewars.Player;
import dopewars.Day;
import cli.Effect;
import dopewars.Product;
import dopewars.transactions.Purchaser;
import dopewars.transactions.Sale;

public class PurchaseBuilder{

	private Player player;
	private Day day;

	public PurchaseBuilder(Player player){
		this.player = player;
	}

	public void addDay(Day day){
		this.day = day;
	}
	
	public Effect getPurchaseQuestion(Product product){

		Purchaser purchaser = new Purchaser(product, player, day);
		
		return purchaser;
	}

	public Effect getSaleQuestion(Product product, Product[] market){

		Sale sale = new Sale(product, player, day, market);
		
		return sale;
	}
}
