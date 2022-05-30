package ua.com.javarush.shestakova.module1.resourcesFromUser;

import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.FileProcessingException;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetText {

    public static String getTextFromUser() {

        System.out.println("Введите полный адрес текстового документа : ");

        Scanner scanner = new Scanner(System.in);
        String addressText = scanner.nextLine();

        Path path = checkWay(addressText, System.out);

        String result = readOfText(path, System.out);

        return result;
    }

    private static Path checkWay(String addressText, PrintStream out) {
        Path path = null;
        try {
            path = Path.of(addressText);

            if (addressText.isEmpty()) {
                System.out.println("Имя файла " + Color.RED + "не может быть пустым" + Color.RESET +
                        ". Проверьте файл и возвращайтесь");
                System.exit(0);
            }
            if (Files.isDirectory(path)) {
                out.println("Это " + Color.RED + "папка" + Color.RESET + ". Проверьте файл и возвращайтесь");
                System.exit(0);
            }
            if (!(Files.exists(path))) {
                System.out.println("Такого файла " + Color.RED + "не существует" + Color.RESET +
                        ". Проверьте файл и возвращайтесь");
                System.exit(0);
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
                throw new FileProcessingException("File is empty" + path);
            }
            if (!(Files.isReadable(path))) {
                out.println("Этот файл невозможно прочитать. Проверь его и возвращайся");
                throw new FileProcessingException("Can't read the file." + path);
            }
        } catch (IOException ex) {
            throw new FileProcessingException("Ошибка чтения полученного файла" + ex + path);
        }
        StringBuilder builderNewText = new StringBuilder();
        for (String x : list) {
            builderNewText.append(x);
        }
        String result = builderNewText.toString().toLowerCase();
        return result;
    }
}
