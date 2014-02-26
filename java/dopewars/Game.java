package dopewars;

public class Game {

	String name;

	public Game(String playerName){
		name = playerName;

	}

	public void start(){
		String greeting = String.format("Hi, %s!", name);
		System.out.println(greeting);
	}

}