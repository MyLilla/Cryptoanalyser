package ua.com.javarush.shestakova.module1.exceptions;


public class FileProcessingException extends RuntimeException {

    public FileProcessingException (String message) {
        super(message);
        System.exit(0);
    }

}