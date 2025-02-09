/**
 Exception for when password is between 6-9 characters
 @author Joshua Schlesinger0
 */

public class WeakPasswordException extends Exception{
    public WeakPasswordException(){
        super("The password is OK but weak - it contains fewer than 10 characters.");
    }
    public WeakPasswordException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
