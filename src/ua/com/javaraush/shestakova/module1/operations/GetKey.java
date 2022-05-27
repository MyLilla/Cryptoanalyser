package ua.com.javaraush.shestakova.module1.operations;

import java.util.Scanner;

public class GetKey {
    public static int KEY = getTheKey();

    public static int getTheKey() {

        System.out.println("Введите число ключа: ");

        Scanner scanner = new Scanner(System.in);
        try {
            KEY = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Это не число. Попробуй еще: ");
            getTheKey();
        }
        return KEY;
    }
    public static void checkKey(int KEY) {
        if (KEY > 100 || KEY < 100) {
            System.out.println("Слишком много цифр, попробуйте поменьше");
            getTheKey();
        }
    }
}

