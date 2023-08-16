package model;

/**
 * It generate the cards that are going to compose the deck.
 * The cards can have the value between (1,9) and the color
 * (red, yellow, blue, green, wild).
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class CardGen
{
    // instance variables - replace the example below with your own
    private static final String[] COLOR = new String[]{"r", "g", "b", "y"};
    private static final String[] VALUE = new String[]{"zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine", "plus_two", "wild_four", "skip", "reverse",
        "wild"};
    private static Card card;

    /**
     * Constructor for objects of class Card_Gen.
     */
    public CardGen()
    {
        this.card = card;
    }

    /**
     * It generate the card, each one compose by a value and a color.
     *
     * @return the card generated
     */
    public static Card generate()
    {
        String str = "";
        int max = VALUE.length;
        int min = 0;
        int colmax = COLOR.length;
        int index = (int)(Math.random() * (max - min) + min);
        if (!VALUE[index].equals("wild") && !VALUE[index].equals("wild_four")) {
            int tmp = (int)(Math.random() * (colmax - min) + min);
            str = str + COLOR[tmp] + "_" + VALUE[index];
        } else {
            str = str + "n" + "_" + VALUE[index];
        }
        card = new Card(str);
        return card;
    }
}
