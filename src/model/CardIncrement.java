package model;

/**
 * Depending on the input we increment one, two or four cards.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class CardIncrement
{
    // instance variables - replace the example below with your own
    private int count;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int FOUR = 4;

    /**
     * it is the constructor.
     * 
     */
    public CardIncrement() {
        this.count = 0;
    }

    /**
     * it is incrementing numbers of cards to be added depending on the value of the card.
     * 
     * @param former is the stacked card to increment
     * @param value is the value of the card
     * @return number of cards to be added
     */
    public int increment(int former, String value) {
        if ("plus_two".equals(value)) {
            count = TWO;
        } else if ("wild_four".equals(value)) {
            count = FOUR;
        } else if ("noCard".equals(value)) {
            count = ONE;
        }
        return former + count;
    }
}
