package ua.com.javarush.shestakova.module1;

import ua.com.javarush.shestakova.module1.algorithms.decodingByBruteForce;
import ua.com.javarush.shestakova.module1.algorithms.Coding;
import ua.com.javarush.shestakova.module1.algorithms.Decoding;
import ua.com.javarush.shestakova.module1.algorithms.decodingByStatisticalAnalysis;
import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;

import java.io.PrintStream;
import java.util.Scanner;

public class Dialog {

    private static String INPUT_KEY_FROM_USER = "Введите число ключа: ";
    private static String SAVED_FILE = "Файл сохранен в указанной папке";
    public static void welcome(PrintStream out) {
        try {
            out.println(Color.GREEN + "Что делать? \n" + Color.RESET);
            out.println("Зашифровать текст введите - 1");
            Thread.sleep(100);
            out.println("Расшифровать текст с помощью ключа введите - 2");
            Thread.sleep(100);
            out.println("Расшифровать текст мотодом \"Brute Force\" введите - 3");
            Thread.sleep(100);
            out.println("Расшифровать текст мотодом \"Статистический анализ\" введите - 4");
            Thread.sleep(100);
            out.println("Выйти из программы введите - 0");
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
                out.println("Число должно быть " + Color.RED + "от 0 до 4" + Color.RESET);
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
                    decodingByBruteForce.startBruteForce();
                    out.println(SAVED_FILE);
                    break;
                case 4:
                    decodingByStatisticalAnalysis.startAnalysis();
                    out.println(SAVED_FILE);
                    break;
                case 0:
                    out.println(Color.CYAN + "Ну и ладно");
                    System.exit(0);
            }

        } catch (NumberFormatException e) {
            out.println("Это не " + Color.RED + "цифра" + Color.RESET);
            throw new InvalidUserInputException("Not number" + e.getMessage() + e);
        }
    }
}
