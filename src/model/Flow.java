package model;

import java.util.ArrayList;

/**
 * Determins which player plays.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Flow
{
    // instance variables - replace the example below with your own
    private ArrayList<Player> players;
    private Player currentPlayer;
    private static int direction = 1;
    private static final int PC = 4; //Player Count

    /**
     * it is the constructor.
     * 
     * @param players is the list of the players that play the game
     * @param initialPlayer is the one who start the game
     */
    public Flow(ArrayList<Player> players, Player initialPlayer) {
        this.players = players;
        this.currentPlayer = initialPlayer;
    }

    /**
     * It determine who will play next.
     * 
     * @return the player who will play next
     */
    public Player normal() {
        int next = nextIndex(currentIndex(), direction);
        this.currentPlayer = players.get(next);
        return this.currentPlayer;
    }
    
    /**
     * It determine who will play next when reverse card is played.
     * 
     * @return the player who will play next
     */
    public Player reverse() {
        reverseDirection();
        int next = nextIndex(currentIndex(), direction);
        this.currentPlayer = players.get(next);
        return this.currentPlayer;
    }
    
    /**
     * It determine who will play next when skip card is played.
     * 
     * @return the player who will play next
     */
    public Player skip() {
        int dir = direction * 2;
        int next = nextIndex(currentIndex(), dir);
        this.currentPlayer = players.get(next);
        return this.currentPlayer;
    }
    
    /**
     * It will change the direction of the game.
     * 
     * @return direction the direction of the game 
     */
    private void reverseDirection() {
        direction = direction * -1;
    }

    /**
     * Every time it will determine the next player as index of player list.
     * 
     * @param index is the current position 
     * @param shift is the direction
     * @return the new player position
     */
    private int nextIndex(int index, int shift) {
        int newIndex = index + shift;
        if (newIndex < 0) {
            newIndex = newIndex + PC;
        } else if (newIndex > 3) {
            newIndex = newIndex - PC;
        }
        return newIndex;
    }

    /**
     * It is the current index of the current player.
     * 
     * @return the index of the current player
     */
    private int currentIndex() {
        return players.indexOf(currentPlayer);
    }
}
