package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class GetText {

    public static String getWayFromFromUser() {

        System.out.println("Введите адрес текстового документа в формате \"С://Новая папка/text.txt\": ");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //  String test = "D://Cryptoanalyser/result.txt";

        Path path = getPath(text);
        return readOfText(path);
    }

    private static Path getPath(String text) {
        Path path = null;
        try {
            path = Path.of(text);
        } catch (InvalidPathException e) {  // Path(of)  // dfbdfgjb
            System.out.println("Путь не путь");
        }
        if (Files.isDirectory(path)) {
            System.out.println("Такой директрии не существует.");
            System.exit(1);
        }
        return path;
    }
    public static String readOfText(Path path) {

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
        String result = builder1.toString().toLowerCase();

        return result;

    }

}


