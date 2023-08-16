package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class creates the new username.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class SetAIs
{
    
    private ArrayList<String> ids;
    private static final int TOTALPLAYER = 4;
    private HashMap<String, Boolean> ais;
    
    /**
     * This is the constructor.
     */
    public SetAIs() {
        ais = new HashMap<String, Boolean>();
    }
    
    /**
     * It return the ais.
     * 
     * @param ids is the list of id of the players.
     * @param numPlayer is the number of player
     * @return the ai
     */
    public HashMap<String, Boolean> aiStatus(ArrayList<String> ids, String numPlayer) {
        for (int player = 0; player < TOTALPLAYER; player++) {
            ais.put(ids.get(player), player < Integer.parseInt(numPlayer));
        }
        return ais;
    }
    
    /**
     *  Set name of ai.
     *  
     *  @param num the number of 
     *  @param ids the list of ids of the players
     *  @return the list of name of the ais
     * 
     */
    public ArrayList<String> fillAI(int num, ArrayList<String> ids) {
        int weNeed = TOTALPLAYER - num + 1;
        for (int i = 1; i < weNeed; i++) {
            String aiName = "AI" + i;
            ids.add(aiName);
        }
        return ids;
    }
}
