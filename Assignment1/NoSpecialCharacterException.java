/**
 Exception for when password does not have a special character
 @author Joshua Schlesinger0
 */

public class NoSpecialCharacterException extends Exception {
    public NoSpecialCharacterException() {
        super("The password must contain at least one special character");
    }
    public NoSpecialCharacterException(String message) {
        super(message);
    }
}
