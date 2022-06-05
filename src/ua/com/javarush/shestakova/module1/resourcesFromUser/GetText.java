package ua.com.javarush.shestakova.module1.resourcesFromUser;

import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.FileProcessingException;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetText {

    public static String getPathFromUser() {

        System.out.println("Введите полный адрес текстового документа : ");

        Scanner scanner = new Scanner(System.in);
        String addressText = scanner.nextLine();
        Path path = getWay(addressText, System.out);

        String result = readOfText(path, System.out);

        return result;
    }

    private static Path getWay(String addressText, PrintStream out) {
        Path path = null;
        try {
            path = Path.of(addressText);
            checkPath(addressText, out, path);
        } catch (InvalidPathException e) {
            out.println("Путь указан не верно. Проверьте файл и возвращайтесь.");
            throw new InvalidUserInputException ("Incorrect way" + e);
        }
        return path;
    }

    private static void checkPath(String addressText, PrintStream out, Path path) {

            if (addressText.isEmpty()) {
                out.println("Имя файла " + Color.RED + "не может быть пустым" + Color.RESET);
                throw new InvalidUserInputException("File name is empty");
            }
            if (Files.isDirectory(path)) {
                out.println("Это " + Color.RED + "папка" + Color.RESET);
                throw new InvalidUserInputException("File name is directory");
            }
            if (!(Files.exists(path))) {
                out.println("Такого файла " + Color.RED + "не существует" + Color.RESET);
               throw new InvalidUserInputException("Nt exist file");

            }
    }

    public static String readOfText(Path path, PrintStream out) {

        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
            if (list.isEmpty()) {
                out.println("В указаном файле " + Color.RED + "нет данных" + Color.RESET);
                throw new FileProcessingException("File is empty" + path);
            }
            if (!(Files.isReadable(path))) {
                out.println("Этот файл невозможно прочитать.");
                throw new FileProcessingException("Can't read the file." + path);
            }
        } catch (IOException ex) {
            throw new FileProcessingException("File read error" + ex + path);
        }
        StringBuilder builderNewText = new StringBuilder();
        for (String x : list) {
            builderNewText.append(x);
        }
        String result = builderNewText.toString().toLowerCase();
        return result;
    }
}
