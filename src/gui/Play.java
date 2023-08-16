package gui;

import model.Main;

import javax.swing.JFrame;

/**
 * It runs the game.
 *
 * @author bonegi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Play extends GuiCommand
{
    /**
     * Constructor for the class PLAY extending GUICOmmand.
     * 
     * @param main is Main containing current game status
     * @param userInput is a string value of button pressed by user
     * @param frame is the former frame of the game
     */
    public Play(Main main, String userInput, JFrame frame)
    {
        super(main, userInput, frame);
    }


    /**
     * Plays the card of player's choice.
     *
     * @param  difficulty is Boolean representing difficulty of AI
     * @param  num is a integer representing number of AIs
     */
    @Override
    public void execute(Boolean difficulty, int num)
    {
        getFrame().dispose();
        int index = Integer.parseInt(getUserInput());
        if (hunoViolation()) {
            getMain().noCard();
            new Table(getMain(), difficulty, num);
        } else {
            getMain().playCard(index);
            if (getMain().wildCard()) {
                new ColorWild(getMain(), difficulty, num);
            } else {
                new Table(getMain(), difficulty, num);
            }
        }
    }
    
    /**
     * Checks if the Huno button was pressed before the player's turn came again.
     * 
     * @return Boolean stating if the player pressed HUNO
     */
    private Boolean hunoViolation() {
        if (getMain().playingP().hunoState() == false && getMain().handSize() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
