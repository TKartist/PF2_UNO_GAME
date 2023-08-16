package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * It is the Aggressive Ai.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class AggressiveNPC extends NPC
{
    // instance variables - replace the example below with your own
    private Player player;
    private static final String[] CARDS = new String[]{"plus_two", "skip", "reverse", "wild_four", "wild", "zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"};
    private static final int NONE = 0;
    private static Integer redC = 0;
    private static Integer yellowC = 0;
    private static Integer greenC = 0;
    private static Integer blueC = 0;
    private static final String RED = "r";
    private static final String YELLOW = "y";
    private static final String GREEN = "g";
    private static String[] colors = new String[]{RED, YELLOW, GREEN, BLUE};
    
    /**
     * Constructor for objects of class AggresiveAI.
     * 
     * @param player the player
     */
    public AggressiveNPC(Player player)
    {
        super(player);
        this.player = player;
    }
    
    /**
     * Gives the index of most aggressive card that can be played.
     * 
     * @param topCard is the Card which is on top of the pile
     * @param incCount is the integer representing increment count
     * @return integer representing the index of most aggressive 
     *  card according to priority list Cards
     */
    @Override
    public int playNext(Card topCard, int incCount) {
        String color = topCard.getColor();
        String value = topCard.getValue();
        GameLogic logic = new GameLogic(color, value);
        int counter = 0;
        for (String cardVal: CARDS) {
            counter = search(cardVal, logic, incCount);
            if (counter != NONE) {
                return counter;
            }
        }
        return counter;
    }
    
    /**
     * Finds the index of card that can be played and also matches the priority card.
     * 
     * @param cardVal is the string representing the value that is on top priority at the moment
     * @param logic is the GameLogic at the moment
     * @param incCount is the integer count of cards to be incremented
     * @return integer index of card in hand that match all conditions
     */
    public int search(String cardVal, GameLogic logic, int incCount) {
        for (Card card: this.player.getHand()) {
            if (card.getValue().equals(cardVal)) {
                if (logic.correctCard(card, incCount)) {
                    return this.player.getHand().indexOf(card) + 1;
                } else {
                    continue;
                }
            }
        }
        return NONE;
    }
    
    /**
     * Returns the new wild color as the most common color in the AI's hand.
     * 
     * @return String of most common color in the AI's hand
     */
    @Override
    public String wildColor() {
        for (Card card: this.player.getHand()) {
            switch (card.getColor()) {
                case RED: redC += 1;
                break;
                case YELLOW: yellowC += 1;
                break;
                case GREEN: greenC += 1;
                break;
                default: blueC += 1;
                break;
            }
        }
        ArrayList<Integer> col = new ArrayList<Integer>();
        col.add(redC); 
        col.add(yellowC); 
        col.add(greenC); 
        col.add(blueC);
        int max = Collections.max(col);
        int maxIndex = col.indexOf(max);
        return colors[maxIndex];
    }
}
