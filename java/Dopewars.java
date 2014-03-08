import dopewars.Game;
import dopewars.Player;
import dopewars.Product;
import cli.ReadLine;
import dopewars.Location;

public class Dopewars {

    public static void main(String[] args) {
        System.out.println("Dopewars Java");
        System.out.println("Please enter your name...");

        ReadLine reader = new ReadLine();
        String input = reader.read();

        Location[] locations = getLocations();

        int cash = 100;

        Player player = new Player();
        player.cash = cash;
        player.inventory = getMarket();
        player.debt = 100;

        Game game = new Game(input, locations, player);
        game.start();
    }

    private static Location[] getLocations(){
        Location[] locations = new Location[3];
        locations[0] =  new Location("Downtown", getMarket());
        locations[1] = new Location("Uptown", getMarket());
        locations[2] = new Location("Docks", getMarket());;
        return locations;
    }

    private static Product[] getMarket(){
        Product[] market = new Product[5];
        market[0] = new Product("Cannabis", 5, 50);
        market[1] = new Product("Cocaine", 15, 250);
        market[2] = new Product("Heroin", 25, 175);
        market[3] = new Product("Mushrooms", 5, 35);
        market[4] = new Product("LSD", 5, 50);
        return market;
    }

}