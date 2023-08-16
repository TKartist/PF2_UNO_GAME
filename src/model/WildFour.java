package model;


/**
 * This class handle the wild four card.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class WildFour extends ActionCards
{
    private static final String WILDFOUR = "wild_four";

    /**
     * Constructor for objects of class WildFour.
     * 
     * @param flow is the flow
     */
    public WildFour(Flow flow)
    {
        super(flow);
    }

    @Override
    public int incrementer(int inc, Card prevCard)
    {
        PlusCards add = new PlusCards(WILDFOUR);
        return add.incrementDet(inc, prevCard);
    }
}
