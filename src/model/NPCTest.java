package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class NPCTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NPCTest
{
    @Test
    public void NPCtest() {
        Player player1 = new Player("1000");
        Player player2 = new Player("1001");
        Card card = new Card("y_two");
        Card card1 = new Card("y_plus_two");
        player1.getHand().add(card);
        player2.getHand().add(card1);
        NPC newNPC = new NPC(player1);
        NPC newNPC1 = new NPC(player2);
        assertEquals(0, newNPC.playNext(card, 0));
        assertEquals(0, newNPC.playNext(card1, 2));
        assertEquals(true, 4 > newNPC.probability());
        assertEquals(true, (newNPC.wildColor().equals("r") || newNPC.wildColor().equals("g") || newNPC.wildColor().equals("b") || newNPC.wildColor().equals("y")));
        assertEquals(true, (newNPC.probabilityGenerator().equals(true) || newNPC.probabilityGenerator().equals(false)));
    }
}
