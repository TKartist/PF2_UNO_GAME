package gui;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * It is the frame that shows the winner.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class WinPage extends Frame
{
    // instance variables - replace the example below with your own
    private Button button;
    private static final int XAXIS = 1000;
    private static final int YAXIS = 900;

    /**
     * Constructor for objects of class WinPage.
     * 
     * @param winner the player that has won
     */
    public WinPage(String winner)
    {
        super(XAXIS, YAXIS);
        ImageIcon wall = new ImageIcon("image/background.png");
        JLabel background = new JLabel("background");
        background.setIcon(wall);
        background.setVerticalAlignment(JLabel.TOP);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setBounds(0, 0, 1500, 1000);
        
        ImageIcon logo = new ImageIcon("image/LOGO.png");
        JLabel label = new JLabel("functionbody");
        label.setText("The winner is " + winner);
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("MV Boli", Font.PLAIN,30));
        label.setIconTextGap(100);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, XAXIS, YAXIS);
        background.add(label);
        
        getFrame().add(background);
    }
}
