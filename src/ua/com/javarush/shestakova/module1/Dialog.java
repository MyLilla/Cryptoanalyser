package ua.com.javarush.shestakova.module1;

import ua.com.javarush.shestakova.module1.algorithms.BruteForce;
import ua.com.javarush.shestakova.module1.algorithms.Coding;
import ua.com.javarush.shestakova.module1.algorithms.Decoding;
import ua.com.javarush.shestakova.module1.algorithms.StatisticalAnalysis;
import ua.com.javarush.shestakova.module1.date.Color;

import java.io.PrintStream;
import java.util.Scanner;

public class Dialog {

    public static String INPUT_KEY_FROM_USER = "Введите число ключа: ";
    public static String SAVED_FILE = "Файл сохранен в указанной папке";
    public static void welcome(PrintStream out) {
        try {
            out.println(Color.GREEN + "Что делать? \n" + Color.RESET);
            Thread.sleep(300);
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
                System.out.println("Число должно быть " + Color.RED + "от 0 до 4" + Color.RESET + ". Попробуй еще");
                choiceOfOperation(System.out);
            }
            switch (numberOfOperation) {
                case 1:
                    System.out.println(INPUT_KEY_FROM_USER);
                    Coding.startCoding();
                    break;
                case 2:
                    System.out.println(INPUT_KEY_FROM_USER);
                    Decoding.startDecoding();
                    System.out.println(SAVED_FILE);
                    break;
                case 3:
                    BruteForce.startBruteForce();
                    System.out.println(SAVED_FILE);
                    break;
                case 4:
                    StatisticalAnalysis.startAnalysis();
                    System.out.println(SAVED_FILE);
                    break;
                case 0:
                    out.println(Color.CYAN + "Ну и ладно, ходи не расшифрованный");
                    System.exit(0);
                default:
                    System.out.println("А точно есть такой вариант? Попробуй еще");
                    choiceOfOperation(System.out);
            }

        } catch (NumberFormatException e) {
            out.println("Это не " + Color.RED + "цифра" + Color.RESET + ". Попробуй еще");
            choiceOfOperation(System.out);
        }
    }
}
