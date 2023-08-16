package model;


/**
 * It it the super class for all the subclasses of the diffrent cards.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class ActionCards
{
    private Flow flow;
    private static final int ZERO = 0;

    /**
     * Constructor for objects of class ActionCards.
     * 
     * @param flow the flow
     */
    public ActionCards(Flow flow) {
        this.flow = flow;
    }
    
    /**
     * Returns the number of cards to be incremented in case of a special card.
     * 
     * @param inc is the increment
     * @param prevCard is the previous card
     * @return the increment
     */
    public int incrementer(int inc, Card prevCard) {
        return ZERO;
    }
    
    /**
     * get method for the flow.
     * 
     * @return the flow of the superclass
     */
    public Player nextPlayer() {
        return this.flow.normal();
    }
    
    /**
     * get method for flow.
     * 
     * @return the flow
     */
    public Flow getFlow() {
        return flow;
    }
}
