package gui;

import java.awt.Color;
import javax.swing.JPanel;


/**
 * this class is use as a basis of every panel of the gui.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Panel extends JPanel
{
    /**
     * Constructor for objects of class Panel.
     * 
     * @param axisx the x Axis of the panel
     * @param axisy the y Axis of the panel
     * @param width the with of the panel
     * @param height the height of the panel 
     */
    public Panel(int axisx, int axisy, int width, int height)
    {
        super();
        this.setBounds(axisx, axisy, width, height);    
        this.setBackground(Color.gray); 
    }

}
