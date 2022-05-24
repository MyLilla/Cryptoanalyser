package ua.com.javaraush.shestakova.module1.operations;

import java.util.Scanner;

public class Dialog {
    public void welcome() {
        System.out.println("Hello! What operation you want to do? \n");

        System.out.println("Зашифровать текст введите - 1 \n " +
                "Расшифровать текст с помощью ключа введите - 2 \n " +
                "Расшифровать текст мотодом \"Brute Force\" введите - 3" +
                "Выйти из программы введите - 0");
        Scanner scanner = new Scanner(System.in);
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
            case 0:
                System.exit(0);
                break;
        }
    }
}
