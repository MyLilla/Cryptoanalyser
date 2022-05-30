package ua.com.javarush.shestakova.module1.resourcesFromUser;

import ua.com.javarush.shestakova.module1.exceptions.FileProcessingException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteText {
    public static final int MAX_LONG_NAME_FILE = 15;
    public static void startWriting(String result) {

        try {
            String way = getWayForWrite(System.out);
            FileOutputStream file = new FileOutputStream(way);
            file.write(result.getBytes(StandardCharsets.UTF_8));

            if ((way != null)) {
                file.close();
            }
            System.out.println("Результат сохранен в файле: " + way);
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
            System.out.println("Имя папки не может быть пустым. Проверьте файл и возвращайтесь");
            System.exit(0);
        }
        if ((WayDirectoryFromUser.equals("C:\\Windows") ||
                WayDirectoryFromUser.equals("/etc"))) {
            out.println("Запись в эту папку может повредить систему. Проверьте файл и возвращайтесь");
            System.exit(0);
        }

        checkDirectory(WayDirectoryFromUser, System.out);
        String nameFile = getNewFileName(System.out).trim();

        String way = (WayDirectoryFromUser + "/" + nameFile + ".txt");

        Files.createFile(Path.of(way));

        return way;
    }
    private static void checkDirectory (String pathUsers, PrintStream out) {
        try {
            Path wayToDirectory = Path.of(pathUsers);

            if (!Files.isDirectory(wayToDirectory)) {
               out.println("Указанный путь не является папкой. Проверьте файл и возвращайтесь");
                System.exit(0);
            }
        } catch (SecurityException ex) {
            System.out.println("Доступ запрещен");
            throw new FileProcessingException("No access" + ex);
        }
    }
    private static String getNewFileName (PrintStream out) {
        Scanner scanner = new Scanner(System.in);

       out.println("Введите имя нового файла: ");
        String nameFile = scanner.nextLine();

        if (nameFile.isEmpty()) {
            System.out.println("Имя файла не может быть пустым.");
            System.exit(0);
        }
        if (nameFile.length() > MAX_LONG_NAME_FILE) {
            System.out.println("Слишком много букв.");
            System.exit(0);

        }
        if (nameFile.contains(".") ||
                nameFile.contains(" ") ||
                nameFile.contains("/")) {
            System.out.println("Название не должно содержать пробелов и знаков припинания.");
            System.exit(0);
        }
        return nameFile;
    }
}
