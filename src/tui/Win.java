package tui;

import model.Main;
import model.Winner;

/**
 * It print the win page.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Win
{
    private Main main;
    private Winner won;
    
    /**
     * It is the constructor.
     * 
     * @param main is the main
     */
    public Win(Main main) {
        this.main = main;
        won = new Winner(this.main.players());
    }
    
    /**
     * it determine if the player has won.
     * 
     * @return if the player has won.
     */
    public Boolean won() {
        return won.winner();
    }
    
    /**
     * it print the win page.
     */
    public void winMessage() {
        System.out.println('\u000C');
        System.out.println("\t\t\t ---------------");
        System.out.println("\t\t\t|\t\t|");
        System.out.println("\t\t\t|\tWIN\t|");
        System.out.println("\t\t\t|\t" + won.winPlayer().playerID() + "\t|");
        System.out.println("\t\t\t|\t\t|");
        System.out.println("\t\t\t ---------------");
    }
}
