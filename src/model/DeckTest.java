package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class DeckTest.
 *
 * @author  Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class DeckTest
{
    @Test 
    public void fillDeckTest() {
        Deck deck = new Deck();
        int cardInDeck = 107;
        deck.fillDeck();
        String color = deck.showDeck().get(cardInDeck).getColor();
        assertEquals(true,  (color.equals("r")) ||
            (color.equals("y")) ||
            (color.equals("b")) ||
            (color.equals("g")) ||
            (color.equals("n")));
    }

    @Test
    public void showDeckTest() {
        Deck deck = new Deck();
        deck.fillDeck();
        
        assertEquals(true, (deck.showDeck().size() == 108));
        assertEquals(false, (deck.showDeck().size() == 42));
    }
    
    @Test
    public void sizeDeckTest() {
        Deck deck = new Deck();
        deck.fillDeck();
        
        assertEquals(true, (deck.sizeDeck() == 108));
    }
    
    @Test 
    public void shuffleDeckTest() {
        ArrayList<Card> list = new ArrayList<Card>();
        Deck deckOne = new Deck(list);
        Deck deck = new Deck();
        deck.fillDeck();
        deck.shuffle();
        
        assertEquals(true, (deck.sizeDeck() == 108));
    }
}
