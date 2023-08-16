package gui;

import model.Encrypter;
import model.LogIn;
import model.Main;
import model.SetAIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * It is the frame where the usere can login or register.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Login implements ActionListener {

    private JTextField userText;
    private JPasswordField passwordText;
    private JButton button;
    private JButton buttonOne;
    private JLabel success;
    private JFrame frame;
    private int num;
    private ArrayList<String> ids;
    private JRadioButton existing;
    private JRadioButton newUser;
    private static final Boolean NOAI = false;

    /**
     * it is the constructor of the login frame.
     * 
     * @param num is the number of different user
     * @param ids is the ids of the players
     */
    public Login(int num, ArrayList<String> ids) {
        this.num = num;
        this.ids = ids;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame();
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        existing = new JRadioButton("Existing User");
        existing.setBounds(10, 20, 120, 25);

        newUser = new JRadioButton("New User");       
        newUser.setBounds(200, 20, 120, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(existing);
        group.add(newUser);   

        panel.add(existing);
        panel.add(newUser);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 70, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 70, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 100, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 100, 165, 25);
        panel.add(passwordText);

        button = new JButton("Next");
        button.setBounds(10, 180, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        buttonOne = new JButton("->");
        buttonOne.setBounds(250, 180, 80, 25);
        buttonOne.addActionListener(this);
        buttonOne.setEnabled(false);
        panel.add(buttonOne);

        success = new JLabel("");
        success.setBounds(10, 210, 300, 25);
        panel.add(success);

        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Boolean passer = false;
        String user = userText.getText();
        String password = passwordText.getText();
        Encrypter encrypt = new Encrypter();
        String credential = user + " " + Integer.toString(encrypt.Encrypt(password));
        LogIn login = new LogIn();
        if (event.getSource() == button) {
            if (existing.isSelected()) {
                if (login.correctCred(credential)) {
                    success.setText("Login succesful!");
                    ids.add(user);
                    passer = true;
                } else {
                    success.setText("Wrong Credential");
                }
            } else if (newUser.isSelected()) {
                if (user.length() > 32 || login.dupName(user)) {
                    new Login(num, this.ids);
                } else {
                    ids.add(user);
                    login.createPlayer(user, password);
                    passer = true;
                }
            } else {
                success.setText("Please select if you are a new player or existing player");
            }
        }
        if (num == 1 && passer) {
            buttonOne.setEnabled(true);
        } else if (num <= 4 && passer) {
            frame.dispose();
            new Login(num - 1, this.ids);
        }
        if (event.getSource() == buttonOne) {
            frame.dispose();
            SetAIs ai = new SetAIs();
            int playerCount = this.ids.size();
            if (playerCount == 4) {
                Main main = new Main(this.ids);
                new Table(main, NOAI, playerCount);
            } else {
                this.ids = ai.fillAI(playerCount, this.ids);
                new AIDecider(ids, playerCount);
            }
        }
    }

}