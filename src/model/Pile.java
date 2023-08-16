package model;

import java.util.ArrayList;

/**
 * This class handles the pile.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Pile
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> cardPile;
    private static final int CIB = 1; //cib: Card In Beginning
    private Card wildFourCard = new Card("n_wild_four");
    private int first = 0;

    /**
     * it is the constructor.
     * 
     * @param deck the deck 
     */
    public Pile(ArrayList<Card> deck) {
        MoveCard deal = new MoveCard(deck);
        ArrayList<Card> initial = new ArrayList<Card>();
        deal.dtp(initial, CIB);
        while (initial.get(first) == wildFourCard) {
            initial.remove(first);
            deal.dtp(initial, CIB);
        }
        this.cardPile = initial;
    }

    /**
     * it return the number of cards on the pile.
     * 
     * @return the number of cards in the pile.
     */
    public int numPile() {
        return this.cardPile.size();
    }

    /**
     * it return the cards pile.
     * 
     * @return the cards pile.
     */
    public ArrayList<Card> pile() {
        return this.cardPile;
    }

    /**
     * the color of the last card  that has been put it down by a players.
     * 
     * @return the color of the last card that has been put it down by a players.
     */
    public Card topCard() {
        return pile().get(numPile() - 1);
    }
}
