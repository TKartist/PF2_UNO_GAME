package tui;

import model.InputChecker;

import java.util.Scanner;

/**
 * It play the cards on the pile.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Play
{
    // instance variables - replace the example below with your own
    private Game game;
    private Scanner scanner = new Scanner(System.in);

    /**
     * It is the constructor.
     * 
     * @param game the game
     */
    public Play(Game game)
    {
        this.game = game;
    }
    
    /**
     * It check if the card is valid and it plays it.
     *
     */
    public void play()
    {
        System.out.println("Which card do u wanna play?");
        String word = scanner.next();
        InputChecker check = new InputChecker(word);
        if (check.valid(game.main())) {
            this.game.playCard(Integer.parseInt(word) - 1);
            if (game.wildCard()) {
                System.out.println("Assign a color for the wild card");
                System.out.println("r = red, g = green, y = yellow, b = blue");
                String color = scanner.next();
                check = new InputChecker(color);
                if (check.validColor()) {
                    game.wildColor(color);
                } else {
                    play();
                }
            }
        } else {
            System.out.println("Not a valid input");
        }
    }
}
