/**
 Exception for when password > 6 characters
 @author Joshua Schlesinger0
 */

public class LengthException extends Exception{
    public LengthException(){
        super("The password must be at least 6 characters long");
    }
    public LengthException(String message){
        super(message);
    }
}
