import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exceptions.*;

public class PasswordCheckerUtility {


    public PasswordCheckerUtility() {
    }

    public static boolean isValidPassword(String password) throws Exception{

        //checks password len
        if (password.length() < 6) {
            throw new InvalidSequenceException("The password must be at least 6 characters long");
        }

        //creates patterns for regex
        Pattern p1 = Pattern.compile("[A-Z]");
        Pattern p2 = Pattern.compile("[a-z]");
        Pattern p3 = Pattern.compile("[0-9]");
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");


        //idk what this does but it was in the hints (i need to change before turning it in)
        Matcher m1 = p1.matcher(password);
        Matcher m2 = p2.matcher(password);
        Matcher m3 = p3.matcher(password);
        Matcher m4 = p4.matcher(password);

        //checks if each regex pattern appears in password
        if(!m1.find()){
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        }
        if (!m2.find()){
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        }
        if (!m3.find()){
            throw new NoDigitException("The password must contain at least one digit");
        }
        if(!m4.find()){
            throw new NoSpecialCharactersException("The password must contain at least one special character");
        }

        //loops through password comparing the current element to current + 1
        for (int i = 0; i < password.length()-2; i++) {
            if (password.charAt(i) == password.charAt(i+1)) {
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
            }
        }

        //if no exceptions are thrown it will reach this statement
        return true;
    }

    public boolean isWeakPassword(String password) {
        return false;
    }

    public ArrayList<String> getInvalidPasswords(){
        return null;
    }

}
