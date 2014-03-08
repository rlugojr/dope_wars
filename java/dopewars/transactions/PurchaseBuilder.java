package dopewars.transactions;

import dopewars.Game;
import dopewars.Day;
import cli.Effect;
import dopewars.Product;
import dopewars.transactions.Purchaser;

public class PurchaseBuilder{

	private Game game;
	private Day day;

	public PurchaseBuilder(Game game){
		this.game = game;
	}

	public void addDay(Day day){
		this.day = day;
	}
	
	public Effect getQuestion(Product product){

		Purchaser purchaser = new Purchaser(product, game, day);
		
		return purchaser;
	}
}
