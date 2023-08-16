package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * This class is use as a basis of the all button of the Gui.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Button extends JButton
{
    /**
     * Constructor for objects of class Button.
     * 
     * @param image the image 
     * @param axisx the x Axis of the panel
     * @param axisy the y Axis of the panel
     * @param width the with of the panel
     * @param height the height of the panel 
     * @param command the command
     */
    public Button(ImageIcon image, int axisx, int axisy, int width, int height, String command)
    {
        super();
        this.setIcon(image);
        this.setText(command);
        this.setBounds(axisx, axisy, width, height);
        this.setFocusable(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
    }

    /**
     * get method to return the button.
     * 
     * @return the button
     */
    public JButton getButton() {
        return this;
    }
}
