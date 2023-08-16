package tui;

import java.util.HashMap;

/**
 * AIorNot.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class AIorNot
{
    // instance variables - replace the example below with your own
    private HashMap<String, Boolean> ais;
    private Game game;
    private static Play p;
    private static Huno huno;
    private Boolean easy;

    /**
     * Constructor for objects of class AIorNot.
     * 
     * @param ais is the HashMap of the ai
     * @param game is the game
     * @param easy the level of the ai
     */
    public AIorNot(HashMap<String, Boolean> ais, Game game, Boolean easy)
    {
        this.ais = ais;
        this.game = game;
        this.easy = easy;
    }
    
    /**
     * When the ai play.
     * 
     * @return the play of the ai
     */
    public Play decidePlay() {
        Boolean cat = ais.get(game.playerID());
        if (cat) {
            p = new Play(this.game);
        } else {
            p = new AIPlay(this.game, this.easy);
        }
        return p;
    }
    
    /**
     * When the ai calls huno.
     * 
     * @return the huno action
     */
    public Huno decideHuno() {
        Boolean cat = ais.get(game.playerID());
        if (cat) {
            huno = new Huno(this.game.main());
        } else {
            huno = new AIHuno(this.game.main());
        }
        return huno;
    }
}
