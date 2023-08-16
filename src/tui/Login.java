package tui;

import model.Encrypter;
import model.LogIn;

/**
 * Log in class.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Login 
{
    private String user;
    private String password;

    /** 
     * it is the constructor.
     * 
     * @param user the name of the player
     * @param password the password of the player
     */
    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /** 
     * it checks if the user has inputted right credential.
     * 
     * @return if the credentials are right
     */
    public boolean validCredential() {
        LogIn login  = new LogIn();
        Encrypter encrypt = new Encrypter();
        String credential = user + " " + Integer.toString(encrypt.Encrypt(password));
        return login.correctCred(credential);
    }
}
