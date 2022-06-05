package exceptions;

public class StudentNotFoundException extends Exception{
    private final String message = "USER_NOT_FOUND";
    public String getMessage(){ return message; }
}
