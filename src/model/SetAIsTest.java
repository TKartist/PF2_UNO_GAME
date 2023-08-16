package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The test class SetAIsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SetAIsTest
{
    @Test
    public void fillAITest(){
        SetAIs newAI = new SetAIs();
        HashMap<String, Boolean> ais = new HashMap<String, Boolean>();
        ArrayList<String> ids = new ArrayList<String>();
        ArrayList<String> ids1 = new ArrayList<String>();
        ids.add("1000");
        ids.add("1001");
        ids1 = ids;
        ids1.add("AI1");
        ids1.add("AI2");
        assertEquals(ids1, (ids = newAI.fillAI(2, ids)));
    }
    
    @Test
    public void aiStatusTest() {
        SetAIs newAI = new SetAIs();
        HashMap<String, Boolean> ais = new HashMap<String, Boolean>();
        ArrayList<String> ids1 = new ArrayList<String>();
        ids1.add("1000");
        ids1.add("1001");
        ids1.add("AI1");
        ids1.add("AI2");
        assertEquals(true, (ais = newAI.aiStatus(ids1, "2")).get("1000"));
        assertEquals(false, ais.get("AI1"));
    }
}
