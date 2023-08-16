package tui;

import model.SetAIs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * It set the name of all the players.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class SetPlayers
{
    private ArrayList<String> ids;
    private static Scanner scanner = new Scanner(System.in);
    private HashMap<String, Boolean> ais;
    private String num;
    private SetAIs ai;
    
    /**
     * This is the constructor.
     */
    public SetPlayers() {
        ids = new ArrayList<String>();
        ais = new HashMap<String, Boolean>();
        ai = new SetAIs();
        this.num = "";
    }
    
    /**
     * It sets the new player username and password.
     * 
     * @return the list of the username
     */
    public ArrayList<String> setPlayers() {
        System.out.println("How many people wants to play?");
        num = scanner.next();
        int numPlayer = Integer.parseInt(num);
        for (int i = 0; i < numPlayer; i++) {
            System.out.println("Do you want to create a new player or using an existing one? [N/E]");
            final String word = scanner.next();
            Login login;
            if (word.toUpperCase().equals("N")) {
                InputUsername input = new InputUsername();
                input.createPlayer();
            } else if (word.toUpperCase().equals("E")) {
                do {
                    System.out.println("- LOGIN -");
                    System.out.println("username : ");
                    String user = scanner.next();
                    System.out.println("password : ");
                    String password = scanner.next();
                    login = new Login(user, password);   
                    if (!login.validCredential()) {
                        System.out.println("Wrong credential, Try again");
                    } else {
                        this.ids.add(user);
                    }
                } 
                while (!login.validCredential());
            } else {
                System.out.println("not valid input");
                i--;
            }
        }
        System.out.println("You are ready to play!");
        this.ids = ai.fillAI(numPlayer, this.ids);
        return this.ids;
    }
    
    /**
     * Creates a hashmap stating whether the player is AI or not.
     * 
     * @return HashMap of AIs
     */
    public HashMap<String, Boolean> AI() {
        ais = ai.aiStatus(ids, num);
        return ais;
    }
}
