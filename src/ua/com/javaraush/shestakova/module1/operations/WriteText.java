package ua.com.javaraush.shestakova.module1.operations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteText {
    public static void startWriting(String result) {

        try {
            String way = getWayForWrite();
            FileOutputStream file = new FileOutputStream(way);
            file.write(result.getBytes(StandardCharsets.UTF_8));
            if (!(way == null)) {
                file.close();
            }
            System.out.println("Результат сохранен в файле: " + way);
        } catch (IOException | RuntimeException e) {
            System.out.println("Вы ввели не корректный путь."); // не могу обработать ниже..

        }

    }

    public static String getWayForWrite() throws IOException {

        System.out.println("Введите адрес папки, куда сохранить полученный файл: ");

        Scanner scanner = new Scanner(System.in);
        String WayDirectoryFromUser = scanner.nextLine();
        if (WayDirectoryFromUser.isEmpty()) {
            System.out.println("Имя папки не может быть пустым. Попрорбуй еще: ");
            getWayForWrite();
        }

        checkDirectory(WayDirectoryFromUser);

        String nameFile = getNameNewFile().trim();

        String way = (WayDirectoryFromUser + "/" + nameFile + ".txt");
        Files.createFile(Path.of(way));

        return way;
    }

    private static void checkDirectory(String pathUsers) throws IOException {
        try {
            Path wayToDirectory = Path.of(pathUsers);

            if (!Files.isDirectory(wayToDirectory)) {
                System.out.println("Указанный путь не является папкой. Попробуй еще: ");
                getWayForWrite();
            }

        } catch (SecurityException ex) {
            System.out.println("Доступ к файлу запрещен");
        }
    }

    private static String getNameNewFile() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя нового файла: ");
        String nameFile = scanner.nextLine();

        if (nameFile.isEmpty()) {
            System.out.println("Имя файла не может быть пустым. Попрорбуй еще: ");
            getNameNewFile();
        }
        if (nameFile.length() > 15) {
            System.out.println("Слишком много буквю Попробуй еще: ");
            getNameNewFile();
        }
        if (nameFile.contains(".") ||
                nameFile.contains(" ") ||
                nameFile.contains("/")) {
            System.out.println("Название не должно содержать пробелов и знаков припинания. Попробуй еще: ");
            getNameNewFile();
        }
        return nameFile;
    }
}
