import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * STUDENT Password Checker Utility class
 * @author Joshua Schlesinger-Guevara
 *
 */

public class PasswordCheckerUtility {


    public PasswordCheckerUtility() {
    }

    /**
     * IsValidPassword
     * @param password
     * @throws InvalidSequenceException
     * @throws LengthException
     * @throws NoDigitException
     * @throws NoLowerAlphaException
     * @throws NoSpecialCharacterException
     * @throws NoUpperAlphaException
     */

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

    /**
     * isWeakPassword
     * @param password
     * @throws WeakPasswordException
     * @throws LengthException
     * @throws NoLowerAlphaException
     * @throws NoSpecialCharacterException
     * @throws NoDigitException
     * @throws InvalidSequenceException
     * @throws NoUpperAlphaException
     */

    public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoLowerAlphaException, NoSpecialCharacterException, NoDigitException, InvalidSequenceException, NoUpperAlphaException {
        PasswordCheckerUtility.isValidPassword(password);
        if (password.length() >= 6 && password.length() <= 9) {
            throw new WeakPasswordException();
        }
        return false;
    }

    /**
     * getInvalidPasswords
     * @param passwords
     */

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

    /**
     * comparePasswordsWithReturn
     * @param password1
     * @param password2
     */

    public static boolean comparePasswordsWithReturn(String password1, String password2) {
        return password1.equals(password2);
    }

    /**
     * compares passwords and returns equality
     * @param password1
     * @param password2
     * @throws UnmatchedException
     */

    public static boolean comparePasswords(String password1, String password2) throws UnmatchedException {
        if (!password1.equals(password2)){
            throw new UnmatchedException();
        }
        return true;
    }

    /**
     * checks if length is valid
     * @param password
     * @throws LengthException
     */

    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException();
        }
        return true;
    }

    /**
     * checks if uppercase character
     * @param password
     * @throws NoUpperAlphaException
     */


    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(password);
        if(!m.find()){
            throw new NoUpperAlphaException();
        }
        return true;
    }

    /**
     * checks if lowercase character
     * @param password
     * @throws NoLowerAlphaException
     */

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(password);
        if (!m.find()){
            throw new NoLowerAlphaException();
        }
        return true;
    }


    /**
     * checks if digit
     * @param password
     * @throws NoDigitException
     */

    public static boolean hasDigit(String password) throws NoDigitException{
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(password);
        if (!m.find()){
            throw new NoDigitException();
        }
        return true;
    }

    /**
     * checks if special character
     * @param password
     * @return
     * @throws NoSpecialCharacterException
     */

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher(password);
        if(!m.find()){
            throw new NoSpecialCharacterException();
        }
        return true;
    }

    /**
     * checks if there are 2 of the same chars next to eachother
     * @param password
     * @throws InvalidSequenceException
     */

    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
        //loops through password comparing the current element to current + 1
        for (int i = 0; i < password.length()-2; i++) {
            if (password.charAt(i) == password.charAt(i+1)) {
                throw new InvalidSequenceException();
            }
        }
        return true;
    }


    /**
     * checks if weak password
     * @param password
     * @throws WeakPasswordException
     */

    public static boolean hasBetweenSixAndNineChars(String password) throws WeakPasswordException{
        if (6 <= password.length() && password.length() <= 9) {
            throw new WeakPasswordException();
        }
        return true;
    }
}
