package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Write a description of class WildCardTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WildCardTest
{
    private WildCard wc;
    private Player player;
    private Player player1;
    private Player player2;
    private Player player3;
    private Card card;
    
    public WildCardTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        player = new Player("10001");
        player1 = new Player("10002");
        player2 = new Player("10003");
        player3 = new Player("10004");
        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        card = new Card("n_wild");
        Flow flow = new Flow(players, player1);
        this.wc = new WildCard(this.card, flow);
    }
    
    @Test
    public void colorWildTest() {
        assertEquals("r", this.wc.colorWild("r").getColor());
        assertEquals("wild", this.wc.colorWild("r").getValue());
    }
}
