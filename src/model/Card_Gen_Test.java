package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test of Card_Gen class.
 *
 * @author Giorgio Bonetto, Hun Rim
 * @version 1.0
 */
public class Card_Gen_Test
{
    @Test
    public void generator_test() {
        Card val1 = CardGen.generate();
        CardGen gen = new CardGen();
        assertEquals(true, (val1 instanceof Card));
    }
}
