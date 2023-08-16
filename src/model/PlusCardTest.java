package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlusCard.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class PlusCardTest
{
    @Test 
    public void addTwoTest() {
        Card card1 = new Card("n_wild_four");
        Card card2 = new Card("b_plus_two");
        PlusCards plusCard = new PlusCards("wild_four");
        PlusCards plusCard1 = new PlusCards("plus_two");
        assertEquals(2, plusCard1.incrementDet(0, card2));
        assertEquals(4, plusCard.incrementDet(0, card1));
        assertEquals(4, plusCard.incrementDet(0, card2));
    }
    
}
