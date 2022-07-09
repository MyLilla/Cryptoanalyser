package ua.com.javarush.shestakova.module1;

import ua.com.javarush.shestakova.module1.algorithms.DecodingByBruteForce;
import ua.com.javarush.shestakova.module1.algorithms.Coding;
import ua.com.javarush.shestakova.module1.algorithms.Decoding;
import ua.com.javarush.shestakova.module1.algorithms.DecodingByStatisticalAnalysis;
import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;

import java.io.PrintStream;
import java.util.Scanner;

public class Dialog {

    private static String INPUT_KEY_FROM_USER = "Enter key number: ";
    private static String SAVED_FILE = "The file is saved in the specified folder";
    public static void welcome(PrintStream out) {
        try {
            out.println(Color.GREEN + "What do you want to do? \n" + Color.RESET);
            out.println("Encrypt text enter - 1");
            Thread.sleep(100);
            out.println("Decrypt text using key enter - 2");
            Thread.sleep(100);
            out.println("Decrypt text using \"Brute Force\" enter - 3");
            Thread.sleep(100);
            out.println("Decrypt text using \"Статистический анализ\" enter - 4");
            Thread.sleep(100);
            out.println("for exit enter - 0");
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception with sleep." + e);
        }
        choiceOfOperation(System.out);
    }

    public static void choiceOfOperation(PrintStream out) {

        Scanner scanner = new Scanner(System.in);
        try {
            int numberOfOperation = Integer.parseInt(scanner.nextLine());

            if (numberOfOperation > 4 || numberOfOperation < 0) {
                out.println("The number must be " + Color.RED + "from 0 to 4" + Color.RESET);
               throw new InvalidUserInputException ("Incorrect number");
            }
            switch (numberOfOperation) {
                case 1:
                    out.println(INPUT_KEY_FROM_USER);
                    Coding.startCoding();
                    out.println(SAVED_FILE);
                    break;
                case 2:
                    out.println(INPUT_KEY_FROM_USER);
                    Decoding.startDecoding();
                    out.println(SAVED_FILE);
                    break;
                case 3:
                    DecodingByBruteForce.startBruteForce();
                    out.println(SAVED_FILE);
                    break;
                case 4:
                    DecodingByStatisticalAnalysis.startAnalysis();
                    out.println(SAVED_FILE);
                    break;
                case 0:
                    out.println(Color.CYAN + "Ok");
                    System.exit(0);
            }

        } catch (NumberFormatException e) {
            out.println("It is not " + Color.RED + "number" + Color.RESET);
            throw new InvalidUserInputException("Not number" + e.getMessage() + e);
        }
    }
}
