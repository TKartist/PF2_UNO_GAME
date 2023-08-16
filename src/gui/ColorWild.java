package gui;

import model.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * When the wild cards are called it will appear this frame where you can choose the color.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class ColorWild extends Frame implements ActionListener
{
    private static String red = "r";
    private static String blue = "b";
    private static String green = "g";
    private static String yellow = "y";
    private Main main;
    private Boolean difficulty;
    private int num;

    /**
     * this is the constructor.
     * 
     * @param main the main 
     * @param difficulty it is the mode that the player is playing 
     * @param num is the number of player
     */
    public ColorWild(Main main, Boolean difficulty, int num)
    {
        super(350,300);
        this.main = main;
        this.difficulty = difficulty;
        this.num = num;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        Button buttonRed = new Button(new ImageIcon("image/Red_button.png"),10, 10,70,240, red);
        panel.add(buttonRed);
        buttonRed.addActionListener(this);
        Button buttonBlue = new Button(new ImageIcon("image/Blue_button.png"),95, 10,70,240, blue);
        panel.add(buttonBlue);
        buttonBlue.addActionListener(this);
        Button buttonGreen = new Button(new ImageIcon("image/Green_button.png"),180, 10,70,240, green);
        panel.add(buttonGreen);
        buttonGreen.addActionListener(this);
        Button buttonYellow = new Button(new ImageIcon("image/Yellow_button.png"),265, 10,70,240, yellow);
        panel.add(buttonYellow);
        buttonYellow.addActionListener(this);
        
        getFrame().add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String newCol = event.getActionCommand();
        this.main.wildColor(newCol);
        getFrame().dispose();
        new Table(main, difficulty, num);
    }
}
