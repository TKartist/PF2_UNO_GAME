package tui;

import model.HUNO;
import model.Main;
import model.NPC;
import model.Player;

import java.util.ArrayList;

/**
 * Ai to play against.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class AIHuno extends Huno
{
    // instance variables - replace the example below with your own
    private Main main;
    private HUNO huno;
    private Player player;
    private static final String RANDOM = "";

    /**
     * Constructor for objects of class AIHuno.
     * 
     * @param main is the main
     */
    public AIHuno(Main main)
    {
        super(main);
        this.main = main;
        this.huno = new HUNO(main.players());
        this.player = main.playingP();
    }

    /**
     * It call the huno function.
     * 
     * @param ids is the ids of the different players
     */
    @Override
    public void callHuno(ArrayList<String> ids) {
        if (hunoCheck()) {
            NPC ai = new NPC(this.player);
            if (ai.probabilityGenerator()) {
                huno.hunoEffect(huno.personAtHuno().playerID(), this.main.accessDeck());
            } else {
                huno.hunoEffect(RANDOM, this.main.accessDeck());
            }
        } else {
            System.out.println();
        }
    }
}
