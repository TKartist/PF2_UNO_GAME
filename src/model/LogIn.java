package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * LogIn class, it check the credential of the user.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class LogIn
{
    // instance variables - replace the example below with your own
    private Encrypter encrypt;
    
    /**
     * Constructor for objects of class LogIn.
     */
    public LogIn()
    {
        encrypt = new Encrypter();
    }

    /**
     * It create the new Player usernames.
     * 
     * @param name is the name of the players
     * @param pass the password
     */
    public void createPlayer(String name, String pass) {
        String password = Integer.toString(encrypt.Encrypt(pass));
        String output = name + " " + password;
        storeUser(output);
    }

    /** 
     * it stores the username and the password on an external file.
     * 
     * @param output is the password encrypted
     */
    private void storeUser(String output) {
        try {
            File file = new File("loginINFO.txt");
            String absPath = file.getAbsolutePath();
            System.out.println(absPath);
            BufferedReader br = fileAccess();
            String name;
            ArrayList<String> oldFile = new ArrayList<String>();
            while ((name = br.readLine()) != null) {
                oldFile.add(name);
            }
            PrintWriter writer = new PrintWriter(absPath, "UTF-8");
            for (String user: oldFile) {
                writer.println(user);
            }
            writer.println(output);
            writer.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    /**
     * it read from the file logininfo.txt if there are the right credential.
     * 
     * @return the bufferreader
     */
    private BufferedReader fileAccess() {
        BufferedReader br = null;
        try {
            File path = new File("loginINFO.txt");
            String absPath = path.getAbsolutePath();
            FileReader fr = new FileReader(absPath);
            br = new BufferedReader(fr);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return br;
    }

    /**
     * Check if there is already the username.
     * 
     * @param name is the name of the user.
     * @return if the name already exist.
     */
    public Boolean dupName(String name) {
        try {
            BufferedReader br = fileAccess();
            String word;
            while ((word = br.readLine()) != null) {
                System.out.println(word);
                if (registeredUser(word).equals(name)) {
                    return true;
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    /**
     * registered user.
     * 
     * @param s the name
     * @return the name of the user
     */
    private String registeredUser(String word) {
        String output = "";
        int count = 0;
        while (word.charAt(count) != ' ') {
            output += word.charAt(count);
            count++;
        }
        return output;
    }

    /**
     * It checks if the given credential are right.
     * 
     * @param cred the credential
     * @return if the given credential are right
     */
    public Boolean correctCred(String cred) {
        try {
            BufferedReader br = fileAccess();
            String word;
            while ((word = br.readLine()) != null) {
                if (word.equals(cred)) {
                    return true;
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        } 
        return false;
    }
    
    /**
     * It checks the loginINFO and rewrites the file only without the provided info.
     * 
     * @param cred is a String value of to be deleted user info
     */
    public void removeID(String cred) {
        try {
            File file = new File("loginINFO.txt");
            String absPath = file.getAbsolutePath();
            BufferedReader br = fileAccess();
            String name;
            ArrayList<String> oldFile = new ArrayList<String>();
            while ((name = br.readLine()) != null) {
                if (!(name.equals(cred))) {
                    oldFile.add(name);
                }
            }
            PrintWriter writer = new PrintWriter(absPath, "UTF-8");
            for (String user: oldFile) {
                writer.println(user);
            }
            writer.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
