package model;

/**
 * This class handle the reverse cards.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Reverse extends ActionCards
{
    
    /**
     * Constructor for objects of class Reverse.
     * 
     * @param flow is the flow
     */
    public Reverse(Flow flow) {
        super(flow);
    }

    /**
     * It returns next player to play the next card.
     *
     * @return reverse the direction of the play and return the previous player.
     */
    @Override
    public Player nextPlayer() {
        return this.getFlow().reverse();
    }
}
