package dopewars;

import cli.Effect;

public class Quit implements Effect{
	public void execute(){
		System.out.println("Bye!");
	}
}