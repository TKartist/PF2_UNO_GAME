package model;

/**
 * It determine the action of the card based on which card the players has played.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Handler
{
    private Card card;
    private Flow flow;
    private static final String PLUSTWO = "plus_two";
    private static final String REVERSE = "reverse";
    private static final String SKIP = "skip";
    private static final String WILDFOUR = "wild_four";

    /**
     * Constructor for objects of class GetCMD.
     * 
     * @param card is the played card
     * @param flow is the current flow of the game
     */
    public Handler(Card card, Flow flow)
    {
        this.card = card;
        this.flow = flow;
    }

    /**
     * Decide the action of the card depending on what card is played.
     *
     * @return ActionCards on which actions needs to be executed
     */
    public ActionCards getCMD()
    {
        ActionCards action;
        switch (this.card.getValue()) {
            case PLUSTWO: action = new PlusTwo(flow);
                break;
            case REVERSE: action = new Reverse(flow);
                break;
            case SKIP: action = new Skip(flow);
                break;
            case WILDFOUR: action = new WildFour(flow);
                break;
            default: action = new ActionCards(flow);
                break;
        }
        return action;
    }
}
