package ua.com.javaraush.shestakova.module1.operations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    public static void welcome() {

        System.out.println(" Зашифровать текст введите - 1 \n " +
                "Расшифровать текст с помощью ключа введите - 2 \n " +
                "Расшифровать текст мотодом \"Brute Force\" введите - 3\n" +
                " Выйти из программы введите - 0");

        Scanner scanner = new Scanner(System.in);
        try {
            int value = scanner.nextInt();

            switch (value) {
                case 1:
                    Coding encryption = new Coding();
                    encryption.startCoding();
                    break;
                case 2:
                    Decoding decoding = new Decoding();
                    decoding.startDecoding();
                    break;
                case 3:
                    BruteForce bruteForce = new BruteForce();
                    bruteForce.startBruteForce();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("А точно есть такой вариант? Попробуйте еще раз");
                    welcome();
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Это не целое положительное число из списка, повторите");
            welcome();
        }
    }
}
