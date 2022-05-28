package ua.com.javaraush.shestakova.module1.Algorithms;

import ua.com.javaraush.shestakova.module1.ResursesFromUser.GetKey;
import ua.com.javaraush.shestakova.module1.ResursesFromUser.GetText;
import ua.com.javaraush.shestakova.module1.ResursesFromUser.WriteText;
import ua.com.javaraush.shestakova.module1.Other.Alphabet;

public class Coding {
    public static void startCoding() {

        int key = GetKey.getTheKey(System.out);
        checkKeyForCoding(key);

        String text = GetText.getTextFromUser();
        String result = AlgorithmCodingWithKey(text, key);

        WriteText.startWriting(result);
    }
    private static void checkKeyForCoding(int KEY) {

        if (Math.abs(KEY) > 100) {
            System.out.println("Надежность кодировки не зависит от размера числа, так что можно поменьше: ");
            startCoding();
        }
    }
    public static String AlgorithmCodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = Alphabet.alphabet.indexOf(text.charAt(i)); // получаю индекс буквы в алфавите, которую двигать
            int steps = (index + key) % Alphabet.alphabetLength; // на сколько двигать

            if (index < Math.abs(key) && (key < 0)) {
                result.append(Alphabet.alphabet.charAt(Alphabet.alphabetLength - Math.abs(steps)));
            } else {
                result.append(Alphabet.alphabet.charAt(steps));
            }
        }

        return result.toString();
    }
}
