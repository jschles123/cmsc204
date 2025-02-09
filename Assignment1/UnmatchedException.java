/**
 Exception for when passwords dont match
 @author Joshua Schlesinger0
 */

public class UnmatchedException extends Exception{
    public UnmatchedException(){
        super("Passwords do not match");
    }
    public UnmatchedException(String message){
        super(message);
    }
}
