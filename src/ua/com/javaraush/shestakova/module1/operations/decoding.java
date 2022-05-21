package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class decoding {

    public void startDecoding() throws IOException {
        stepsDecoding();
    }
    public void stepsDecoding () throws IOException {

        int key = getKey();
        char[] textArray = getText();
        StringBuilder result = new StringBuilder();

        for (char letter : textArray) {
            for (int i = 1; i < alphabet.alphabetLength; i++) {
                if (letter == alphabet.ALPHABET[i]){
                    if (key == (i +1)) {
                        result.append(alphabet.ALPHABET[alphabet.alphabetLength - 1]);
                        break;
                    } else if (i > key){
                        letter = alphabet.ALPHABET[i - key];
                        result.append(letter);
                        break;
                    } else if (i < key) {
                        int offset = (i) % alphabet.alphabetLength;
                        result.append(alphabet.ALPHABET[offset]);
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private char [] getText() throws IOException {

        // System.out.println("Please, write address your file: ");

        // Scanner scanner = new Scanner(System.in);
        // String test = scanner.nextLine();
        String test = "D://Cryptoanalyser/test.txt";

        List<String> list = Files.readAllLines(Path.of(test));

        StringBuilder builder1 = new StringBuilder();
        for (String x : list) {
            builder1.append(x);
        }
        char[] array = builder1.toString().toLowerCase().toCharArray();

        return array;
    }

    private int getKey() {
        System.out.println("Please, write KEY for your cipher: ");
        Scanner scanner = new Scanner(System.in);

        // сюда добавить проверки ключа

        return scanner.nextInt();
    }

}
