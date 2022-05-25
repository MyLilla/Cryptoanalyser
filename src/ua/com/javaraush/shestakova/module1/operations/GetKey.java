package ua.com.javaraush.shestakova.module1.operations;

import java.util.Scanner;

public class GetKey {
    public static int KEY = getTheKey();

    public static int getTheKey() {

        System.out.println("Введите число ключа: ");
        Scanner scanner = new Scanner(System.in);
        int KEY = scanner.nextInt();
        return KEY;
    }

    public static void checkKey(int KEY) {
        if (KEY > 100 || KEY < 100) {
            System.out.println("Слишком много цифр, попробуйте поменьше");
            getTheKey();
        }
    }
}