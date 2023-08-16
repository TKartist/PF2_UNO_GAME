package model;

import java.util.ArrayList;

/**
 * It determine the winner.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Winner
{
    private ArrayList<Player> players;

    /**
     * it is the constructor.
     * 
     * @param players the player that win the game
     */
    public Winner(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Determin if someone has won the game or not.
     * 
     * @return deck the deck 
     */
    public Boolean winner() {
        for (Player player: players) {
            return noCard(player);
        }
        return false;
    }

    /**
     * Determine if players has no cards.
     * 
     * @param player the player 
     * @return if the player has no cards.\
     */
    private Boolean noCard(Player player) {
        return player.cardCount() == 0;
    }

    /**
     * It determines which player won.
     * 
     * @return the player who won
     */
    public Player winPlayer() {
        for (Player player: players) {
            if (noCard(player) == true) {
                return player;
            }
        } 
        return null;
    }
}
