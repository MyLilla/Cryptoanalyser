package ua.com.javarush.shestakova.module1.resourcesFromUser;

import ua.com.javarush.shestakova.module1.algorithms.Coding;
import ua.com.javarush.shestakova.module1.date.Color;

import java.io.PrintStream;
import java.util.Scanner;

public class KeyService {
    public static int getKey(PrintStream out) {

        int KEY = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            KEY = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            out.println("Это " + Color.RED + "не число" + Color.RESET + " Попробуй еще: ");
            Coding.startCoding();
        }
        return KEY;
    }
}
