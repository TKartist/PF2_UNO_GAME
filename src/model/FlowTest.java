package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Write a description of class FlowTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlowTest
{
    @Test
    public void cardPlayedTest() {
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
    }
    
    @Test
    public void nextPlayerTest() {
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
        Skip skip = new Skip(flow);
        assertEquals(player3, skip.nextPlayer());
        assertEquals(player, flow.normal());
    }
    
    @Test
    public void reverseTest() {
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
        Reverse reverse = new Reverse(flow);
        assertEquals(player, reverse.nextPlayer());
        assertEquals(player3, flow.normal());
    }
}
