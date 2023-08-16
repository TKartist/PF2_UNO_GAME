package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class AggressiveNPCTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AggressiveNPCTest
{
    @Test
    public void AggressiveNPCTest() {
        Player player = new Player("1000");
        Player player1 = new Player("1001");
        Player player2 = new Player("1002");
        Player player3 = new Player("1003");
        Player player4 = new Player("1004");
        Card card = new Card("y_two");
        Card card1 = new Card("y_plus_two");
        Card card2 = new Card("y_reverse");
        Card card3 = new Card("r_skip");
        Card card4 = new Card("n_wild_four");
        Card card5 = new Card("r_two");
        Card card6 = new Card("b_one");
        Card card7 = new Card("g_two");
        player.getHand().add(card);
        player.getHand().add(card2);
        AggressiveNPC npc = new AggressiveNPC(player);
        assertEquals(2, npc.playNext(card2, 0));
        player1.getHand().add(card4);
        player1.getHand().add(card3);
        player1.getHand().add(card2);
        player1.getHand().add(card2);
        player1.getHand().add(card2);
        AggressiveNPC npc1 = new AggressiveNPC(player1);
        assertEquals(2, npc1.playNext(card5, 0));
        assertEquals(1, npc1.playNext(card1, 2));
        assertEquals("y", npc1.wildColor());
        player2.getHand().add(card3);
        player2.getHand().add(card3);
        player2.getHand().add(card3);
        player2.getHand().add(card1);
        player2.getHand().add(card4);
        AggressiveNPC npc2 = new AggressiveNPC(player2);
        assertEquals("r", npc2.wildColor());
        player3.getHand().add(card6);
        player3.getHand().add(card6);
        player3.getHand().add(card6);
        player3.getHand().add(card1);
        AggressiveNPC npc3 = new AggressiveNPC(player3);
    }
}
