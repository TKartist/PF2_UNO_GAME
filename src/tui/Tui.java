package tui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * TUI.
 * 
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Tui 
{
    private final static Scanner SCANNER = new Scanner(System.in);
    private static ArrayList<String> ids = new ArrayList<String>();
    private static HashMap<String, Boolean> ais;
    private static Level difficulty;
    
    /**
     * main function of the Tui.
     * 
     * @param args the input of the user
     */
    public static void main(String[] args) {
        GameRule rule = new GameRule();
        difficulty = new Level();
        System.out.println('\u000C');
        System.out.println("Welcome!");
        rule.gameRule();
        Boolean easy = difficulty.aiLevel();
        SetPlayers set = new SetPlayers();
        ids = set.setPlayers();
        ais = set.AI();
        Game game = new Game(ids);
        while (true) {
            System.out.println('\u000C');
            game.playGame();
            System.out.println("If you want to quit the game please enter 'Y'");
            System.out.println("if you want to play please enter 'N'");
            String response = SCANNER.next();
            if (response.toUpperCase().equals("Y")) {
                break;
            } else if (response.toUpperCase().equals("N")) {
                AIorNot decider = new AIorNot(ais, game, easy);
                if (game.canPlay()) {
                    Play ply = decider.decidePlay();
                    ply.play();
                } else {
                    game.noCard();
                }
                Huno huno = decider.decideHuno();
                huno.hunoCompiler(ids);
                Win win = new Win(game.main());
                if (win.won()) {
                    win.winMessage();
                    break;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        System.out.println("Bye");
        SCANNER.close();
    }

}
