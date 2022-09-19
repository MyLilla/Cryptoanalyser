package ua.com.javarush.shestakova.module1.resourcesFromUser;

import ua.com.javarush.shestakova.module1.exceptions.FileProcessingException;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteText {
    private static final int MAX_LONG_NAME_FILE = 15;
    public static void startWriting(String result) {

        try {
            String way = getWayForWrite(System.out);
            FileOutputStream file = new FileOutputStream(way);
            file.write(result.getBytes(StandardCharsets.UTF_8));

            if ((way != null)) {
                file.close();
            }
        } catch (IOException e) {
            System.out.println("Вы ввели не корректный путь. Возможно, файл с таким именем уже есть.");
          throw new FileProcessingException("incorrect path" + e);
        }
    }
    public static String getWayForWrite (PrintStream out) throws IOException {

        out.println("Введите адрес папки, куда сохранить полученный файл: ");

        Scanner scanner = new Scanner(System.in);
        String WayDirectoryFromUser = scanner.nextLine();

        if (WayDirectoryFromUser.isEmpty()) {
            out.println("Имя папки не может быть пустым. Проверьте файл и возвращайтесь");
            throw new InvalidUserInputException("Name is empty");
        }
        if ((WayDirectoryFromUser.equals("C:\\Windows") ||
                WayDirectoryFromUser.equals("/etc"))) {
            out.println("Запись в эту папку может повредить систему. Проверьте файл и возвращайтесь");
            throw new InvalidUserInputException("Write in the system file");
        }

        createDirectory(WayDirectoryFromUser, System.out);
        String nameFile = getNewFileName(System.out).trim();

        String way = (WayDirectoryFromUser + "/" + nameFile + ".txt");

        Files.createFile(Path.of(way));

        return way;
    }
    private static void createDirectory(String pathUsers, PrintStream out) {
        try {
            Path wayToDirectory = Path.of(pathUsers);

            if (!Files.isDirectory(wayToDirectory)) {
               out.println("Указанный путь не является папкой.");
                throw new InvalidUserInputException("Not directory");
            }
        } catch (SecurityException ex) {
            out.println("Доступ запрещен");
            throw new FileProcessingException("No access" + ex);
        }
    }
    private static String getNewFileName (PrintStream out) {
        Scanner scanner = new Scanner(System.in);

       out.println("Введите имя нового файла: ");
        String nameFile = scanner.nextLine();

        if (nameFile.isEmpty()) {
            out.println("Имя файла не может быть пустым.");
            throw new InvalidUserInputException("File name is empty");
        }
        if (nameFile.length() > MAX_LONG_NAME_FILE) {
            out.println("Слишком много букв.");
            throw new InvalidUserInputException("Very long file name");

        }
        if (nameFile.contains(".") ||
                nameFile.contains(" ") ||
                nameFile.contains("/")) {
           out.println("Название не должно содержать пробелов и знаков припинания.");
            throw new InvalidUserInputException("File name have punctuation marks");
        }
        return nameFile;
    }
}
