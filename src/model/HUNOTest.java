package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * The test class HUNOTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HUNOTest
{
    @Test
    public void hunoCheckerTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Card card = new Card("r_eight");
        Card card1 = new Card("r_nine");
        Card card2 = new Card("g_eight");
        ArrayList<Card> listCards = new ArrayList<Card>();
        listCards.add(card);
        HUNO huno = new HUNO(players);
        assertEquals(false, huno.hunoChecker());
        assertEquals(null, huno.personAtHuno());
        player.getHand().add(card);
        huno.hunoEffect("10001", listCards);
        assertEquals(false, huno.hunoChecker());
        player.getHand().add(card1);
        player.getHand().add(card2);
        huno.hunoNull();
        assertEquals(false, player.hunoState());
    }
    
    @Test 
    public void HunoEffectTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        String id = "0000";
        Player player = new Player(id);
        players.add(player);
        ArrayList<Card> listCards = new ArrayList<Card>();
        Card card = new Card("r_eight");
        Card card1 = new Card("r_nine");
        Card card2 = new Card("g_eight");
        listCards.add(card);
        player.getHand().add(card);
        HUNO huno = new HUNO(players);
        player.hunoState();
        assertEquals(true, huno.hunoChecker());
        huno.hunoEffect("0000", listCards);
        assertEquals(true, player.hunoState());
        listCards.add(card1);
        listCards.add(card2);
        huno.hunoEffect("1111", listCards);
        assertEquals(3, player.cardCount());
    }
    
    @Test 
    public void HunoNullTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Card> listCards = new ArrayList<Card>();
        Card card = new Card("r_eight");
        Card card1 = new Card("r_nine");
        listCards.add(card);
        String id = "0000";
        Player player = new Player(id);
        players.add(player);
        player.getHand().add(card);
        HUNO huno = new HUNO(players);
        huno.hunoNull();
        assertEquals(false, player.hunoState());
        huno.hunoEffect("0000", listCards);
        assertEquals(true, player.hunoState());
        huno.hunoNull();
        assertEquals(true, player.hunoState());
        player.getHand().add(card1);
        huno.hunoNull();
        assertEquals(false, huno.hunoChecker());
        assertEquals(false, player.hunoState());
    }
}
