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
            String way = getWay();
            FileOutputStream file = new FileOutputStream(way);
            file.write(result.getBytes(StandardCharsets.UTF_8));
            file.close();

            System.out.println("Файл сохранен в указанной папке");

        } catch (IOException | RuntimeException e) {
            System.out.println("Вы ввели не корректный путь, повторите " + e);
        }
    }

    public static String getWay() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес папки, куда сохранить полученный файл: ");

        String pathUsers = scanner.nextLine();
        checkPath(pathUsers);
        System.out.println("Введите имя нового файла: ");
        String nameFile = scanner.nextLine();

        String way = (pathUsers + "/" + nameFile + ".txt");
        Path path = Files.createFile(Path.of(way));
        System.out.println(path);
        return way;
    }

    public static boolean checkPath(String pathUsers) {
        Path wayToDirectory = Path.of(pathUsers);
        System.out.println(wayToDirectory);
        if (Files.isDirectory(wayToDirectory)) {
            return true;
        } else {
            System.out.println("Указанный путь не является папкой или является системной папкой");
            return false;
        }
    }
}

//        try {
//            if (Files.newDirectoryStream(path).iterator().hasNext()) {
//                System.out.println("Папка пустая.");
//                System.exit(1);
//            }
//        } catch (IOException ex) {
//            System.out.println("Произошла ошибка. Причина: " + ex.getMessage());
//        }
