package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class MainTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MainTest
{
    private static final int ONE = 1;
    @Test
    public void generalTest(){
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("1000");
        ids.add("1001");
        ids.add("AI1");
        ids.add("AI2");
        Card card = new Card("n_wild");
        Main main = new Main(ids);
        assertEquals(4, main.players().size());
        assertEquals(79, main.accessDeck().size());
        Card wildCard = new Card("n_wild");
        assertEquals(7, main.handSize());
        Player current = main.playingP();
        assertEquals(current, main.playingP());
        assertEquals(0, main.returnAC());
        assertEquals(0, main.topIndex());
        main.playingP().getHand().add(card);
        main.playCard(7);
        main.wildColor("r");
        assertEquals("r_wild", main.topCard().getCard());
        Card card1 = new Card("n_wild_four");
        Card card2 = new Card("r_plus_two");
        Card card3 = new Card("y_skip");
        Card card4 = new Card("r_reverse");
        main.playingP().getHand().add(card1);
        main.playingP().getHand().add(card2);
        main.playingP().getHand().add(card3);
        main.playingP().getHand().add(card4);
        assertEquals(true, main.canPlay(main.topCard()));
        main.playCard(8);
        assertEquals(2, main.returnAC());
        Player instant = main.playingP();
        int count = instant.cardCount() + 2;
        main.noCard();
        assertEquals(count, instant.cardCount());
        instant = main.playingP();
        count = instant.cardCount() + 1;
        main.noCard();
        assertEquals(count, instant.cardCount());
        main.playingP().getHand().add(card3);
        instant = main.playingP();
        main.playCard(7);
        assertEquals(instant, main.playingP());
    }
    
    @Test
    public void remainderTest() {
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("1000");
        ids.add("1001");
        ids.add("AI1");
        ids.add("AI2");
        Card card = new Card("n_wild");
        Main main = new Main(ids);
        main.playingP().getHand().add(card);
        main.playCard(7);
        main.wildColor("r");
        main.playingP().getHand().remove(6);
        main.playingP().getHand().remove(5);
        main.playingP().getHand().remove(4);
        main.playingP().getHand().remove(3);
        main.playingP().getHand().remove(2);
        main.playingP().getHand().remove(1);
        main.playingP().getHand().remove(0);
        Card card1 = new Card("y_two");
        main.playingP().getHand().add(card1);
        assertEquals(false, main.canPlay(main.topCard()));
    }
    
    @Test
    public void remainderTest1() {
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("1000");
        ids.add("1001");
        ids.add("AI1");
        ids.add("AI2");
        Card card = new Card("n_wild_four");
        Main main = new Main(ids);
        main.playingP().getHand().add(card);
        main.playCard(7);
        main.wildColor("y");
        assertEquals(true, main.wildCard());
    }
}
