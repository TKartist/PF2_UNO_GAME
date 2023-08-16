package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * The test class LogInTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LogInTest
{
    @Test
    public void LoginTest() {
        LogIn login = new LogIn();
        Encrypter encrypt = new Encrypter();
        assertEquals(true, login.dupName("gio"));
        assertEquals(false, login.dupName("alex"));
        assertEquals(true, login.correctCred("gio " + Integer.toString(encrypt.Encrypt("gio"))));
        assertEquals(false, login.correctCred("alex " + Integer.toString(encrypt.Encrypt("alex"))));
        login.createPlayer("ail", "ail");
        String cred = "ail " + Integer.toString(encrypt.Encrypt("ail"));
        assertEquals(true, login.correctCred(cred));
        login.removeID(cred);
    }
}
