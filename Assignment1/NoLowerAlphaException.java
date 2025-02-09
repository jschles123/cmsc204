/**
 Exception for when password does not have a uppercase character
 @author Joshua Schlesinger0
 */

public class NoLowerAlphaException extends Exception{
    public NoLowerAlphaException(){
        super("The password must contain at least one lowercase alphabetic character");
    }
    public NoLowerAlphaException(String message){
        super(message);
    }
}
