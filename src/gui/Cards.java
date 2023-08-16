package gui;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * It load all the image of the cards.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Cards {
    
    private HashMap<String, String> map;
    private ArrayList<String> deck;
    private static final String[] COLOR = new String[]{"r", "g", "b", "y"};
    private static final String[] VALUE = new String[]{"zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine", "plus_two", "skip", "reverse", "wild", "wild_four"};
    
    /** 
     * it is the constructor of the cards class.
     */
    public Cards() {
        map = new HashMap();
        deck = new ArrayList<String>();
    }
    
    /**
     * it fills the deck.
     * 
     * @return an array list of all the cards
     */
    private ArrayList<String> fillDecks() {
        for (int i = 0; i < COLOR.length; i ++) {
            for (int j = 0; j < VALUE.length; j++) {
                String card = COLOR[i] + "_" + VALUE[j];
                deck.add(card);
            }
        }
        deck.add("n_wild");
        deck.add("n_wild_four");
        return deck;
    }
    
    /**
     * it put all the cards insiede an hash map so we can use the image of that card.
     */
    public void fillMap() {
        ArrayList<String> cardDeck = fillDecks();
        for (String card: cardDeck) {
            String address = "image/" + card + ".png";
            map.put(card, address);
        }   
    }
    
    /**
     * get method for returning the hasmap.
     * 
     * @return hasmap of the cards and the path of the image
     */
    public HashMap<String, String> getMap() {
        return map;
    }
}

