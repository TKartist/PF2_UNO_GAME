package tui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class shows all the rule of the game.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class GameRule
{
    
    private Scanner scanner;
    
    /**
     * it is the constructor.
     */
    public GameRule() {
        scanner = new Scanner(System.in);
    }
    
    /**
     *  Game rule.
     * 
     */
    public void gameRule() {
        System.out.println("Do you want to read the rule of Uno and learn how to play? [Y/N]");
        String word = scanner.next();
        if (word.toUpperCase().equals("Y")) {
            try {
                File file = new File("gameRule.txt");
                String absPath = file.getAbsolutePath();
                FileReader fr = new FileReader(absPath);
                BufferedReader br = new BufferedReader(fr);
                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
            System.out.println();
            System.out.println();
        }
    }
}
