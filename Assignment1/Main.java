import Exceptions.*;

public class Main {
    public static void main(String[] args) {
        String password = "dwnjmakldnksladwa";

        try{
            PasswordCheckerUtility.isValidPassword(password);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("here");
    }
}

