package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteText {

    public static void addPath() {
        try { Scanner scanner = new Scanner(System.in);
            System.out.println("Введите адрес, куда сохранить полученный файл: ");

            String pathUsers = scanner.nextLine();
            checkPath(pathUsers);

            Path path = Files.createFile(Path.of(pathUsers + "/result.txt"));
            System.out.println(path);

            System.out.println("Файл \"result\" сохранен по адресу в указанной папке");

        } catch (IOException | RuntimeException e) {
            System.out.println("Вы ввели не корректный путь, повторите " + e);
            addPath();
        }
    }

    public static boolean checkPath(String pathUsers) {
        Path wayToDirectory = Path.of(pathUsers);
        System.out.println(wayToDirectory);
        if (Files.isDirectory(wayToDirectory)) {
            return true;
        } else {
            System.out.println("Указанный путь не является папкой или является системной папкой");
            addPath();
            return false;
        }
    }
}
