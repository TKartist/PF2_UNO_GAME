package tui;


import model.HUNO;
import model.Main;
import model.Player;

import java.util.ArrayList;

/**
 * This class define the Aggressive Ai thatr is activated based on how many players are playing.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class AggressiveHuno extends Huno
{
    // instance variables - replace the example below with your own
    private Main main;
    private HUNO huno;

    /**
     * Constructor for objects of class AIHuno.
     * 
     * @param main is the main
     */
    public AggressiveHuno(Main main)
    {
        super(main);
        this.main = main;
        this.huno = new HUNO(main.players());
        Player player = main.playingP();
    }

    /**
     * It call the huno function.
     * 
     * @param ids is the ids of the different players
     */
    @Override
    public void callHuno(ArrayList<String> ids) {
        if (hunoCheck()) {
            huno.hunoEffect(huno.personAtHuno().playerID(), this.main.accessDeck());
        } else {
            System.out.println();
        }
    }
}
