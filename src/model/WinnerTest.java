package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class WinnerTest.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class WinnerTest
{
    @Test
    public void winnerTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Winner winners = new Winner(players);
        assertTrue(winners.winner());
    }
    
    @Test
    public void winPlayerTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Winner winners = new Winner(players);
        assertEquals(player, winners.winPlayer());
    }
    
    @Test
    public void noWinnerTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Winner winners = new Winner(players);
        Card card = new Card("r_eight");
        player.getHand().add(card);
        assertFalse(winners.winner());
    }
    
    @Test
    public void noWinPlayerTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Winner winners = new Winner(players);
        Card card = new Card("r_eight");
        player.getHand().add(card);
        assertEquals(null, winners.winPlayer());
    }
}
