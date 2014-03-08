package cli;

import cli.Answer;
import cli.ReadLine;

public class Question{

	public void ask(String question, Answer[] answers){

		System.out.println(question);

		for(int i = 0; i < answers.length; i++){
			String output = String.format("%s - %s", answers[i].code, answers[i].description);
			System.out.println(output);			
		}

		ReadLine reader = new ReadLine();
		String answer = reader.read();

		for(int i = 0; i < answers.length; i++){
			if(answer.equals(answers[i].code)){
				answers[i].effect.execute();
				return;
			}
		}

		ask(question, answers);

	}
}