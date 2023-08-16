package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test of MoveCard class.
 *
 * @author Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class MoveCardTest
{
    // instance variables - replace the example below with your own

    @Test
    public void dtpTest() {
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Card> cards2 = new ArrayList<Card>();
        Card card1 = new Card("y_eight");
        Card card2 = new Card("b_two");
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        MoveCard c = new MoveCard(cards);
        c.dtp(cards2, 2);
        assertEquals(2, cards2.size());
    }

    @Test 
    public void ptpTest() {
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Card> cards2 = new ArrayList<Card>();
        Card card1 = new Card("y_eight");
        Card card2 = new Card("b_two");
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        MoveCard c = new MoveCard(cards);
        c.ptp(cards2, 2);
        assertEquals(card1, cards2.get(0));
    }
    
    @Test
    public void ptdTest() {
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Card> cards2 = new ArrayList<Card>();
        Card card1 = new Card("y_eight");
        Card card2 = new Card("b_two");
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards.add(card1);
        cards2.add(card2);
        cards2.add(card2);
        MoveCard c = new MoveCard(cards);
        c.ptd(cards2);
        assertEquals(6, cards.size());
    }
}
