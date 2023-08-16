package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * It is the frame that change every time with different windows.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Frame extends JFrame 
{
    
    /**
     * This is the constructor for all the frame.
     * 
     * @param axisx the x Axis of the panel
     * @param axisy the y Axis of the panel
     */
    Frame(int axisx, int axisy) {
        super();
        this.setTitle("HUNO");                        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // exit when frame get closed
        this.setResizable(false);                                 
        this.setSize(axisx, axisy);
        this.setLocationRelativeTo(null);                        // window appears in the middle of the screen 
        this.setVisible(true);  
        this.setLayout(new BorderLayout());
    }   
    
    /**
     * It a getter method for the frame.
     * 
     * @return the frame
     */
    public JFrame getFrame() {
        return this;
    }
}
