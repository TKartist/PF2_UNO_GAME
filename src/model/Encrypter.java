package model;

import java.util.HashMap;

/**
 * Encrypter class for encrypt the password.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Encrypter
{
    private HashMap<Character, Integer> alphabets = new HashMap<Character, Integer>();
    private static String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int H = 8;
    private static final int U = 21;
    private static final int N = 14;
    private static final int O = 15;
    
    /**
     * this is the constructor.
     */
    public Encrypter() {
        for (int i = 0; i < alpha.length(); i++) {
            alphabets.put(alpha.charAt(i), i + 1);
        }
    }
    
    /**
     * It encrypt the password.
     *
     * @param password is the password 
     * @return the password encrypted
     */
    public int Encrypt(String password)
    {
        int encryp = 0;
        for (int i = 0; i < password.length(); i++) {
            int val = alphabets.get(password.charAt(i));
            encryp = encryp + converter(val);
        }
        return encryp;
    }

    /**
     * it convert the password encrypted.
     * 
     * @param value is the password encrypted
     * @return the converted password
     */
    public int converter(int value) {
        int convert = H * (value * value * value) + U * (value * value) + N * value + O;
        return convert;
    }
}
