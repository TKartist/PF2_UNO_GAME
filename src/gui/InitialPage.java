package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;


/**
 * It is the first frame.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class InitialPage extends Frame implements ActionListener {
    
    private static final int XAXIS = 1000;
    private static final int YAXIS = 900;
    private static final String COMMAND = "Start";
    
    /**
     * It is the constructor of the first page.
     */
    public InitialPage() {
        super(XAXIS, YAXIS);
        
        ImageIcon wall = new ImageIcon("image/background.png");
        JLabel background = new JLabel("background");
        background.setIcon(wall);
        background.setVerticalAlignment(JLabel.TOP);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setBounds(0, 0, XAXIS, YAXIS);
        
        ImageIcon logo = new ImageIcon("image/LOGO.png");
        Border border = BorderFactory.createLineBorder(new Color(0x023348),1);
        
        JLabel label = new JLabel("functionbody");
        label.setText("Press '" + COMMAND + "' to play");
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("MV Boli", Font.PLAIN,30));
        label.setIconTextGap(100);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, XAXIS, YAXIS);
        background.add(label);
        
        Button button = new Button(new ImageIcon("image/Start.png"), 400, 600, 190, 102, COMMAND);
        button.addActionListener(this);
        label.add(button);
        getFrame().add(background);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == COMMAND) {
            getFrame().dispose();
            new Players(XAXIS, YAXIS);
        }
    }

}
