package dopewars.transactions;

import dopewars.Game;
import cli.Effect;
import dopewars.Product;
import dopewars.transactions.Purchaser;

public class PurchaseBuilder{

	private Game game;

	public PurchaseBuilder(Game game){
		this.game = game;
	}
	
	public Effect getQuestion(Product product){

		Purchaser purchaser = new Purchaser(product, game);
		
		return purchaser;
	}
}
