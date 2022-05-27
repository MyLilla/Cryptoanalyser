package ua.com.javaraush.shestakova.module1.operations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    public static void ChoiceOfOperation() {

        System.out.println("Какую операцию нужно сделать? \n");

        System.out.println(" Зашифровать текст введите - 1 \n " +
                "Расшифровать текст с помощью ключа введите - 2 \n " +
                "Расшифровать текст мотодом \"Brute Force\" введите - 3\n" +
                " Выйти из программы введите - 0");

        Scanner scanner = new Scanner(System.in);
            try {
                int numberOfOperation = Integer.parseInt(scanner.nextLine());

                if (numberOfOperation > 3 || numberOfOperation < 0) {
                    System.out.println("Число должно быть от 0 до 3. Попробуй еще");
                    ChoiceOfOperation();
                }

                switch (numberOfOperation) {
                    case 1:
                        Coding.startCoding();
                        break;
                    case 2:
                        Decoding.startDecoding();
                        break;
                    case 3:
                        BruteForce.startBruteForce();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("А точно есть такой вариант? Попробуй еще");
                        ChoiceOfOperation();
                }

            } catch (NumberFormatException e) {
                System.out.println("Это не целое положительное число из списка. Попробуй еще");
                ChoiceOfOperation();
            }
        }
    }

