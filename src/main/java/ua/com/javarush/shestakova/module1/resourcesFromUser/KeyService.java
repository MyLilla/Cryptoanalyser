package ua.com.javarush.shestakova.module1.resourcesFromUser;

import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;

import java.io.PrintStream;
import java.util.Scanner;

public class KeyService {
    public static int getKey(PrintStream out) {

        int KEY = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            KEY = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            out.println("It is " + Color.RED + "not number" + Color.RESET);
            throw new InvalidUserInputException("Not number" + e);
        }
        return KEY;
    }
}
