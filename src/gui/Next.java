package gui;

import model.AggressiveNPC;
import model.HUNO;
import model.Main;
import model.NPC;

import javax.swing.JFrame;

/**
 * Write a description of class QUIT here.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Next extends GuiCommand
{
    private static final String RANDOM = "";

    /**
     * Constructor for the class PLAY extending GUICOmmand.
     * 
     * @param main is Main containing current game status
     * @param userInput is a string value of button pressed by user
     * @param frame is the former frame of the game
     */
    public Next(Main main, String userInput, JFrame frame)
    {
        super(main, userInput, frame);
    }

    /**
     * Executes corresponding command of the user action.
     *
     * @param difficulty is the Boolean stating the difficulty of the AIs
     * @param num is an integer stating the number of AIs
     */
    @Override
    public void execute(Boolean difficulty, int num)
    {
        NPC npc;
        if (difficulty) {
            npc = new NPC(getMain().playingP());
        } else {
            npc = new AggressiveNPC(getMain().playingP());
        }
        int index = npc.playNext(getMain().topCard(), getMain().returnAC());
        getMain().playCard(index);
        if (getMain().wildCard()) {
            getMain().wildColor(npc.wildColor());
        }
        HUNO huno = new HUNO(getMain().players());
        huno.hunoNull();
        hunoResult(huno, npc, difficulty);

        getFrame().dispose();
        new Table(getMain(), difficulty, num);
    }
    
    /**
     * check which ai is player and determine if it calls immediatly huno or not.
     * 
     * @param huno if it has one card
     * @param npc the npc 
     * @param difficulty if it is the aggressive or not
     */
    public void hunoResult(HUNO huno, NPC npc, Boolean difficulty) {
        if (huno.hunoChecker()) {
            if (difficulty) {
                if (npc.probabilityGenerator()) {
                    huno.hunoEffect(huno.personAtHuno().playerID(), getMain().accessDeck());
                } else {
                    huno.hunoEffect(RANDOM, getMain().accessDeck());
                }
            } else {
                huno.hunoEffect(huno.personAtHuno().playerID(), getMain().accessDeck());
            }
        }
    }
}
