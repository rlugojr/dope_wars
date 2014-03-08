package dopewars.transactions;

import cli.Effect;
import cli.ReadLine;
import dopewars.Player;
import dopewars.Day;

public class LoanPayback implements Effect{

	private Player player;
	private Day day;

	public LoanPayback(Player player, Day day){
		this.player = player;
		this.day = day;
	}

	public void execute(){
		outputAmountQuestion();
		day.start();
	}

	private void outputAmountQuestion(){
		System.out.println("How much?");
		ReadLine reader = new ReadLine();
		int answer = Integer.parseInt(reader.read());

		if(player.cash >= answer){
			
			player.cash -= answer;
			player.debt -= answer;

			if(player.debt < 0){
				player.cash += (player.debt * -1);
				player.debt = 0;
			}
		}

	}
}