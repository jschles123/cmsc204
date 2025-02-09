/**
 Exception for when password does not contain a digit
 @author Joshua Schlesinger0
 */

public class NoDigitException extends Exception {
    public NoDigitException() {
        super("The password must contain at least one digit");
    }
    public NoDigitException(String message) {
        super(message);
    }
}
