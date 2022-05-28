package ua.com.javaraush.shestakova.module1.ResursesFromUser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteText {
    public static void startWriting(String result) {

        try {
            String way = getWayForWrite(System.out);
            FileOutputStream file = new FileOutputStream(way);
            file.write(result.getBytes(StandardCharsets.UTF_8));

            if (!(way == null)) {
                file.close();
            }
            System.out.println("Результат сохранен в файле: " + way);
        } catch (IOException | RuntimeException e) {
            System.out.println("Вы ввели не корректный путь."); // выбрасывает, когда файл с таким именем есть
            System.exit(1);
        }
    }
    public static String getWayForWrite(PrintStream out) throws IOException {

        out.println("Введите адрес папки, куда сохранить полученный файл: ");

        Scanner scanner = new Scanner(System.in);
        String WayDirectoryFromUser = scanner.nextLine();
        if (WayDirectoryFromUser.isEmpty()) {
            System.out.println("Имя папки не может быть пустым. Попрорбуй еще: ");
            getWayForWrite(System.out);
        }
        if ((WayDirectoryFromUser.equals("C:\\Windows") ||
                WayDirectoryFromUser.equals("/etc"))) {
            out.println("Запись в эту папку может повредить систему. Выбери другую");
            getWayForWrite(System.out);
        }

        checkDirectory(WayDirectoryFromUser, System.out);

        String nameFile = getNameNewFile(System.out).trim();

        String way = (WayDirectoryFromUser + "/" + nameFile + ".txt");
        Files.createFile(Path.of(way));

        return way;
    }
    private static void checkDirectory(String pathUsers, PrintStream out) throws IOException {
        try {
            Path wayToDirectory = Path.of(pathUsers);

            if (!Files.isDirectory(wayToDirectory)) {
               out.println("Указанный путь не является папкой. Попробуй еще: ");
                getWayForWrite(System.out);
            }
        } catch (SecurityException ex) {
            System.out.println("Доступ к файлу запрещен");
        }
    }

    private static String getNameNewFile(PrintStream out) {
        Scanner scanner = new Scanner(System.in);

       out.println("Введите имя нового файла: ");
        String nameFile = scanner.nextLine();

        if (nameFile.isEmpty()) {
            System.out.println("Имя файла не может быть пустым. Попрорбуй еще: ");
            getNameNewFile(System.out);
        }
        if (nameFile.length() > 15) {
            System.out.println("Слишком много буквю Попробуй еще: ");
            getNameNewFile(System.out);
        }
        if (nameFile.contains(".") ||
                nameFile.contains(" ") ||
                nameFile.contains("/")) {
            System.out.println("Название не должно содержать пробелов и знаков припинания. Попробуй еще: ");
            getNameNewFile(System.out);
        }
        return nameFile;
    }
}
