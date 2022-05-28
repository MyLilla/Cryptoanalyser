package ua.com.javaraush.shestakova.module1.ResursesFromUser;

import ua.com.javaraush.shestakova.module1.Algorithms.Coding;
import ua.com.javaraush.shestakova.module1.Other.Color;

import java.io.PrintStream;
import java.util.Scanner;

public class GetKey {

    public static int getTheKey(PrintStream out) {

        int KEY = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            KEY = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            out.println("Это " + Color.RED + "не число!" + Color.RESET +" Попробуй еще: ");
            Coding.startCoding();
        }
        return KEY;
    }
}