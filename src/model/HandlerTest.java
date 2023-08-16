package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class HandlerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HandlerTest
{
    
    @Test
    public void getCMDTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("101");
        Player player1 = new Player("102");
        Player player2 = new Player("103");
        Player player3 = new Player("104");
        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Flow flow = new Flow(players, player);
        Card card = new Card("y_five");
        Card card1 = new Card("b_plus_two");
        Card card2 = new Card("n_wild_four");
        Card card3 = new Card("g_skip");
        Card card4 = new Card("y_reverse");
        Handler handler = new Handler(card, flow);
        assertEquals(0, handler.getCMD().incrementer(0, card));
        assertEquals(player3, handler.getCMD().nextPlayer());
        Handler handler1 = new Handler(card1, flow);
        assertEquals(2, handler1.getCMD().incrementer(0, card1));
        assertEquals(player2, handler1.getCMD().nextPlayer());
        Handler handler2 = new Handler(card2, flow);
        assertEquals(4, handler2.getCMD().incrementer(0, card2));
        assertEquals(player1, handler2.getCMD().nextPlayer());
        Handler handler3 = new Handler(card3, flow);
        assertEquals(0, handler3.getCMD().incrementer(0, card3));
        assertEquals(player3, handler3.getCMD().nextPlayer());
        Handler handler4 = new Handler(card4, flow);
        assertEquals(0, handler4.getCMD().incrementer(0, card4));
        assertEquals(player, handler4.getCMD().nextPlayer());
        assertEquals(player1, handler1.getCMD().nextPlayer());
        assertEquals(player, handler4.getCMD().nextPlayer());
    }
}
