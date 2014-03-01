package dopewars.location;

import dopewars.Game;
import dopewars.Location;

public class Mover{

	Game game;
	public Mover(Game gm){
		game = gm;
	}

	public void move(Location location){
		game.nextDay(location);
	}
}