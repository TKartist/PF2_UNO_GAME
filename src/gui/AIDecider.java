package gui;

import model.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * The player decide if play against a the aggressive ai or the easy one.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class AIDecider implements ActionListener
{
    // instance variables - replace the example below with your own
    private JRadioButton easy;
    private JRadioButton hard;
    private JFrame frame;
    private ArrayList<String> ids;
    private int num;

    /**
     * Constructor for objects of class AIDecider.
     * 
     * @param ids the ids of the players
     * @param num number of player
     */
    public AIDecider(ArrayList<String> ids, int num)
    {
        this.ids = ids;
        this.num = num;
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame();
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        easy = new JRadioButton("Easy AI");
        easy.setBounds(10, 20, 120, 25);

        hard = new JRadioButton("Hard AI");       
        hard.setBounds(200, 20, 120, 25);

        ButtonGroup ai = new ButtonGroup();
        ai.add(easy);
        ai.add(hard);   

        panel.add(easy);
        panel.add(hard);
        
        JButton button = new JButton("Start");
        button.setBounds(10, 180, 80, 25);
        button.addActionListener(this);
        
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Boolean difficulty = true;
        if (event.getActionCommand().equals("Start")) {
            if (easy.isSelected()) {
                difficulty = true;
            } else if (hard.isSelected()) {
                difficulty = false;
            } else {
                new AIDecider(ids, num);
            }
        }
        frame.dispose();
        Main main = new Main(this.ids);
        new Table(main, difficulty, num);
    }
}
