package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class EncrypterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EncrypterTest
{
    @Test
    public void EncriptionTest() {
        Encrypter encrypt = new Encrypter();
        int result = encrypt.Encrypt("a");
        int result2 = encrypt.converter(2);
        assertEquals(58, result);
        assertEquals(191, result2);
    }
}
