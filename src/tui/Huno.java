package tui;

import model.HUNO;
import model.InputChecker;
import model.Main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * It determines when the player has one card in the hand.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Huno
{
    private Main main;
    private HUNO huno;
    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructir for Huno class.
     * 
     * @param main the main
     */
    public Huno(Main main) {
        this.main = main;
        this.huno = new HUNO(main.players());
    }
    
    /**
     * it compile the different huno's method.
     * 
     * @param ids is the ids of the different players
     */
    public void hunoCompiler(ArrayList<String> ids) {
        callHuno(ids);
        hunoNull();
    }

    /**
     * It call the huno function.
     * 
     * @param ids is the ids of the different players
     */
    public void callHuno(ArrayList<String> ids) {
        if (hunoCheck()) {
            System.out.println("Please enter the ID of the player who wants to call HUNO:");
            System.out.println(ids);
            System.out.println(huno.personAtHuno().playerID());
            String name = SCANNER.next();
            InputChecker checker = new InputChecker(name, ids);
            if (checker.validID()) {
                System.out.println("existing player!!!");
                huno.hunoEffect(name, this.main.accessDeck());
            } else {
                System.out.println("Entered player doesn't exist!!!");
                callHuno(ids);
            }
        } else {
            System.out.println();
        }
    }
    
    /**
     * If the huno is not called.
     */
    public void hunoNull() {
        huno.hunoNull();
    }

    /**
     * Checks for preHuno.
     * 
     * @return Boolean value stating if preHuno can be called
     */
    public Boolean hunoCheck() {
        return huno.hunoChecker();
    }

    /**
     * Huno Button.
     */
    public void hunoButton() {
        System.out.println(" ------- ");
        System.out.println("|  HUNO |");
        System.out.println(" ------- ");
    }

    /**
     * get method for main
     * 
     * @return main 
     */
    public Main getMain() {
        return main;
    }
}
