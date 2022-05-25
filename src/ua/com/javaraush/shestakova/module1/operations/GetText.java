package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class GetText {

    public static String getTextFromUser() {
        try {
           //  System.out.println("Please, write address your file: ");

            Scanner scanner = new Scanner(System.in);
           // String test = scanner.nextLine();
            String test = "D://Cryptoanalyser/test.txt";

            List<String> list = Files.readAllLines(Path.of(test));

            StringBuilder builder1 = new StringBuilder();
            for (String x : list) {
                builder1.append(x);
            }

            String text = builder1.toString().toLowerCase();

            return text;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
