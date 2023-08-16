package model;

import java.util.ArrayList;

/**
 * This class it is use to move the card around. From the deck to 
 * the players, from the players to the pile, from the pile to the deck.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class MoveCard
{
    private ArrayList<Card> cards;

    /** 
     * it is the constructor.
     * 
     * @param cards can be any list of cards of the game
     */
    public MoveCard(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * it add a number of card to the hand of the players.
     * 
     * @param hand the cards that has the player in that moment.
     * @param count the number of cards that the players is taking.
     */
    public void dtp(ArrayList<Card> hand, int count) { //dtp: Deck To Player
        int index = 0;
        while (index < count) {
            int size = this.cards.size();
            hand.add(this.cards.get(size - 1));
            index += 1;
            this.cards.remove(size - 1);
        }
    }

    /**
     * it move one card from the player hand to the pile.
     * 
     * @param end the card on the pile.
     * @param index is the index using for chosing one card from the cards that the players has.
     * 
     */
    public void ptp(ArrayList<Card> end, int index) { // ptp: player to pile
        Card played = this.cards.get(index);
        end.add(played);
        this.cards.remove(index);
    }

    /**
     * in the case that the deck runs out of cards, the deck 
     * will be shuffle in order to keep playing.
     * 
     * @param currentDeck is the current deck
     * @return the deck
     */
    public Deck ptd(ArrayList<Card> currentDeck) { // ptd: pile to deck
        Deck deck = new Deck(this.cards);
        for (Card card : currentDeck) {
            deck.showDeck().add(card);
        }
        deck.showDeck().remove(deck.showDeck().size() - 1);
        return deck;
    }

}
