package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Write a description of class WildFourText here.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class WildFourTest
{
    @Test
    public void incrementerTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        Player player1 = new Player("10002");
        Player player2 = new Player("10003");
        Player player3 = new Player("10004");
        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Flow flow = new Flow(players, player1);
        Card card = new Card("y_five");
        WildFour wildFour = new WildFour(flow);
        assertEquals(4, wildFour.incrementer(0, card));
    }
}
