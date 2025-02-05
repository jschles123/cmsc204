import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Joshua Schlesinger-Guevara
 *
 */

public class PasswordCheckerUtility {


    public PasswordCheckerUtility() {
    }

    public static boolean isValidPassword(String password) throws InvalidSequenceException, LengthException, NoDigitException, NoLowerAlphaException, NoSpecialCharacterException, NoUpperAlphaException{

        PasswordCheckerUtility.isValidLength(password);
        PasswordCheckerUtility.hasUpperAlpha(password);
        PasswordCheckerUtility.hasLowerAlpha(password);
        PasswordCheckerUtility.hasDigit(password);
        PasswordCheckerUtility.hasSpecialChar(password);
        PasswordCheckerUtility.NoSameCharInSequence(password);
        //if no exceptions are thrown it will reach this statement
        return true;
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoLowerAlphaException, NoSpecialCharacterException, NoDigitException, InvalidSequenceException, NoUpperAlphaException {
        PasswordCheckerUtility.isValidPassword(password);
        if (password.length() >= 6 && password.length() <= 9) {
            throw new WeakPasswordException();
        }
        return false;
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
        ArrayList<String> NoSameCharInSequences = new ArrayList<String>();
        for(String i : passwords){
            try{
                PasswordCheckerUtility.isValidPassword(i);
            }
            catch(Exception e){
                NoSameCharInSequences.add((i + " " + e.getMessage()));
            }
        }
        return NoSameCharInSequences;
    }

    public static boolean comparePasswordsWithReturn(String p1, String p2) {
        return p1.equals(p2);
    }

    public static boolean comparePasswords(String p1, String p2) throws UnmatchedException {
        if (!p1.equals(p2)){
            throw new UnmatchedException();
        }
        return true;
    }

    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException();
        }
        return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(password);
        if(!m.find()){
            throw new NoUpperAlphaException();
        }
        return true;
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(password);
        if (!m.find()){
            throw new NoLowerAlphaException();
        }
        return true;
    }

    public static boolean hasDigit(String password) throws NoDigitException{
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(password);
        if (!m.find()){
            throw new NoDigitException();
        }
        return true;
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher(password);
        if(!m.find()){
            throw new NoSpecialCharacterException();
        }
        return true;
    }

    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
        //loops through password comparing the current element to current + 1
        for (int i = 0; i < password.length()-2; i++) {
            if (password.charAt(i) == password.charAt(i+1)) {
                throw new InvalidSequenceException();
            }
        }
        return true;
    }
    public static boolean hasBetweenSixAndNineChars(String password) throws WeakPasswordException{
        if (6 <= password.length() && password.length() <= 9) {
            throw new WeakPasswordException();
        }
        return true;
    }
}
