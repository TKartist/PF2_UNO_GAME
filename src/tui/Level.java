package tui;

import java.util.Scanner;

/**
 * It determine the level of the ais.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Level
{
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * It return the level of the ai.
     * 
     * @return the level of the ai
     */
    public Boolean aiLevel()
    {
        System.out.println("Decide if you want strong AI or weak AI:");
        System.out.println("[0] - for strong AI");
        System.out.println("[1] - for weak AI");
        String level = "";
        Boolean easy;
        do {
            level = scanner.next();
            if ("0".equals(level)) {
                easy = false;
            } else {
                easy = true;
            }
        } 
        while (!("0".equals(level) || "1".equals(level)));
        return easy;
    }
}
