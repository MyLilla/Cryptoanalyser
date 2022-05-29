package ua.com.javarush.shestakova.module1.ResourcesFromUser;


public class FileProcessingException extends RuntimeException {

    public FileProcessingException (String message) {
        super(message);
        System.exit(1);
    }

}
