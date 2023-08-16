package model;

/**
 * This class is the structure of the cards.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String value;
    private String color;
    private String card;

    /**
     * Constructor for objects of class Card.
     * 
     * @param card is the card
     */
    public Card(String card)
    {
        this.card = card;
        this.color = processColor();
        this.value = processValue();

    }

    /**
     * From the card, determine the color of the card.
     *
     * @return the color of the card
     */
    private String processColor()
    {
        String str = "";
        int index = 0;
        while (this.card.charAt(index) != '_') {
            str = str + this.card.charAt(index);
            index += 1;
        }
        return str;
    }

    /**
     * From the card, determine the value of the card.
     *
     * @return the value of the card
     */
    private String processValue() 
    {
        int index = 0;
        while (this.card.charAt(index) != '_') {
            index += 1;
        }
        return this.card.substring(index + 1);
    }

    /**
     * From the card, determine the color of the card.
     *
     * @return the color of the card
     */
    public String getColor() {
        return this.color;
    }

    /**
     * From the card, determine the value of the card.
     *
     * @return the value of the card
     */
    public String getValue() {
        return this.value;
    }

    /**
     * From the card, determine the card.
     *
     * @return the card
     */
    public String getCard() {
        return this.card;
    }
}
