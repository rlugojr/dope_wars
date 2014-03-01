import dopewars.Game;
import cli.ReadLine;
import dopewars.Location;

public class Dopewars {

    public static void main(String[] args) {
        System.out.println("Dopewars Java");
        System.out.println("Please enter your name...");

        ReadLine reader = new ReadLine();
        String input = reader.read();

        Location[] locations = new Location[2];
        Location downtown = new Location();
        downtown.name = "Downtown";
        locations[0] = downtown;
        Location uptown = new Location();
        uptown.name = "Uptown";
        locations[1] = uptown;

        Game game = new Game(input, locations);
        game.start();
    }

}