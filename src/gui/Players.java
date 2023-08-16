package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * It is the frame where you can chose the number of player.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Players extends Frame implements ActionListener
{
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    
    /**
     * It is the constructor of the Player class that create the frame with 
     * the button and the different image.
     * 
     * @param xaxis is the x axis
     * @param yaxis is the y axis
     */
    public Players(int xaxis, int yaxis)
    {
        super(xaxis, yaxis);
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(new Color(0x023348),1);
        
        label.setText("SELECT THE NUMBER OF PLAYERS");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(0x000000));
        label.setFont(new Font("MV Boli", Font.PLAIN,40));
        
        Button button = new Button(new ImageIcon("image/oneplayer.png"),150, 600, 122, 153, ONE);
        button.addActionListener(this);
        Button buttonOne = new Button(new ImageIcon("image/twoplayers.png"),350, 600, 122, 153, TWO);
        buttonOne.addActionListener(this);
        Button buttonTwo = new Button(new ImageIcon("image/threeplayers.png"),550, 600, 122, 153, THREE);
        buttonTwo.addActionListener(this);
        Button buttonThree = new Button(new ImageIcon("image/fourplayers.png"),700, 600, 122, 153, FOUR);
        buttonThree.addActionListener(this);
        
        label.add(button);
        label.add(buttonOne);
        label.add(buttonTwo);
        label.add(buttonThree);
        
        getFrame().add(label);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        ArrayList<String> ids = new ArrayList<String>();
        String command = event.getActionCommand();
        int num = Integer.parseInt(command);
        new Login(num, ids);
        dispose();
    }
}
