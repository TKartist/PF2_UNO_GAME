package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Card_IncrementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CardIncrementTest
{
    @Test
    public void incrementTest()
    {
        model.CardIncrement card_Inc1 = new model.CardIncrement();
        assertEquals(6, card_Inc1.increment(2, "wild_four"));
    }

    @Test
    public void incrementTest1()
    {
        model.CardIncrement card_Inc1 = new model.CardIncrement();
        assertEquals(5, card_Inc1.increment(3, "plus_two"));
    }

    @Test
    public void incrementTest2()
    {
        model.CardIncrement card_Inc1 = new model.CardIncrement();
        assertEquals(5, card_Inc1.increment(4, "noCard"));
    }
}

