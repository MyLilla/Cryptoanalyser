package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class encryption {

    public void operations() throws IOException {   // разобраться!!!

        unСipher();
    }

    private void unСipher() {

        int key = getKey();
        StringBuilder result = new StringBuilder();
        int index;

        String messege = "Иван - гроза всего диванаАААА";
        char[] ar = messege.toLowerCase().toCharArray();

        for (char x : ar) {
            for (int i = 0; i < alphabet.alphabetLength; i++) {
                if (x == alphabet.ALPHABET[i]) {
                    if (i == alphabet.alphabetLength - 1) {
                        x = alphabet.ALPHABET[0];
                        result.append(x);
                        break;
                    } else if (i > (alphabet.alphabetLength - key - 1)) {
                        index = i - alphabet.alphabetLength + key;
                        x = alphabet.ALPHABET[index];
                        result.append(x);
                        break;
                    } else if (i < (alphabet.alphabetLength - key)) {
                        x = alphabet.ALPHABET[i + key];
                        result.append(x);
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private Path getAddress() {
        System.out.println("Please, write address your file: ");

        Scanner scanner = new Scanner(System.in);
        String addressPath = scanner.nextLine();

        String test = "D://Cryptoanalyser/test.txt";

        Path path = Path.of(test);
        // сюда добавить проверки пути

        return path;
    }

    private int getKey() {
        System.out.println("Please, write key for your cipher: ");
        Scanner scanner = new Scanner(System.in);

        // сюда добавить проверки ключа

        return scanner.nextInt();
    }

}
