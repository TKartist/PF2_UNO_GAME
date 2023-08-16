package model;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * The test class PlayerTest.
 *
 * @author  Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class PlayerTest
{
    @Test 
    public void drawTest() {
        String id = "0000";
        ArrayList<Card> hand = new ArrayList<Card>();
        Player player = new Player(id);
        Deck deck = new Deck();
        deck.fillDeck();
        int numberCard = 7;
        player.draw(deck.showDeck(),numberCard);
        assertEquals(numberCard, player.cardCount());

    }

    @Test
    public void hunoStateTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Card card = new Card("r_eight");
        player.getHand().add(card);
        assertEquals(false, player.hunoState());
    }
    
    @Test
    public void hunoSwapperTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Card card = new Card("r_eight");
        player.getHand().add(card);
        player.hunoSwapper();
        assertEquals(true, player.hunoState());
    }
    
    @Test
    public void noHunoSwapperTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        Card card = new Card("r_eight");
        player.getHand().add(card);
        player.hunoSwapper();
        player.hunoSwapper();
        assertEquals(false, player.hunoState());
    }
    
    @Test
    public void playerIDTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        Player player = new Player("10001");
        players.add(player);
        assertEquals("10001", player.playerID());
    }
    
    @Test
    public void playTest() {
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Card> pile = new ArrayList<Card>();
        Player player = new Player("10001");
        players.add(player);
        Card card = new Card("r_eight");
        player.getHand().add(card);
        player.play(0, pile);
        assertEquals(0, player.cardCount());
    }
}
