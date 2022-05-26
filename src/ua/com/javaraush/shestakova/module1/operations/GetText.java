package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetText {

    public static String getTextFromUser() {

        System.out.println("Введите адрес документа : ");

        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        //  String test = "D://Cryptoanalyser/result.txt";

        Path path = null;
        try {
            path = Path.of(test);
        } catch (InvalidPathException e) {  // Path(of)
            System.out.println("Путь не путь");
        }
        if (Files.isDirectory(path)) {
            System.out.println("Такой директрии не существует.");
            System.exit(1);
        }
//        try {
//            if (Files.newDirectoryStream(path).iterator().hasNext()) {
//                System.out.println("Папка пустая.");
//                System.exit(1);
//            }
//        } catch (IOException ex) {
//            System.out.println("Произошла ошибка. Причина: " + ex.getMessage());
//        }

        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла: " + path + "Причина: " + ex.getMessage());
        }

        StringBuilder builder1 = new StringBuilder();
        for (String x : list) {
            builder1.append(x);
        }

        String text = builder1.toString().toLowerCase();

        return text;
    }

}
