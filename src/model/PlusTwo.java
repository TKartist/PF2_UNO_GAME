package model;


/**
 * This class describe the plus two card.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class PlusTwo extends ActionCards
{
    private static final String PLUSTWO = "plus_two";

    /**
     * Constructor for objects of class PLUSTWO.
     * 
     * @param flow is the flow
     */
    public PlusTwo(Flow flow)
    {
        super(flow);
    }

    @Override
    public int incrementer(int inc, Card prevCard)
    {
        PlusCards add = new PlusCards(PLUSTWO);
        return add.incrementDet(inc, prevCard);
    }
}
