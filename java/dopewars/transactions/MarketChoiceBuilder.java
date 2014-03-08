package dopewars.transactions;

import dopewars.Player;
import dopewars.Day;
import dopewars.Product;
import dopewars.transactions.PurchaseBuilder;
import cli.Answer;

public class MarketChoiceBuilder{

	private PurchaseBuilder purchaser;
	private Player player;

	public MarketChoiceBuilder(PurchaseBuilder purchaser, Player player){
		this.purchaser = purchaser;
		this.player = player;
	}

	public Answer[] getAnswers(Product[] market, Day day){

		int productCount = countRelevantProducts(market);
		purchaser.addDay(day);

		Answer[] answers = new Answer[productCount];

		int j = 0;

		for(int i = 0; i < player.inventory.length; i++){
			if(player.inventory[i].quantity > 0 ){
				Answer answer = getSaleAnswer(player.inventory[i], j, market);
				answers[j++] = answer;
			}
		}

		for(int i = 0; i < market.length; i++){
			if(market[i].quantity > 0 ){
				Answer answer = getPurchaseAnswer(market[i], j);
				answers[j++] = answer;
			}
		}

		return answers;
	}


	private int countRelevantProducts(Product[] market){
		int j = 0;
		for(int i = 0; i < market.length; i++){
			if(market[i].quantity > 0){
				j++;
			}
		}

		for(int i = 0; i < player.inventory.length; i++){
			if(player.inventory[i].quantity > 0){
				j++;
			}
		}
		return j;
	}

	private Answer getPurchaseAnswer(Product product, int index){
		Answer answer = new Answer();
		answer.code = Integer.toString(index);
		answer.description = String.format("buy %s", product.name);
		answer.effect = purchaser.getPurchaseQuestion(product);

		return answer;
	}

	private Answer getSaleAnswer(Product product, int index, Product[] market){
		Answer answer = new Answer();
		answer.code = Integer.toString(index);
		answer.description = String.format("sell %s", product.name);
		answer.effect = purchaser.getSaleQuestion(product, market);

		return answer;
	}
}