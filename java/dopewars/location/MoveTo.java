package dopewars.location;

import dopewars.Location;
import cli.Effect;
import dopewars.location.Mover;

public class MoveTo implements Effect{

	private Location location;
	private Mover mover;

	public MoveTo(Location loc, Mover mv){
		location = loc;
		mover = mv;
	}

	public void execute(){
		mover.move(location);
	}
}