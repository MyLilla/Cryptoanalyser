package ua.com.javaraush.shestakova.module1.operations;

import java.util.Scanner;

public class GetKey {

    public static int getTheKey() {

        int KEY = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            KEY = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Это не число. Попробуй еще: ");
            Coding.startCoding();
        }
        return KEY;
    }
}
