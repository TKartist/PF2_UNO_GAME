package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * It is the deck that the players aer going to use.
 * it is compose of 108 cads.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Deck
{
    // instance variables - replace the example below with your own
    private static final int CID = 108; // Card IN Deck
    private ArrayList<Card> deck;

    /**
     * Constructor for objects of class Deck.
     */
    public Deck()
    {
        this.deck = new ArrayList<Card>();
    }

    /**
     * Constructor for objects of class Deck.
     * 
     * @param cards are the cards in the deck
     */
    public Deck(ArrayList<Card> cards) {
        this.deck = cards;
    }

    /**
     * It fills the deck with 108 cads generated by the class Card_Gen.
     *
     */
    public void fillDeck() { //108 is the size of the deck 
        int cardCount = 0;
        while (cardCount < CID) {
            Card newCard = CardGen.generate();
            if (cardCount == 0) {
                this.deck.add(newCard);
            } else {
                if (newCard.getValue().equals("zero")) {
                    partialFill(newCard, 1);
                } else if (newCard.getValue().equals("wild")) { 
                    partialFill(newCard, 4);
                } else {
                    partialFill(newCard, 2);
                }
            }
            cardCount += 1;
        }
    }

    /**
     * it check if there are at most 2 cads for each number of the same 
     * color, a part from card 0 that has only one card per color.
     * 
     * @param newCard is the new card that is added to the deck.
     * @param count the number of card with the same value of the same color.
     */
    private void partialFill(Card newCard, int count) {
        int index = 0;
        int tmp = 0;
        int cardInDeck = this.deck.size();
        while (tmp < cardInDeck && index < count) {
            if (this.deck.get(tmp) == newCard) {
                index += 1;
            }
            tmp += 1;
        }
        if (index != count) {
            this.deck.add(newCard);
        }
    }

    /**
     * it show the deck. 
     * 
     * @return it return the deck.
     */
    public ArrayList<Card> showDeck() {
        return this.deck;
    }

    /**
     * It return the size of the deck. 
     * 
     * @return it return the size of the deck.
     */
    public int sizeDeck() {
        return this.deck.size();
    }

    /**
     * it shuffle the deck. 
     * 
     */
    public void shuffle() {
        Collections.shuffle(this.deck);
    }
}
