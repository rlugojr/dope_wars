import dopewars.Game;
import cli.ReadLine;

public class Dopewars {

    public static void main(String[] args) {
        System.out.println("Dopewars Java");
        System.out.println("Please enter your name...");

        ReadLine reader = new ReadLine();
        String input = reader.read();

        Game game = new Game(input);
        game.start();
    }

}