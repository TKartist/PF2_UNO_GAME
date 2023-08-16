package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * The test class PileTest.
 *
 * @author  Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class PileTest
{
    @Test
    public void initiatePileTest(){
        Deck deck = new Deck();
        deck.fillDeck();
        Pile cardPile = new Pile(deck.showDeck());
        assertEquals(1, cardPile.numPile());
    }

    @Test
    public void numPileTest(){
        Deck deck = new Deck();
        deck.fillDeck();
        Pile cardPile = new Pile(deck.showDeck());
        assertEquals(1, cardPile.numPile());
        Card card = new Card("r_eight");
        cardPile.pile().add(card);
        assertEquals(2, cardPile.numPile());
    }
    
    @Test
    public void topCardTest(){
        Deck deck = new Deck();
        deck.fillDeck();
        Pile cardPile = new Pile(deck.showDeck());
        assertEquals(1, cardPile.numPile());
        Card card = new Card("r_eight");
        cardPile.pile().add(card);
        assertEquals(card, cardPile.topCard());
    }
    
    @Test
    public void topCardWildTest(){
        ArrayList<Card> deck = new ArrayList<Card>();
        Card card = new Card("n_wild_four");
        deck.add(card);
        Pile cardPile = new Pile(deck);
        assertEquals(1, cardPile.numPile());
    }
    /*
    @Test
    public void topColorTest(){
    Deck deck = new Deck();
    deck.fillDeck();
    Pile cardPile = new Pile(deck.showDeck());
    String color = cardPile.topColor();
    assertEquals(true,  (color.equals("r")) ||
    (color.equals("y")) ||
    (color.equals("b")) ||
    (color.equals("g")) ||
    (color.equals("n")));
    }

    @Test
    public void topValueTest(){
    Deck deck = new Deck();
    deck.fillDeck();
    Pile cardPile = new Pile(deck.showDeck());
    String value = cardPile.topValue();
    assertEquals(true,  (value.equals("zero")) ||
    (value.equals("one")) ||
    (value.equals("two")) ||
    (value.equals("three")) ||
    (value.equals("four")) ||
    (value.equals("five")) ||
    (value.equals("six")) ||
    (value.equals("seven")) ||
    (value.equals("eight")) ||
    (value.equals("nine")) ||
    (value.equals("plus_two")) ||
    (value.equals("wild_four")) ||
    (value.equals("skip")) ||
    (value.equals("reverse")) ||
    (value.equals("wild")));

    }
     */
}
