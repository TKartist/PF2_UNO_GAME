package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test of GameLogic class.
 *
 * @author Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class GameLogicTest
{
    // instance variables - replace the example below with your own
    @Test
    public void correctCardTest() {
        GameLogic cardLogic = new GameLogic("r", "two");
        GameLogic cardLogic1 = new GameLogic("r", "plus_two");
        Card card1 = new Card("r_two");
        Card card2 = new Card("n_wild");
        Card card3 = new Card("b_three");
        Card card4 = new Card("r_plus_two");
        Card card5 = new Card("n_wild_four");
        assertEquals(true, cardLogic.correctCard(card1, 0));
        assertEquals(true, cardLogic.correctCard(card2, 0));
        assertEquals(false, cardLogic.correctCard(card3, 0));
        assertEquals(true, cardLogic.correctCard(card5, 0));
        assertEquals(false, cardLogic1.correctCard(card1, 2));
        assertEquals(true, cardLogic1.correctCard(card4, 2));
    }
    
    @Test
    public void canPlayTest() {
        GameLogic logic = new GameLogic("r", "wild_four");
        GameLogic logic1 = new GameLogic("r", "plus_two");
        GameLogic logic2 = new GameLogic("g", "reverse");
        Card card1 = new Card("n_wild_four");
        Card card2 = new Card("n_wild");
        Card card3 = new Card("r_plus_two");
        Card card4 = new Card("y_two");
        Card card5 = new Card("r_reverse");
        assertEquals(true, logic.canPlay(card1, 0));
        assertEquals(false, logic.canPlay(card2, 4));
        assertEquals(true, logic.canPlay(card2, 0));
        assertEquals(true, logic1.canPlay(card3, 2));
        assertEquals(false, logic1.canPlay(card2, 2));
        assertEquals(true, logic1.canPlay(card2, 0));
        assertEquals(true, logic2.canPlay(card2, 0));
        assertEquals(false, logic2.canPlay(card4, 0));
        assertEquals(true, logic2.canPlay(card5, 0));
    }
}
