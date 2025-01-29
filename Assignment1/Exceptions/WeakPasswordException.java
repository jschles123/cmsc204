package Exceptions;

public class WeakPasswordException extends Exception{
    public WeakPasswordException(){}
    public WeakPasswordException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
