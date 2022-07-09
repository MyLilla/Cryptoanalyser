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

import static java.lang.System.out;

public class GetText {

    public static String startGetText() {

        Path wayToFile = getPathFromUser(out);

        String result = readOfText(wayToFile, out);

        return result;
    }
    public static Path getPathFromUser(PrintStream out) {

        out.println("Enter the full address of the text document: ");

        Scanner scanner = new Scanner(System.in);
        String addressText = scanner.nextLine();

        while (!checkPath(addressText, System.out)) {
            addressText = scanner.nextLine();
        }
        Path path;
        try {
            path = Path.of(addressText);
        } catch (InvalidPathException e) {
            throw new InvalidUserInputException("Incorrect path" + e.getMessage() + addressText);
            }
        return path;
    }

    private static boolean checkPath(String addressText, PrintStream out) {
        boolean resultCheck = true;
        Path path = Path.of(addressText);
        if (addressText.isEmpty()) {
            out.println("Fie name " + Color.RED + "can't be empty" + Color.RESET);
            return false;
        }
        else if (Files.isDirectory(path)) {
            out.println("It is " + Color.RED + "folder" + Color.RESET);
            return false;
        }
        if (!(Files.exists(path))) {
            out.println("This file " + Color.RED + "doesn't exist" + Color.RESET);
            return false;
        }
        return resultCheck;
    }

    public static String readOfText(Path path, PrintStream out) {

        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
            if (list.isEmpty()) {
                out.println("There is " + Color.RED + "not text" + Color.RESET);
                throw new FileProcessingException("File is empty" + path);
            }
            if (!(Files.isReadable(path))) {
                out.println("This file cannot be read.");
                throw new FileProcessingException("Can't read the file." + path);
            }
        } catch (IOException ex) {
            throw new FileProcessingException("File read error" + ex + path);
        }
        StringBuilder builderNewText = new StringBuilder();
        for (String x : list) {
            builderNewText.append(x);
        }
        return builderNewText.toString().toLowerCase();
    }
}
