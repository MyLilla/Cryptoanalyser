package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.util.Scanner;

public class dialog {
    public void welcome() {
        System.out.println("Hello! What operation you want to do? \n");

        System.out.println("if you want to encrypt your text, enter the number 1 \n " +
                "if you want to decrypt the text using the key, enter the number 2 \n " +
                "If you want to exit the program, enter the number 0");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        switch (value) {
            case 1:
                encryption encryption = new encryption();
                try {
                    encryption.startEncryption();
                } catch (IOException e) {
                    System.out.println("You added incorrect value " + e);
                    return;

                }
            case 0:
                System.exit(0);

            case 2:
                decoding decoding = new decoding();
                try {
                    decoding.startDecoding();
                    ;
                } catch (IOException e) {
                    System.out.println("You added incorrect value " + e);
                    return;
                }
        }
    }
}
