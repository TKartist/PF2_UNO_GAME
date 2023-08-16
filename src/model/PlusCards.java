package model;

/**
 * Determines the number of cards to be added.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class PlusCards extends CardIncrement
{
    private static final String WILDFOUR = "wild_four";
    private String value;
    
    /**
     * Call the constructor of CardIncrement.
     * 
     * @param value the value of the card
     * 
     */
    public PlusCards(String value) {
        super();
        this.value = value;
    }

    /**
     * It determine how many cards should it takes from the deck.
     *
     * @param incrementCount is stacked card to be added
     * @param prevCard is the card on top of the pile
     * @return the number of cards that it has to increment
     */
    public int incrementDet(int incrementCount, Card prevCard) {
        if (WILDFOUR.equals(prevCard.getValue())) {
            if (WILDFOUR.equals(value)) {
                return increment(incrementCount, value);
            } else {
                return incrementCount;
            }
        } else {
            return increment(incrementCount, value);
        }
    }
}
