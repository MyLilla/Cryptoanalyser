package ua.com.javarush.shestakova.module1.exceptions;

public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException (){

    }
    public InvalidUserInputException (String message) {
        super (message);
    }
}
