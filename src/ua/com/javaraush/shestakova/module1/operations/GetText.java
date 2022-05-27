package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetText {

    public static String getTextFromUser() {

        System.out.println("Введите полный адрес текстового документа : ");

        Scanner scanner = new Scanner(System.in);
        String addressText = scanner.nextLine();
        //  String addressText = "D://Cryptoanalyser/result2.txt";

        Path path = CheckWay(addressText);
        String result = null;
        try {
           result = readOfText(path, System.out);
        }catch (RuntimeException e) {
           // e.printStackTrace();
            System.exit(0);
        }
        return result;
    }
    private static Path CheckWay(String addressText) {
        Path path = null; // InvalidPathException

        try {
            path = Path.of(addressText);
        } catch (InvalidPathException e) {
            System.out.println("Путь не путь");
            System.exit(1);
        }
        if (Files.isDirectory(path)) {
            System.out.println("Такой директрии не существует.");
            System.exit(1);
        }
        checkWayFromUser(addressText, path);
        return path;
    }

    private static void checkWayFromUser(String addressText, Path path) {
        if (addressText.isEmpty()) {
            System.out.println("Имя файла не может быть пустым. Попробуй еще:");
            getTextFromUser();
        }
        if (!(Files.exists(path))) {
            System.out.println("Такого файла не существует. Попробуй еще: ");
            getTextFromUser();
        }
    }

    public static String readOfText(Path path, PrintStream out) {

        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
            if (list.isEmpty()) {
                out.println("В указаном файле нет данных, обновите текст и возвращайтесь.");
               throw new RuntimeException ("File is empty");
            }
            if (!(Files.isReadable(path))) {
                out.println("Этот файл невозможно прочитать. Проверь его и возвращайся");
                throw new RuntimeException ("Can't read the file.");
            }
        } catch (IOException ex) {
            out.println("Ошибка чтения полученного файла ");
            System.exit(1);
        }
        StringBuilder builder1 = new StringBuilder();
        for (String x : list) {
            builder1.append(x);
        }
        String result = builder1.toString().toLowerCase();
        return result;
    }
}
