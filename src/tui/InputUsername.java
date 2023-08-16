package tui;

import model.InputChecker;
import model.LogIn;

import java.util.Scanner;


/**
 * This class ask for the username and the password in the tui.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class InputUsername
{

    /**
     * It creates a new username and a new password.
     */
    public void createPlayer() {
        Scanner user = new Scanner(System.in);
        LogIn login = new LogIn();
        System.out.println("Enter player username: ");
        String name = user.next();
        while (name.length() > 32 || login.dupName(name)) {
            System.out.println("Username should be UNIQUE 32 characters: ");
            name = user.next();
        }
        System.out.println("Enter player password: ");
        String password = user.next();
        InputChecker passCheck = new InputChecker(password);
        while (password.length() > 32 && passCheck.passCheck()) {
            System.out.println("Password should be less than 32 characters: ");
            password = user.next();
        }
        login.createPlayer(name, password);
    }
}