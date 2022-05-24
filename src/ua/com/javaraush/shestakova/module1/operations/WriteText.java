package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteText {

    public static void addPath () {
       try {
           System.out.println("Введите адрес, куда сохранить полученный файл: ");
           Scanner scanner = new Scanner(System.in);
           String pathUsers = scanner.nextLine();

           Path path = Files.createFile(Path.of(pathUsers + "/result.txt"));
           System.out.println(path);

       }catch (Exception e) {

       }
    }
}
