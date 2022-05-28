package ua.com.javaraush.shestakova.module1.Other;


import ua.com.javaraush.shestakova.module1.Algorithms.BruteForce;
import ua.com.javaraush.shestakova.module1.Algorithms.Coding;
import ua.com.javaraush.shestakova.module1.Algorithms.Decoding;

import java.io.PrintStream;
import java.util.Scanner;

public class Dialog {

    public static String INPUT_KEY_FROM_USER = "Введите число ключа: ";
    public static void ChoiceOfOperation(PrintStream out) {

        try {
       out.println(Color.RED + "Какую операцию нужно сделать? \n" + Color.RESET);
            Thread.sleep(400);

        out.println ("Зашифровать текст введите - 1");
            Thread.sleep(300);
        out.println("Расшифровать текст с помощью ключа введите - 2");
            Thread.sleep(300);
        out.println("Расшифровать текст мотодом \"Brute Force\" введите - 3");
            Thread.sleep(300);
        out.println("Выйти из программы введите - 0");
    } catch (InterruptedException e) {
        throw new RuntimeException("Exception with sleep." + e);
    }
        Scanner scanner = new Scanner(System.in);
            try {
                int numberOfOperation = Integer.parseInt(scanner.nextLine());

                if (numberOfOperation > 3 || numberOfOperation < 0) {
                    System.out.println("Число должно быть от 0 до 3. Попробуй еще");
                    ChoiceOfOperation(System.out);
                }

                switch (numberOfOperation) {
                    case 1:
                        System.out.println(INPUT_KEY_FROM_USER);
                        Coding.startCoding();
                        break;
                    case 2:
                        System.out.println(INPUT_KEY_FROM_USER);
                        Decoding.startDecoding();
                        System.out.println("Файл сохранен в указанной папке");
                        break;
                    case 3:
                        BruteForce.startBruteForce();
                        break;
                    case 0:
                        out.println(Color.CYAN + "Ну и ладно, ходи не расшифрованный");
                        System.exit(0);
                    default:
                        System.out.println("А точно есть такой вариант? Попробуй еще");
                        ChoiceOfOperation(System.out);
                }

            } catch (NumberFormatException e) {
                System.out.println("Это не целое положительное число из списка. Попробуй еще");
                ChoiceOfOperation(System.out);
            }
        }
    }
