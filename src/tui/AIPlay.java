package tui;

import model.AggressiveNPC;
import model.NPC;

/**
 * This class allows the ai to play.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class AIPlay extends Play
{
    private Game game;
    private Boolean easy;
    
    /**
     * Constructor for objects of class AIPlay.
     * 
     * @param game is the table/game of the tui
     * @param easy the mode of the ai
     */
    public AIPlay(Game game, Boolean easy)
    {
        super(game);
        this.game = game;
        this.easy = easy;
    }
    
    /**
     * it choose between the aggressive or the normal ai based on how many players are playing.
     * 
     * @return the npc with the right mode of the ai
     */
    public NPC typeAI() {
        NPC ai;
        if (easy) {
            ai = new NPC(this.game.main().playingP()); 
        } else {
            ai = new AggressiveNPC(this.game.main().playingP()); 
        }
        return ai;
    }
    
    /**
     * Play strategy for an Aggressive AI.
     */
    @Override
    public void play()
    {
        NPC ai = typeAI();
        int tmp = ai.playNext(this.game.top(), this.game.main().returnAC());
        this.game.playCard(tmp);
        if (game.wildCard()) {
            game.wildColor(ai.wildColor());
        }
    }
}
