package dopewars;

import dopewars.Day;

public class Game {

	private String name;

	public Game(String playerName){
		name = playerName;
	}

	public void start(){
		String greeting = String.format("Hi, %s!", name);
		System.out.println(greeting);

		Day day = new Day(1);

		day.start();
	}

}