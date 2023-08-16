package model;

/**
 * This class check if the card that has being put down has the same number or 
 * of the same color as the previous card.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class GameLogic
{
    // instance variables - replace the example below with your own
    private String topColor;
    private String topValue;
    private String wild = "wild";
    private String wildFour = "wild_four";
    private String plusTwo = "plus_two";

    /**
     * it is the constructor.
     * 
     * @param topColor the color of the last card on the pile.
     * @param topValue the value of the last card on the pile.
     */
    public GameLogic(String topColor, String topValue) {
        this.topColor = topColor;
        this.topValue = topValue;
    }

    /**
     * check if the card is valid or not.
     * 
     * @param card the card that has put down.
     * @param inc is the integer representing increment count
     * @return if the card is valid or not.
     */
    public Boolean correctCard(Card card, int inc) {
        if (inc > 0) {
            return canPlay(card, inc);
        } else {
            if (card.getValue().equals(wildFour) || card.getValue().equals(wild)) {
                return true;
            } 
            return partialLogic(card);
        }
    }

    /**
     * check if the player can play the card.
     * 
     * @param card the card that has put down.
     * @param inc is the integer representing increment count
     * @return if the player can play the card.
     */
    public Boolean canPlay(Card card, int inc) {
        if (card.getValue().equals(wildFour)) {
            return true;
        } else if (topValue.equals(wildFour)) {
            if (inc > 0) {
                return false;
            } else {
                return partialLogic(card);
            }
        } else if (topValue.equals(plusTwo)) {
            if (inc > 0) {
                return card.getValue().equals(plusTwo);
            } else {
                return partialLogic(card);
            }
        } else {
            return partialLogic(card);
        }
    }

    /**
     * check if the card is valid or not and it is use in correctCard method.
     * 
     * @param card the card that has put down.
     * @return if the card is valid or not.
     */
    private Boolean partialLogic(Card card) {
        if (this.topColor.equals(card.getColor())) {
            return true;
        } else if (card.getValue().equals(wild)) {
            return true;
        } else if (this.topValue.equals(card.getValue())) {
            return true;
        } else {
            return false;
        }
    }
}
