package model;


/**
 * It is a function related to Wild Card.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class WildCard extends ActionCards
{
    private Card card;
    
    /**
     * Constructor for the wild card.
     * 
     * @param card is the card
     * @param flow the flow
     */
    public WildCard(Card card, Flow flow) {
        super(flow);
        this.card = card;
    }
    
    /**
     * It makes a new wild card with actual color instead of n.
     * 
     * @param color is color of the card
     * @return the card
     */
    public Card colorWild(String color) {
        Card newCard = new Card(color + "_" + this.card.getValue());
        return newCard;
    }
}
