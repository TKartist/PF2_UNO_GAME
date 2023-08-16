package model;

/**
 * This class handle the skip card.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Skip extends ActionCards
{
    
    /**
     * Constructor for Skip class.
     *
     * @param flow the flow
     */
    public Skip(Flow flow) {
        super(flow);
    }
    
    /**
     * It returns the next player to play the next card.
     * 
     * @return returns the next player from current player.
     */
    public Player nextPlayer() {
        return this.getFlow().skip();
    }
}
