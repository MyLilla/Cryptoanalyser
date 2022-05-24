package ua.com.javaraush.shestakova.module1.operations;

import java.util.Scanner;

public class GetKey {

    public static int KEY = getTheKey();

    public static int getTheKey() {
        System.out.println("Please, write KEY for your cipher: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
