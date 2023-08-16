package tui;

import model.Card;
import model.Main;
import model.Player;

import java.util.ArrayList;

/**
 * It is the game class that prints the table.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Game
{

    private ArrayList<String> ids;
    private Main main;

    /**
     * It is the constructor.
     * 
     * @param ids the list of the users
     */
    public Game(ArrayList<String> ids) {
        this.ids = ids;
        main = new Main(ids);
    }

    /**
     * it is the structure of the pile.
     */
    public void playGame() {
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println();
        System.out.println("\t\t\t[X] [X] [X] [X] [X] [X] [X]");
        System.out.println();
        System.out.println();
        System.out.println("--\t\t\t\t\t\t\t\t\t--");
        System.out.println("X\t\t\t\t\t\t\t\t\tX");
        System.out.println("--\t\t\t\t\t\t\t\t\t--");
        System.out.println("--\t\t\t\t\t\t\t\t\t--");
        System.out.println("X\t\t\t\t\t\t\t\t\tX");
        System.out.println("--\t\t\t[*]|\t[" + top().getCard() + "]\t\t\t\t--");
        System.out.println("--\t\t\t[*]|\t\t\t\t\t\t--");
        System.out.println("X\t\t\t\t\t\t\t\t\tX");
        System.out.println("--\t\t\t\t\t\t\t\t\t--");
        System.out.println();
        cardCounts();
        System.out.println();
        System.out.println(playerID());
        System.out.println();
        cardsHand();
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("\t\t\t\t\t\t\t [ QUIT ]");
    }

    /**
     * it shows the cards that the players has in his hand.
     */
    public void cardsHand() {
        String card = "";
        for (int i = 0; i < main.playingP().cardCount(); i++) {
            card = card + "[" + main.playingP().getHand().get(i).getCard() + "]-" + (i + 1) + " ";
        } 
        System.out.println(card);
    }
    
    /**
     * It shows the number of cards each player has.
     */
    private void cardCounts() {
        for (Player player: main.players()) {
            System.out.print(player.playerID() + ":  " + player.cardCount() + "\n");
        }
    }
    
    /**
     * it plays the card on hte pile.
     * 
     * @param index the index of the cards in player's hand
     */
    public void playCard(int index) {
        main.playCard(index);
    }
    
    /**
     * it return the top card.
     * 
     * @return the top card
     */
    public Card top() {
        return main.topCard();
    }
    
    /**
     * Current player's player ID.
     * 
     * @return String value of current playerID
     */
    public String playerID() {
        return main.playingP().playerID();
    }
    
    /**
     * Current player.
     * 
     * @return the current player
     */
    public Player currentPlayer() {
        return main.playingP();
    }

    /**
     * it checks if it is a wild card.
     * 
     * @return if it is a wildcard.
     */
    public Boolean wildCard() {
        return main.wildCard();
    }

    /**
     * It specifies the color of the wild card.
     * 
     * @param color the color of the wild card.
     */
    public void wildColor(String color) {
        main.wildColor(color);
    }
    
    /**
     * Returns if the current player has a valid card to play in his hand.
     * 
     * @return Boolean value representing if there is a card to play
     */
    
    public Boolean canPlay() {
        return main.canPlay(main.topCard());
    }
    
    /**
     * When the player has no card.
     * 
     */
    public void noCard() {
        main.noCard();
    }
    
    /**
     * It call the main class.
     * 
     * @return the main
     */
    public Main main() {
        return main;
    }
}