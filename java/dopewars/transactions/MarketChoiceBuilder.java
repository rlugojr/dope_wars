package dopewars.transactions;

import dopewars.Day;
import dopewars.Product;
import dopewars.transactions.PurchaseBuilder;
import cli.Answer;

public class MarketChoiceBuilder{

	private PurchaseBuilder purchaser;

	public MarketChoiceBuilder(PurchaseBuilder purchaser){
		this.purchaser = purchaser;
	}

	public Answer[] getAnswers(Product[] market, Day day){

		int productCount = countRelevantProducts(market);
		purchaser.addDay(day);

		Answer[] answers = new Answer[productCount];

		int j = 0;
		for(int i = 0; i < market.length; i++){
			if(market[i].quantity > 0){
				Answer answer = getAnswer(market[i], j);
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
		return j;
	}

	private Answer getAnswer(Product product, int index){
		Answer answer = new Answer();
		answer.code = Integer.toString(index);
		answer.description = String.format("buy %s", product.name);
		answer.effect = purchaser.getQuestion(product);

		return answer;
	}
}