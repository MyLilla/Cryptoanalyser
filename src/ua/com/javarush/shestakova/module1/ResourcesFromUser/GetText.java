package ua.com.javarush.shestakova.module1.ResourcesFromUser;

import ua.com.javarush.shestakova.module1.Date.Color;

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
        //  String addressText = "D://Cryptoanalyser/result.txt";

        Path path = CheckWay(addressText, System.out);
        String result = null;
        try {
            result = readOfText(path, System.out);
        }catch (RuntimeException e) {
            // e.printStackTrace();
            System.exit(0);
        }
        return result;
    }
    private static Path CheckWay(String addressText, PrintStream out) {
        Path path = null;

        try {
            path = Path.of(addressText);

        if (Files.isDirectory(path)) { // папка
            out.println("Это " + Color.RED + "папка" + Color.RESET + ". Проверьте файл и возвращайтесь");
            System.exit(1);
        }
        if (addressText.isEmpty()) { // пустой путь
            System.out.println("Имя файла " + Color.RED + "не может быть пустым" + Color.RESET +
                    ". Проверьте файл и возвращайтесь");
            System.exit(1);
        }
        if (!(Files.exists(path))) { // не существует
            System.out.println("Такого файла "+ Color.RED +"не существует" + Color.RESET +
                    ". Проверьте файл и возвращайтесь");
            System.exit(1);
        }
        } catch (InvalidPathException e) {
            out.println("Путь указан не верно. Проверьте файл и возвращайтесь.");
            System.exit(0);
        }
        return path;
    }
    public static String readOfText(Path path, PrintStream out) {

        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
            if (list.isEmpty()) {
                out.println("В указаном файле " + Color.RED + "нет данных" + Color.RESET +
                        ", обновите текст и возвращайтесь.");
                throw new RuntimeException ("File is empty");
            }
            if (!(Files.isReadable(path))) {
                out.println("Этот файл невозможно прочитать. Проверь его и возвращайся");
                throw new RuntimeException ("Can't read the file.");
            }
        } catch (IOException ex) {
            out.println("Ошибка чтения полученного файла "); // вылезает СО ВТОРОГО РАЗА если нет в конце .txt
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