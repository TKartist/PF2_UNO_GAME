package gui;

import model.Main;

import javax.swing.JFrame;

/**
 * Write a description of class GUICommand here.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class GuiCommand
{
    private Main main;
    private String userInput;
    private JFrame frame;

    /**
     * Constructor for the class PLAY extending GUICOmmand.
     * 
     * @param main is Main containing current game status
     * @param userInput is a string value of button pressed by user
     * @param frame is the former frame of the game
     */
    public GuiCommand(Main main, String userInput, JFrame frame)
    {
        this.main = main;
        this.userInput = userInput;
        this.frame = frame;
    }

    /**
     * Executes corresponding command of the user action.
     *
     * @param difficulty is the Boolean stating the difficulty of the AIs
     * @param num is an integer stating the number of AIs
     */
    public void execute(Boolean difficulty, int num)
    {
        frame.dispose();
    }
    
    /**
     * get method for main.
     * 
     * @return the main
     */
    public Main getMain() {
        return main;
    }
    
    /**
     * get method for userInput.
     * 
     * @return the user input
     */
    public String getUserInput() {
        return userInput;
    }
    
    /**
     * get method for frame.
     * 
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
}
