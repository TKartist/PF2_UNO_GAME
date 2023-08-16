package model;

import java.util.ArrayList;

/**
 * It check the card if it is valid.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class InputChecker
{
    // instance variables - replace the example below with your own
    private String word;
    private ArrayList<String> ids;
    
    /**
     * Constructor for objects of class InputChecker.
     * 
     * @param word the word
     */
    public InputChecker(String word)
    {
        this.word = word;
    }
    
    /**
     * Constructor for objects of class InputChecker.
     * 
     * @param word the word
     * @param ids the list of the usernames
     */
    public InputChecker(String word, ArrayList<String> ids) {
        this.word = word;
        this.ids = ids;
    }

    /**
     * It checks if the input is valid.
     * 
     * @param main the main
     * @return if the input is valid.
     */
    public Boolean valid(Main main)
    {
        int index = Integer.parseInt(this.word);
        int limit = main.handSize();
        if (index > limit) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * it check if the id is valid.
     * 
     * @return if the id is valid
     */
    public Boolean validID() {
        for (String id: this.ids) {
            if (id.equals(this.word)) {
                return true;
            }
        } 
        return false;
    }
    
    /**
     * it check if the color of the card is right.
     * 
     * @return if the color is valid
     */
    public Boolean validColor() {
        if (this.word.equals("r") || this.word.equals("y") || this.word.equals("g") || this.word.equals("b")) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * it check if the input it is composed of strange characters.
     * 
     * @return if the input it is composed of strange characters.
     */
    public Boolean passCheck() {
        for (int i = 0; i < this.word.length(); i++) {
            char cha = this.word.charAt(i);
            if (cha >= 'a' && cha <= 'z' || cha >= 'A' && cha <= 'Z' || cha >= '0' && cha <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
