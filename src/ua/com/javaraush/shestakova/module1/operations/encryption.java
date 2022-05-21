package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class encryption {

    public void startEncryption () throws IOException{
       stepsEncryption();
    }
    private void stepsEncryption() throws IOException {

        int key = getKey();
        char[] textArray = getText();

        StringBuilder result = new StringBuilder();

        for (char letter : textArray) {
            for (int i = 0; i < alphabet.alphabetLength; i++) {
                if (letter == alphabet.ALPHABET[i]) {
                    if (i == alphabet.alphabetLength - 1) {
                        letter = alphabet.ALPHABET[key -1];
                        result.append(letter);
                        break;
                    } else if (i > (alphabet.alphabetLength - key - 1)) {
                        int offset = (i + key) % alphabet.alphabetLength;
                        result.append(alphabet.ALPHABET[offset]);
                        break;
                    } else if (i < (alphabet.alphabetLength - key)) {
                        letter = alphabet.ALPHABET[i + key];
                        result.append(letter);
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
