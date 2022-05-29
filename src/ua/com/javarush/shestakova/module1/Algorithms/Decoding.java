package ua.com.javarush.shestakova.module1.Algorithms;

import ua.com.javarush.shestakova.module1.ResourcesFromUser.GetKey;
import ua.com.javarush.shestakova.module1.ResourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.ResourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.Date.Alphabet;

public class Decoding {
    public static void startDecoding() {

        int key = GetKey.getTheKey(System.out);

        String text = GetText.getTextFromUser();

        String result = DecodeWithKey(text, key);

        WriteText.startWriting(result);
    }

    public static String DecodeWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = Alphabet.alphabet.indexOf(text.charAt(i));
            int stepBack = (index - key) % Alphabet.alphabetLength;
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
