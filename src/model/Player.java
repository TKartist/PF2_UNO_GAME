package model;

import java.util.ArrayList;

/**
 * It describes the player.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Player
{
    private String playerID;
    private ArrayList<Card> hand;
    private Boolean huno;

    /**
     * it is the constuctor.
     * 
     * @param playerID the id to identify the different playes.
     */
    public Player(String playerID) {
        this.playerID = playerID;
        this.hand = new ArrayList<Card>();
        this.huno = false;
    }

    /**
     * I return the cards that the players has in its hand.
     * 
     * @return the cards that the players has in its hand.
     */
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /**
     * It return if the player has one card.
     * 
     * @return if the player has one card.
     */
    public Boolean hunoState() {
        return this.huno;
    }

    /**
     * it returns the number of cards that the player has in its hand.
     * 
     * @return the number of cards in the hand.
     */
    public int cardCount() {
        return this.hand.size();
    }

    /**
     * it draw a certain amount of card from the deck.
     * 
     * @param deck the deck.
     * @param addCount the number of cards to move.
     */
    public void draw(ArrayList<Card> deck, int addCount) {
        MoveCard deal = new MoveCard(deck);
        deal.dtp(this.hand, addCount);
    }

    /**
     * it change the state of huno from true to false.
     */
    public void hunoSwapper() {
        if (this.huno.equals(false)) {
            this.huno = true;
        } else {
            this.huno = false;
        }
    }

    /**
     *It moves a card from the players to the pile.
     * 
     * @param index of the card
     * @param pile the cards that are in the pile
     */
    public void play(int index, ArrayList<Card> pile) {
        MoveCard move = new MoveCard(this.hand);
        move.ptp(pile, index);
    }
    
    /**
     * Return the designated player ID.
     * 
     * @return player ID of current player
     */
    public String playerID() {
        return this.playerID;
    }
}
