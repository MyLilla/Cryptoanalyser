package ua.com.javaraush.shestakova.module1.Algorithms;

import ua.com.javaraush.shestakova.module1.ResursesFromUser.GetKey;
import ua.com.javaraush.shestakova.module1.ResursesFromUser.GetText;
import ua.com.javaraush.shestakova.module1.ResursesFromUser.WriteText;
import ua.com.javaraush.shestakova.module1.Other.Alphabet;

public class Decoding {
    public static void startDecoding() {

        int key = GetKey.getTheKey(System.out);

        String text = GetText.getTextFromUser();

        String result = AlgorithmDecodingWithKey(text, key);

        WriteText.startWriting(result);
    }

    public static String AlgorithmDecodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = Alphabet.alphabet.indexOf(text.charAt(i)); // получаю индекс буквы в алфавите, которую двигать
            int stepBack = (index - key) % Alphabet.alphabetLength; // на сколько двигать
            if (stepBack < 0) {
                char encoding = Alphabet.alphabet.charAt(Alphabet.alphabetLength - Math.abs(stepBack));
                result.append(encoding);
            } else {
                char encoding = Alphabet.alphabet.charAt(stepBack);
                result.append(encoding);
            }
        }
        return result.toString();
    }
}
