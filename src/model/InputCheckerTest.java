package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class InputCheckerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InputCheckerTest
{
    @Test 
    public void validIdTest() {
        ArrayList<String> players = new ArrayList<String>();
        String player = new String("gio");
        String player1 = new String("10002");
        players.add(player);
        players.add(player1);
        InputChecker input = new InputChecker("gio", players);
        InputChecker inputTwo = new InputChecker("hun", players);assertTrue(input.validID());
        assertFalse(inputTwo.validID());
    }
    
    @Test 
    public void validColorTest() {
        InputChecker input = new InputChecker("r");
        InputChecker inputTwo = new InputChecker("d");
        InputChecker inputThree = new InputChecker("y");
        InputChecker inputFour = new InputChecker("g");
        InputChecker inputFive = new InputChecker("b");
        assertTrue(input.validColor());
        assertTrue(inputThree.validColor());
        assertTrue(inputFour.validColor());
        assertTrue(inputFive.validColor());
        assertFalse(inputTwo.validColor());
    }
    
    @Test 
    public void passCheckTest() {
        InputChecker input = new InputChecker("rrh34s");
        InputChecker inputTwo = new InputChecker("df%^hj");
        InputChecker inputThree = new InputChecker("AAA");
        
        assertTrue(input.passCheck());
        assertFalse(inputTwo.passCheck());
        assertTrue(inputThree.passCheck());
    }
    
    @Test
    public void validTest() {
        InputChecker input1= new InputChecker("10");
        InputChecker input= new InputChecker("5");
        ArrayList<String> ids = new ArrayList<String>();
        String player1 = "1001";
        String player2 = "1002";
        String player3 = "1003";
        String player4 = "1004";
        ids.add(player1);
        ids.add(player2);
        ids.add(player3);
        ids.add(player4);
        Main main = new Main(ids);
        assertFalse(input1.valid(main));
        assertTrue(input.valid(main));
    }
}
