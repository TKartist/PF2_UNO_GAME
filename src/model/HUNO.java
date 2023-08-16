package model;

import java.util.ArrayList;

/**
 * This class handle the huno fuction.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class HUNO extends CardIncrement
{
    // instance variables - replace the example below with your own
    private ArrayList<Player> players;
    private static final int UNO = 1;
    private static final Boolean HUNO = true;
    private static final Boolean NOHUNO = false;
    private static final int PENALTY = 2;

    /**
     * it calls the constructor of CardIncrement.
     * 
     * @param players is the player
     */
    public HUNO(ArrayList<Player> players) {
        super();
        this.players = players;
    }

    /**
     * It dertemines if one of the players have two cards in their hand.
     * 
     * @return Bolean value saying player has two cards
     */
    public Boolean hunoChecker() {
        for (Player player: this.players) {
            if (player.cardCount() == UNO && player.hunoState().equals(false)) {
                return HUNO;
            } else {
                continue;
            }
        } 
        return NOHUNO; 
    }

    /**
     * if the player does not call huno.
     */
    public void hunoNull() {
        for (Player player: this.players) {
            if (player.cardCount() > UNO && player.hunoState().equals(true)) {
                player.hunoSwapper();
            } else {
                continue;
            }
        }  
    }

    /**
     * the player that calls huno action.
     * 
     * @return the person that calls huno action
     */
    public Player personAtHuno() {
        for (Player player: this.players) {
            if (player.cardCount() == UNO) {
                return player;
            } else {
                continue;
            }
        }
        return null;
    }

    /**
     * If the player calls the action the next turn will not receive the penalty.
     * 
     * @param ids the ids of the player 
     * @param deck the arraylist of the cards
     */
    public void hunoEffect(String ids, ArrayList<Card> deck) {
        if (personAtHuno().playerID().equals(ids)) {
            personAtHuno().hunoSwapper();
        } else {
            personAtHuno().draw(deck, PENALTY);
        }
    }
}
