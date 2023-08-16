package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Card.
 *
 * @author Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class CardTest
{
    // instance variables - replace the example below with your own
    @Test
    public void testGetColor() {
        assertEquals ("red", new Card("red_8").getColor());
        assertEquals ("g", new Card("g_8").getColor());
    }

    @Test
    public void testGetValue() {
        assertEquals ("reverse", new Card("red_reverse").getValue());
        assertEquals ("8", new Card("green_8").getValue());
        assertEquals ("8", new Card("red_8").getValue());
    }
}
