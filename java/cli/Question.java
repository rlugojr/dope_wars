package cli;

import cli.Answer;
import cli.ReadLine;

public class Question{

	public Question(){

	}

	public ask(String question, Answer[] answers){

		System.out.println(question);

		for(int i = 0; i < answers.length; i++){
			System.out.println(answers[i].description);			
		}

		ReadLine reader = new ReadLine();
		String answer = reader.read();

		for(int i = 0; i < answers.length; i++){
			if(answer == answers[i].code){
				answers[i].effect.execute();
			}
		}

	}
}